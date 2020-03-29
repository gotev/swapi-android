package net.gotev.swapi.interfaces

import net.gotev.swapi.extensions.mapAsync
import net.gotev.swapi.swapiClient

/**
 * Something which has a relation with species.
 */
interface HasSpecies {
    val speciesURLs: List<String>

    suspend fun species() = speciesURLs.mapAsync { swapiClient.specie(it) }
}
