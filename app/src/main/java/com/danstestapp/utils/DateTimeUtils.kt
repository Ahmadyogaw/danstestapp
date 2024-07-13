package com.danstestapp.utils

import org.ocpsoft.prettytime.PrettyTime
import java.text.SimpleDateFormat
import java.util.Locale
import java.util.TimeZone

class DateTimeUtils {
    fun convertToRelativeTime(dateString: String): String {
        // Define the date format
        val dateFormat = SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy", Locale.ENGLISH)
        dateFormat.timeZone = TimeZone.getTimeZone("UTC")

        // Parse the date string
        val parsedDate = dateFormat.parse(dateString)

        // Create PrettyTime instance
        val prettyTime = PrettyTime(Locale.ENGLISH)

        // Convert to relative time
        return prettyTime.format(parsedDate)
    }
}