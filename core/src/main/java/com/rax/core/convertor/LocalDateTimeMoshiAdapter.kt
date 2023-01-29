package com.rax.core.convertor

import com.squareup.moshi.FromJson
import com.squareup.moshi.ToJson
import org.joda.time.DateTime
import org.joda.time.LocalDate
import org.joda.time.format.DateTimeFormat

class LocalDateTimeMoshiAdapter {

    @FromJson
    fun fromJson(json: String): LocalDate {
        return LocalDate(json)
    }

    @ToJson
    fun toJson(dateTime: DateTime): String {
        val dateTimeFormat = DateTimeFormat.forPattern("yyyy-MM-ddZ")
        return dateTimeFormat.print(dateTime)
    }
}
