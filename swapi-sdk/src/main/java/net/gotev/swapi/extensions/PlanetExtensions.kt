package net.gotev.swapi.extensions

import kotlinx.coroutines.coroutineScope
import net.gotev.swapi.models.PagedResponse
import net.gotev.swapi.models.Planet
import net.gotev.swapi.swapiClient

private suspend fun PagedResponse<Planet>.fetch(page: Int?) = page?.let {
    coroutineScope {
        swapiClient.planets(page = it)
    }
}

suspend fun PagedResponse<Planet>.nextPage() = fetch(nextPage)
suspend fun PagedResponse<Planet>.previousPage() = fetch(previousPage)
