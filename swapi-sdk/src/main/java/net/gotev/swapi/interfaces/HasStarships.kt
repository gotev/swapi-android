package net.gotev.swapi.interfaces

import net.gotev.swapi.extensions.parallelMap
import net.gotev.swapi.swapiClient

/**
 * Something which has a relation with starships.
 */
interface HasStarships {
    val starshipsURLs: List<String>

    suspend fun starships() = starshipsURLs.parallelMap { swapiClient.starship(it) }
}
