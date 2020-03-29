package net.gotev.swapi.interfaces

import kotlinx.android.parcel.IgnoredOnParcel
import net.gotev.swapi.extensions.asCSVList
import net.gotev.swapi.models.EyeColor
import java.util.Locale

/**
 * Something which has a set of eye colors.
 */
interface HasEyeColors {
    val rawEyeColors: String

    @IgnoredOnParcel
    val eyeColors: List<EyeColor>
        get() {
            val values = EyeColor.values()

            return rawEyeColors.asCSVList().map { value ->
                values.firstOrNull { it.rawValue == value.toLowerCase(Locale.getDefault()) }
                    ?: EyeColor.Unknown
            }
        }
}
