package com.flixbus.timetable.util

import android.util.Log
import java.text.SimpleDateFormat
import java.util.*
import java.util.concurrent.TimeUnit

/**
 * Project           : FlixbusTimetable
 * File Name         : DateTimeUtils
 * Description       :
 * Revision History  : version 1
 * Date              : 20/01/22
 * Original author   : Kannappan
 * Description       : Initial version
 */
object DateTimeUtils {
    private const val TAG = "DateTimeUtils"
    fun getTimeBasedOnTimezone(datePattern: String, timezoneId: String, timestampInSeconds: Long): String {
        val timestampMillis = TimeUnit.SECONDS.toMillis(timestampInSeconds)
        val simpleDateFormat = SimpleDateFormat(datePattern, Locale.getDefault())
        simpleDateFormat.timeZone = TimeZone.getTimeZone(timezoneId)
        Log.d(
            TAG,
            "Timestamp: $timestampInSeconds , $timezoneId: ${simpleDateFormat.format(timestampMillis)}"
        )
        return simpleDateFormat.format(timestampMillis) ?: ""
    }
}