package net.gotev.swapi.extensions

import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.coroutineScope
import kotlin.coroutines.CoroutineContext
import kotlin.coroutines.EmptyCoroutineContext

// https://stackoverflow.com/a/58659423
// Equivalent of RxJava's Zip Operator
suspend fun <T, R> Iterable<T>.parallelMap(
    context: CoroutineContext = EmptyCoroutineContext,
    action: suspend (T) -> R
) = coroutineScope {
    map {
        async(context) { action(it) }
    }.awaitAll()
}
