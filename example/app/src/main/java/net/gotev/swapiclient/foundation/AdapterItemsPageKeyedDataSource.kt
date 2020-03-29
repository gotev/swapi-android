package net.gotev.swapiclient.foundation

import androidx.paging.PageKeyedDataSource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.runBlocking
import net.gotev.recycleradapter.AdapterItem

typealias PagedResponseService = suspend (Int) -> AdapterItemsPageKeyedDataSource.Response
typealias PagedResponseOnError = (Throwable) -> AdapterItem<*>

class AdapterItemsPageKeyedDataSource(
    private val scope: CoroutineScope,
    private val service: PagedResponseService,
    private val onError: PagedResponseOnError
) : PageKeyedDataSource<Int, AdapterItem<*>>() {

    data class Response(
        val items: List<AdapterItem<*>>,
        val nextPage: Int?,
        val previousPage: Int?
    )

    private fun load(page: Int): Response {
        return runBlocking(scope.coroutineContext) { service(page) }
    }

    override fun loadInitial(
        params: LoadInitialParams<Int>,
        callback: LoadInitialCallback<Int, AdapterItem<*>>
    ) {
        try {
            val response = load(1)
            callback.onResult(response.items, response.previousPage, response.nextPage)
        } catch (exc: Throwable) {
            callback.onResult(listOf(onError(exc)), null, null)
        }
    }

    override fun loadAfter(
        params: LoadParams<Int>,
        callback: LoadCallback<Int, AdapterItem<*>>
    ) {
        try {
            val response = load(params.key)
            callback.onResult(response.items, response.nextPage)
        } catch (exc: Throwable) {
            callback.onResult(listOf(onError(exc)), null)
        }
    }

    override fun loadBefore(
        params: LoadParams<Int>,
        callback: LoadCallback<Int, AdapterItem<*>>
    ) {
        try {
            val response = load(params.key)
            callback.onResult(response.items, response.previousPage)
        } catch (exc: Throwable) {
            callback.onResult(listOf(onError(exc)), null)
        }
    }
}
