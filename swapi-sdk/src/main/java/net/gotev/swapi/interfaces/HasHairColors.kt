package net.gotev.swapi.interfaces

import kotlinx.android.parcel.IgnoredOnParcel
import net.gotev.swapi.extensions.asCSVList
import net.gotev.swapi.models.HairColor
import java.util.Locale

/**
 * Something which has a set of hair colors.
 */
interface HasHairColors {
    val rawHairColors: String

    @IgnoredOnParcel
    val hairColors: List<HairColor>
        get() {
            val values = HairColor.values()

            return rawHairColors.asCSVList().map { value ->
                values.firstOrNull { it.rawValue == value.toLowerCase(Locale.getDefault()) }
                    ?: HairColor.Unknown
            }
        }
}
