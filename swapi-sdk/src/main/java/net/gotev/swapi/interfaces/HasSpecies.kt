package net.gotev.swapi.interfaces

import net.gotev.swapi.extensions.parallelMap
import net.gotev.swapi.swapiClient

/**
 * Something which has a relation with species.
 */
interface HasSpecies {
    val speciesURLs: List<String>

    suspend fun species() = speciesURLs.parallelMap { swapiClient.specie(it) }
}
