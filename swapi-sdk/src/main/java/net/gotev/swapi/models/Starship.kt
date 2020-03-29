package net.gotev.swapi.models

import android.os.Parcelable
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import kotlinx.android.parcel.Parcelize
import net.gotev.swapi.interfaces.Purchasable
import net.gotev.swapi.interfaces.HasCharacters
import net.gotev.swapi.interfaces.HasFilms
import net.gotev.swapi.interfaces.HasManufacturers
import net.gotev.swapi.interfaces.Identifiable
import net.gotev.swapi.interfaces.Transportable
import org.threeten.bp.OffsetDateTime

/**
 * A Starship resource is a single transport craft that has hyperdrive capability.
 *
 * @property name The name of this starship. The common name, such as "Death Star".
 * @property model The model or official name of this starship. Such as "T-65 X-wing" or "DS-1 Orbital Battle Station".
 * @property rawManufacturers The manufacturer of this starship. Comma separated if more than one.
 * @property costInCredits The cost of this starship new, in galactic credits.
 * @property length The length of this starship in meters.
 * @property maxAtmospheringSpeed The maximum speed of this starship in the atmosphere. "N/A" if this starship is incapable of atmospheric flight.
 * @property crewNumber The number of personnel needed to run or pilot this starship.
 * @property maxPassengers The number of non-essential people this starship can transport.
 * @property cargoCapacity The maximum number of kilograms that this starship can transport.
 * @property consumablesDuration The maximum length of time that this starship can provide consumables for its entire crew without having to resupply.
 * @property starshipClass The class of this starship, such as "Starfighter" or "Deep Space Mobile Battlestation"
 * @property hyperdriveRating The class of this starships hyperdrive.
 * @property maxMegalights The Maximum number of Megalights this starship can travel in a standard hour. A "Megalight" is a standard unit of
 * distance and has never been defined before within the Star Wars universe. This figure is only really useful for measuring the difference
 * in speed of starships. We can assume it is similar to AU, the distance between our Sun (Sol) and Earth.
 * @property charactersURLs An array of People URL Resources that this starship has been piloted by.
 * @property filmsURLs An array of Film URL Resources that this starship has appeared in.
 * @property created The ISO 8601 date format of the time that this resource was created.
 * @property edited The ISO 8601 date format of the time that this resource was edited.
 * @property url The hypermedia URL of this resource.
 */
@JsonClass(generateAdapter = true)
@Parcelize
data class Starship(
    @Json(name = "starship_class") val starshipClass: String,
    @Json(name = "hyperdrive_rating") val hyperdriveRating: String,
    @Json(name = "MGLT") val maxMegalights: String,
    override val name: String,
    override val model: String,
    @Json(name = "manufacturer") override val rawManufacturers: String,
    @Json(name = "cost_in_credits") override val costInCredits: String,
    override val length: String,
    @Json(name = "max_atmosphering_speed") override val maxAtmospheringSpeed: String,
    @Json(name = "crew") override val crewNumber: String,
    @Json(name = "passengers") override val maxPassengers: String,
    @Json(name = "cargo_capacity") override val cargoCapacity: String,
    @Json(name = "consumables") override val consumablesDuration: String,
    @Json(name = "pilots") override val charactersURLs: List<String>,
    @Json(name = "films") override val filmsURLs: List<String>,
    override val created: OffsetDateTime,
    override val edited: OffsetDateTime,
    override val url: String
) : Parcelable, Identifiable, Purchasable, Transportable, HasCharacters, HasFilms, HasManufacturers
