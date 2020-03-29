package net.gotev.swapi.models

import android.os.Parcelable
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import kotlinx.android.parcel.Parcelize
import net.gotev.swapi.interfaces.HasCharacters
import net.gotev.swapi.interfaces.HasEyeColors
import net.gotev.swapi.interfaces.HasFilms
import net.gotev.swapi.interfaces.HasHairColors
import net.gotev.swapi.interfaces.HasHomeworld
import net.gotev.swapi.interfaces.HasSkinColors
import net.gotev.swapi.interfaces.Identifiable
import net.gotev.swapi.interfaces.ShortDescriptable
import org.threeten.bp.OffsetDateTime

/**
 * A Specie is a type of person or character within the Star Wars Universe.
 *
 * @property name The name of this species.
 * @property classification The classification of this species, such as "mammal" or "reptile".
 * @property designation The designation of this species, such as "sentient".
 * @property averageHeight The average height of this species in centimeters.
 * @property rawSkinColors A comma-separated string of common skin colors for this species, "none" if this species does not typically have skin.
 * @property rawHairColors A comma-separated string of common hair colors for this species, "none" if this species does not typically have hair.
 * @property rawEyeColors A comma-separated string of common eye colors for this species, "none" if this species does not typically have eyes.
 * @property averageLifespan The average lifespan of this species in years.
 * @property homeworldURL The URL of a planet resource, a planet that this species originates from.
 * @property language The language commonly spoken by this species.
 * @property charactersURLs An array of People URL Resources that are a part of this species.
 * @property filmsURLs An array of Film URL Resources that this species has appeared in.
 * @property created The ISO 8601 date format of the time that this resource was created.
 * @property edited The ISO 8601 date format of the time that this resource was edited.
 * @property url The hypermedia URL of this resource.
 */
@JsonClass(generateAdapter = true)
@Parcelize
class Specie(
    val name: String,
    val classification: String,
    val designation: String,
    @Json(name = "average_lifespan") val averageLifespan: String,
    @Json(name = "average_height") val averageHeight: String,
    val language: String,
    @Json(name = "skin_colors") override val rawSkinColors: String,
    @Json(name = "hair_colors") override val rawHairColors: String,
    @Json(name = "eye_colors") override val rawEyeColors: String,
    @Json(name = "homeworld") override val homeworldURL: String?,
    @Json(name = "people") override val charactersURLs: List<String>,
    @Json(name = "films") override val filmsURLs: List<String>,
    override val created: OffsetDateTime,
    override val edited: OffsetDateTime,
    override val url: String
) : Parcelable, Identifiable, HasHomeworld, HasCharacters, HasFilms, HasHairColors, HasSkinColors,
    HasEyeColors, ShortDescriptable {
    override val shortDescription: String
        get() = name
}
