package net.gotev.swapi.models

import android.os.Parcelable
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import kotlinx.android.parcel.Parcelize
import net.gotev.swapi.interfaces.HasEyeColors
import net.gotev.swapi.interfaces.HasFilms
import net.gotev.swapi.interfaces.HasHairColors
import net.gotev.swapi.interfaces.HasHomeworld
import net.gotev.swapi.interfaces.HasSkinColors
import net.gotev.swapi.interfaces.HasSpecies
import net.gotev.swapi.interfaces.HasStarships
import net.gotev.swapi.interfaces.HasVehicles
import net.gotev.swapi.interfaces.Identifiable
import net.gotev.swapi.interfaces.ShortDescriptable
import org.threeten.bp.OffsetDateTime

/**
 * This is an individual person or character within the Star Wars universe.
 *
 * @property name The name of this person.
 * @property height The height of the person in centimeters.
 * @property mass The mass of the person in kilograms.
 * @property rawHairColors The hair color of this person. Will be "unknown" if not known or "n/a" if the person does not have hair.
 * @property rawSkinColors The skin color of this person.
 * @property rawEyeColors The eye color of this person. Will be "unknown" if not known or "n/a" if the person does not have an eye.
 * @property birthYear The birth year of the person, using the in-universe standard of BBY or ABY - Before the Battle of Yavin or After the Battle of Yavin. The Battle of Yavin is a battle that occurs at the end of Star Wars episode IV: A New Hope.
 * @property gender The gender of this person. Either "Male", "Female" or "unknown", "n/a" if the person does not have a gender.
 * @property homeworldURL The URL of a planet resource, a planet that this person was born on or inhabits.
 * @property filmsURLs An array of film resource URLs that this person has been in.
 * @property speciesURLs An array of species resource URLs that this person belongs to.
 * @property vehiclesURLs An array of vehicle resource URLs that this person has piloted.
 * @property starshipsURLs An array of starship resource URLs that this person has piloted.
 * @property created The ISO 8601 date format of the time that this resource was created.
 * @property edited The ISO 8601 date format of the time that this resource was edited.
 * @property url The hypermedia URL of this resource.
 */
@JsonClass(generateAdapter = true)
@Parcelize
data class Character(
    val name: String,
    val height: String,
    val mass: String,
    @Json(name = "birth_year") val birthYear: String,
    val gender: Gender,
    @Json(name = "hair_color") override val rawHairColors: String,
    @Json(name = "skin_color") override val rawSkinColors: String,
    @Json(name = "eye_color") override val rawEyeColors: String,
    @Json(name = "homeworld") override val homeworldURL: String,
    @Json(name = "films") override val filmsURLs: List<String>,
    @Json(name = "species") override val speciesURLs: List<String>,
    @Json(name = "vehicles") override val vehiclesURLs: List<String>,
    @Json(name = "starships") override val starshipsURLs: List<String>,
    override val created: OffsetDateTime,
    override val edited: OffsetDateTime,
    override val url: String
) : Parcelable, Identifiable, HasHomeworld, HasFilms, HasSpecies, HasVehicles, HasStarships,
    HasHairColors, HasSkinColors, HasEyeColors, ShortDescriptable {
    override val shortDescription: String
        get() = name
}
