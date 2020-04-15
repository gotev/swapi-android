package net.gotev.swapi.interfaces

import net.gotev.swapi.extensions.parallelMap
import net.gotev.swapi.swapiClient

/**
 * Something which has a relation with planets.
 */
interface HasPlanets {
    val planetsURLs: List<String>

    suspend fun planets() = planetsURLs.parallelMap { swapiClient.planet(it) }
}
