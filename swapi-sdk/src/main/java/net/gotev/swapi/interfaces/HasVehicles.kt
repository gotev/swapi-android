package net.gotev.swapi.interfaces

import net.gotev.swapi.extensions.parallelMap
import net.gotev.swapi.swapiClient

/**
 * Something which has a relation with vehicles.
 */
interface HasVehicles {
    val vehiclesURLs: List<String>

    suspend fun vehicles() = vehiclesURLs.parallelMap { swapiClient.vehicle(it) }
}
