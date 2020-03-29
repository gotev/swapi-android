package net.gotev.swapi.interfaces

import net.gotev.swapi.extensions.mapAsync
import net.gotev.swapi.swapiClient

/**
 * Something which has a relation with planets.
 */
interface HasPlanets {
    val planetsURLs: List<String>

    suspend fun planets() = planetsURLs.mapAsync { swapiClient.planet(it) }
}
