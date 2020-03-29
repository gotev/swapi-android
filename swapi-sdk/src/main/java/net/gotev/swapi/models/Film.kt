package net.gotev.swapi.models

import android.os.Parcelable
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import kotlinx.android.parcel.Parcelize
import net.gotev.swapi.interfaces.HasCharacters
import net.gotev.swapi.interfaces.HasPlanets
import net.gotev.swapi.interfaces.HasProducers
import net.gotev.swapi.interfaces.HasSpecies
import net.gotev.swapi.interfaces.HasStarships
import net.gotev.swapi.interfaces.HasVehicles
import net.gotev.swapi.interfaces.Identifiable
import net.gotev.swapi.interfaces.ShortDescriptable
import org.threeten.bp.LocalDate
import org.threeten.bp.OffsetDateTime

/**
 * A film of the Star Wars Saga.
 *
 * @property episodeNumber The episode number of this film.
 * @property title The title of this film.
 * @property openingCrawl The opening paragraphs at the beginning of this film.
 * @property director The name of the director of this film.
 * @property rawProducers The name(s) of the producer(s) of this film. Comma separated.
 * @property releaseDate The ISO 8601 date format of film release at original creator country.
 * @property charactersURLs An array of people resource URLs that are in this film.
 * @property planetsURLs An array of planet resource URLs that are in this film.
 * @property starshipsURLs An array of starship resource URLs that are in this film.
 * @property vehiclesURLs An array of vehicle resource URLs that are in this film.
 * @property speciesURLs An array of species resource URLs that are in this film.
 * @property created The ISO 8601 date format of the time that this resource was created.
 * @property edited The ISO 8601 date format of the time that this resource was edited.
 * @property url The hypermedia URL of this resource.
 */
@JsonClass(generateAdapter = true)
@Parcelize
data class Film(
    @Json(name = "episode_id") val episodeNumber: String,
    val title: String,
    @Json(name = "opening_crawl") val openingCrawl: String,
    val director: String,
    @Json(name = "release_date") val releaseDate: LocalDate,
    @Json(name = "producer") override val rawProducers: String,
    @Json(name = "characters") override val charactersURLs: List<String>,
    @Json(name = "planets") override val planetsURLs: List<String>,
    @Json(name = "starships") override val starshipsURLs: List<String>,
    @Json(name = "vehicles") override val vehiclesURLs: List<String>,
    @Json(name = "species") override val speciesURLs: List<String>,
    override val created: OffsetDateTime,
    override val edited: OffsetDateTime,
    override val url: String
) : Parcelable, Identifiable, HasPlanets, HasStarships, HasVehicles, HasSpecies, HasCharacters,
    HasProducers, ShortDescriptable {
    override val shortDescription: String
        get() = title
}
