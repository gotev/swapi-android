package net.gotev.swapi.interfaces

import kotlinx.android.parcel.IgnoredOnParcel
import net.gotev.swapi.extensions.asLintedLowercaseCSVList
import net.gotev.swapi.extensions.lintManufacturer
import net.gotev.swapi.models.Manufacturer

interface HasManufacturers {
    val rawManufacturers: String

    @IgnoredOnParcel
    val manufacturers: List<Manufacturer>
        get() {
            val allValues = Manufacturer.values()

            return rawManufacturers.asLintedLowercaseCSVList()
                .map { rawValue ->
                    allValues.firstOrNull { it.rawValue == rawValue.lintManufacturer() }
                        ?: Manufacturer.Unknown
                }
        }
}
