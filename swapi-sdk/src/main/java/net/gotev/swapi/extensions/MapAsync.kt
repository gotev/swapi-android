package net.gotev.swapi.extensions

import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope

// https://stackoverflow.com/a/58659423
// Equivalent of RxJava's Zip Operator
suspend fun <T, R> Iterable<T>.mapAsync(action: suspend (T) -> R) = coroutineScope {
    map {
        async { action(it) }
    }.map {
        it.await()
    }
}
