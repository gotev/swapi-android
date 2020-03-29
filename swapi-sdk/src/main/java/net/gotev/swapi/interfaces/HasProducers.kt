package net.gotev.swapi.interfaces

import kotlinx.android.parcel.IgnoredOnParcel
import net.gotev.swapi.extensions.asCSVList

/**
 * Something which has producers.
 */
interface HasProducers {
    val rawProducers: String

    @IgnoredOnParcel
    val producers: List<String>
        get() = rawProducers.asCSVList()
}
