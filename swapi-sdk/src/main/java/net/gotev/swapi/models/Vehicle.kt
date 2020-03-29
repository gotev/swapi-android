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
 * A Vehicle resource is a single transport craft that does not have hyperdrive capability.
 *
 * @property name The name of this vehicle. The common name, such as "Sand Crawler" or "Speeder bike".
 * @property model The model or official name of this vehicle. Such as "All-Terrain Attack Transport".
 * @property rawManufacturers The manufacturer of this vehicle. Comma separated if more than one.
 * @property costInCredits The cost of this vehicle new, in Galactic Credits.
 * @property length The length of this vehicle in meters.
 * @property maxAtmospheringSpeed The maximum speed of this vehicle in the atmosphere.
 * @property crewNumber The number of personnel needed to run or pilot this vehicle.
 * @property maxPassengers The number of non-essential people this vehicle can transport.
 * @property cargoCapacity The maximum number of kilograms that this vehicle can transport.
 * @property consumablesDuration The maximum length of time that this vehicle can provide consumables for its entire crew without having to resupply.
 * @property vehicleClass The class of this vehicle, such as "Wheeled" or "Repulsorcraft".
 * @property charactersURLs An array of People URL Resources that this vehicle has been piloted by.
 * @property filmsURLs An array of Film URL Resources that this vehicle has appeared in.
 * @property created The ISO 8601 date format of the time that this resource was created.
 * @property edited The ISO 8601 date format of the time that this resource was edited.
 * @property url The hypermedia URL of this resource.
 */
@JsonClass(generateAdapter = true)
@Parcelize
data class Vehicle(
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
    @Json(name = "vehicle_class") val vehicleClass: String,
    @Json(name = "pilots") override val charactersURLs: List<String>,
    @Json(name = "films") override val filmsURLs: List<String>,
    override val created: OffsetDateTime,
    override val edited: OffsetDateTime,
    override val url: String
) : Parcelable, Identifiable, Purchasable, Transportable, HasCharacters, HasFilms, HasManufacturers
