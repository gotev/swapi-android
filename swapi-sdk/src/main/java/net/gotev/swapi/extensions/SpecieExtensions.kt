package net.gotev.swapi.extensions

import kotlinx.coroutines.coroutineScope
import net.gotev.swapi.models.PagedResponse
import net.gotev.swapi.models.Specie
import net.gotev.swapi.swapiClient

private suspend fun PagedResponse<Specie>.fetch(page: Int?) = page?.let {
    coroutineScope {
        swapiClient.species(page = it)
    }
}

suspend fun PagedResponse<Specie>.nextPage() = fetch(nextPage)
suspend fun PagedResponse<Specie>.previousPage() = fetch(previousPage)
