package net.gotev.swapi.helpers

import com.squareup.moshi.FromJson
import com.squareup.moshi.ToJson
import org.threeten.bp.LocalDate
import org.threeten.bp.OffsetDateTime
import org.threeten.bp.format.DateTimeFormatter

class Iso8601DateTimeTypeAdapter {

    private val dateTimeFormatter = DateTimeFormatter.ISO_OFFSET_DATE_TIME
    private val dateFormatter = DateTimeFormatter.ISO_LOCAL_DATE

    @FromJson
    fun fromOffsetDateTimeJson(string: String?) =
        string?.let { dateTimeFormatter.parse(it, OffsetDateTime::from) }

    @ToJson
    fun toOffsetDateTimeJson(date: OffsetDateTime?) =
        date?.format(dateTimeFormatter)

    @FromJson
    fun fromLocalDateJson(string: String?) =
        string?.let { dateFormatter.parse(it, LocalDate::from) }

    @ToJson
    fun toLocalDateJson(date: LocalDate?) =
        date?.format(dateFormatter)
}
