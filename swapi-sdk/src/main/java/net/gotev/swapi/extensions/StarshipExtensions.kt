package net.gotev.swapi.extensions

import kotlinx.coroutines.coroutineScope
import net.gotev.swapi.models.PagedResponse
import net.gotev.swapi.models.Starship
import net.gotev.swapi.swapiClient

private suspend fun PagedResponse<Starship>.fetch(page: Int?) = page?.let {
    coroutineScope {
        swapiClient.starships(page = it)
    }
}

suspend fun PagedResponse<Starship>.nextPage() = fetch(nextPage)
suspend fun PagedResponse<Starship>.previousPage() = fetch(previousPage)
