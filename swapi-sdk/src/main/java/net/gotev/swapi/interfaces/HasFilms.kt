package net.gotev.swapi.interfaces

import net.gotev.swapi.extensions.mapAsync
import net.gotev.swapi.swapiClient

/**
 * Something which has a relation with films.
 */
interface HasFilms {
    val filmsURLs: List<String>

    suspend fun films() = filmsURLs.mapAsync { swapiClient.film(it) }
}
