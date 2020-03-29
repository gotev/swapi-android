package net.gotev.swapi.interfaces

import net.gotev.swapi.swapiClient

/**
 * Something which has a homeworld.
 */
interface HasHomeworld {
    val homeworldURL: String?

    suspend fun homeworld() = homeworldURL?.let { swapiClient.planet(it) }
}
