package net.gotev.swapi.interfaces

import kotlinx.android.parcel.IgnoredOnParcel
import net.gotev.swapi.extensions.asCSVList

/**
 * Something which has climates.
 */
interface HasClimates {
    val rawClimates: String

    @IgnoredOnParcel
    val climates: List<String>
        get() = rawClimates.asCSVList()
}
