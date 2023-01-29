package com.rax.core.convertor

import com.squareup.moshi.FromJson
import com.squareup.moshi.ToJson
import org.joda.time.DateTime
import org.joda.time.format.DateTimeFormat

class DateTimeMoshiAdapter {

    @FromJson
    fun fromJson(json: String): DateTime {
        return DateTime(json)
    }

    @ToJson
    fun toJson(dateTime: DateTime): String {
        val dateTimeFormat = DateTimeFormat.forPattern("yyyy-MM-dd'T'HH:mm:ssZZ")
        return dateTimeFormat.print(dateTime)
    }
}
