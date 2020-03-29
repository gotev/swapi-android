package net.gotev.swapi.extensions

import kotlinx.coroutines.coroutineScope
import net.gotev.swapi.models.Character
import net.gotev.swapi.models.PagedResponse
import net.gotev.swapi.swapiClient

private suspend fun PagedResponse<Character>.fetch(page: Int?) = page?.let {
    coroutineScope {
        swapiClient.characters(page = it)
    }
}

suspend fun PagedResponse<Character>.nextPage() = fetch(nextPage)
suspend fun PagedResponse<Character>.previousPage() = fetch(previousPage)
