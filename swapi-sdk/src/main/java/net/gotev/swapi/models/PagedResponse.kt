package net.gotev.swapi.models

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

/**
 * An API paged response.
 *
 * @property count Total number of elements of this resource.
 * @property nextURL URL of the next page. null if there's no next page.
 * @property previousURL URL of the previous page. null if there's no previous page.
 * @property results List of the results contained in this page.
 */
@JsonClass(generateAdapter = true)
data class PagedResponse<T : Any>(
    val count: Int,
    @Json(name = "next") val nextURL: String?,
    @Json(name = "previous") val previousURL: String?,
    val results: List<T>
) {
    private fun String.page() = split("=").last().toInt()

    internal val nextPage: Int?
        get() = nextURL?.page()

    internal val previousPage: Int?
        get() = previousURL?.page()
}
