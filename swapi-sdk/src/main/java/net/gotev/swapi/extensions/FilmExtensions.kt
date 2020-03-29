package net.gotev.swapi.extensions

import kotlinx.coroutines.coroutineScope
import net.gotev.swapi.models.Film
import net.gotev.swapi.models.PagedResponse
import net.gotev.swapi.swapiClient

private suspend fun PagedResponse<Film>.fetch(page: Int?) = page?.let {
    coroutineScope {
        swapiClient.films(page = it)
    }
}

suspend fun PagedResponse<Film>.nextPage() = fetch(nextPage)
suspend fun PagedResponse<Film>.previousPage() = fetch(previousPage)
