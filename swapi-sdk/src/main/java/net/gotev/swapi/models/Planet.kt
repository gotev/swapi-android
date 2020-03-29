package net.gotev.swapi.models

import android.os.Parcelable
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import kotlinx.android.parcel.Parcelize
import net.gotev.swapi.interfaces.HasCharacters
import net.gotev.swapi.interfaces.HasClimates
import net.gotev.swapi.interfaces.HasFilms
import net.gotev.swapi.interfaces.HasTerrains
import net.gotev.swapi.interfaces.Identifiable
import net.gotev.swapi.interfaces.ShortDescriptable
import org.threeten.bp.OffsetDateTime

/**
 * A Planet is a large mass, planet or planetoid in the Star Wars Universe, at the time of 0 ABY.
 *
 * @property name The name of this planet.
 * @property rotationPeriod The number of standard hours it takes for this planet to complete a single rotation on its axis.
 * @property orbitalPeriod The number of standard days it takes for this planet to complete a single orbit of its local star.
 * @property diameter The diameter of this planet in kilometers.
 * @property rawClimates The climate of this planet. Comma separated if diverse.
 * @property gravity A number denoting the gravity of this planet, where "1" is normal or 1 standard G. "2" is twice or 2 standard Gs. "0.5" is half or 0.5 standard Gs.
 * @property rawTerrains The terrain of this planet. Comma separated if diverse.
 * @property surfaceWater The percentage of the planet surface that is naturally occurring water or bodies of water.
 * @property population The average population of sentient beings inhabiting this planet.
 * @property charactersURLs An array of People URL Resources that live on this planet.
 * @property filmsURLs An array of Film URL Resources that this planet has appeared in.
 * @property created The ISO 8601 date format of the time that this resource was created.
 * @property edited The ISO 8601 date format of the time that this resource was edited.
 * @property url The hypermedia URL of this resource.
 */
@JsonClass(generateAdapter = true)
@Parcelize
data class Planet(
    val name: String,
    @Json(name = "rotation_period") val rotationPeriod: String,
    @Json(name = "orbital_period") val orbitalPeriod: String,
    val diameter: String,
    val gravity: String,
    val population: String,
    @Json(name = "surface_water") val surfaceWater: String,
    @Json(name = "climate") override val rawClimates: String,
    @Json(name = "terrain") override val rawTerrains: String,
    @Json(name = "residents") override val charactersURLs: List<String>,
    @Json(name = "films") override val filmsURLs: List<String>,
    override val created: OffsetDateTime,
    override val edited: OffsetDateTime,
    override val url: String
) : Parcelable, Identifiable, HasCharacters, HasFilms, HasTerrains, HasClimates, ShortDescriptable {
    override val shortDescription: String
        get() = name
}
