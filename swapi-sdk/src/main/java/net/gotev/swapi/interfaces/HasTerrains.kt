package net.gotev.swapi.interfaces

import kotlinx.android.parcel.IgnoredOnParcel
import net.gotev.swapi.extensions.asCSVList

/**
 * Something which has terrains.
 */
interface HasTerrains {
    val rawTerrains: String

    @IgnoredOnParcel
    val terrains: List<String>
        get() = rawTerrains.asCSVList()
}
