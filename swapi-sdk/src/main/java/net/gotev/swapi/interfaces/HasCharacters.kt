package net.gotev.swapi.interfaces

import net.gotev.swapi.extensions.mapAsync
import net.gotev.swapi.swapiClient

/**
 * Something which has a relation with characters.
 */
interface HasCharacters {
    val charactersURLs: List<String>

    suspend fun characters() = charactersURLs.mapAsync { swapiClient.character(it) }
}
