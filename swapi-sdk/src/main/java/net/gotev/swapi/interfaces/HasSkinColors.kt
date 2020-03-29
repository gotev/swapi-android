package net.gotev.swapi.interfaces

import kotlinx.android.parcel.IgnoredOnParcel
import net.gotev.swapi.extensions.asCSVList
import net.gotev.swapi.models.SkinColor
import java.util.Locale

/**
 * Something which has a set of skin colors.
 */
interface HasSkinColors {
    val rawSkinColors: String

    @IgnoredOnParcel
    val skinColors: List<SkinColor>
        get() {
            val values = SkinColor.values()

            return rawSkinColors.asCSVList().map { value ->
                values.firstOrNull { it.rawValue == value.toLowerCase(Locale.getDefault()) }
                    ?: SkinColor.Unknown
            }
        }
}
