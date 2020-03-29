package net.gotev.swapi.models

import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.android.parcel.Parcelize

/**
 * Represents a character gender.
 */
@Parcelize
enum class Gender : Parcelable {
    @Json(name = "male")
    Male,

    @Json(name = "female")
    Female,

    @Json(name = "hermaphrodite")
    Hermaphrodite,

    @Json(name = "unknown")
    Unknown,

    @Json(name = "n/a")
    NotAvailable,

    @Json(name = "none")
    None
}
