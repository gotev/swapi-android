package net.gotev.swapiclient.fetcher

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

typealias CoroutineService<Input, Output> = suspend (Input) -> Output

class CoroutineFetcher<Input : Any?, Output : Any>(
    private val coroutineScope: CoroutineScope,
    private val service: CoroutineService<Input, Output>
) {
    private val internalSuccess = MutableLiveData<Output>()
    private val internalError = MutableLiveData<Throwable>()
    private val internalLoading = MutableLiveData<Boolean>()

    val success: LiveData<Output>
        get() = internalSuccess

    val error: LiveData<Throwable>
        get() = internalError

    val loading: LiveData<Boolean>
        get() = internalLoading

    fun fetch(input: Input) {
        coroutineScope.launch(Dispatchers.IO) {
            internalLoading.postValue(true)
            runCatching { service(input) }
                .onSuccess {
                    internalLoading.postValue(false)
                    internalSuccess.postValue(it)
                }
                .onFailure {
                    internalLoading.postValue(false)
                    internalError.postValue(it)
                }
        }
    }
}
