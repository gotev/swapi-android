package net.gotev.swapiclient.fetcher

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope

fun <Input : Any?, Output : Any> ViewModel.inputFetcher(service: CoroutineService<Input, Output>) =
    CoroutineFetcher(viewModelScope, service)

fun <Output : Any> ViewModel.fetcher(service: CoroutineService<Unit, Output>) =
    CoroutineFetcher(viewModelScope, service)

fun <Output : Any> CoroutineFetcher<Unit, Output>.fetch() {
    fetch(Unit)
}
