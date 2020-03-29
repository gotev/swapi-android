package net.gotev.swapi.extensions

import kotlinx.coroutines.coroutineScope
import net.gotev.swapi.models.PagedResponse
import net.gotev.swapi.models.Vehicle
import net.gotev.swapi.swapiClient

private suspend fun PagedResponse<Vehicle>.fetch(page: Int?) = page?.let {
    coroutineScope {
        swapiClient.vehicles(page = it)
    }
}

suspend fun PagedResponse<Vehicle>.nextPage() = fetch(nextPage)
suspend fun PagedResponse<Vehicle>.previousPage() = fetch(previousPage)
