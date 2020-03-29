package net.gotev.swapi.interfaces

import net.gotev.swapi.extensions.mapAsync
import net.gotev.swapi.swapiClient

/**
 * Something which has a relation with vehicles.
 */
interface HasVehicles {
    val vehiclesURLs: List<String>

    suspend fun vehicles() = vehiclesURLs.mapAsync { swapiClient.vehicle(it) }
}
