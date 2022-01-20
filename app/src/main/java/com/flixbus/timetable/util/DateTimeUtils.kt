package com.flixbus.timetable.util

import java.text.SimpleDateFormat
import java.util.*

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

    fun getTimeBasedOnTimezone(datePattern: String, timezoneId: String, timestamp: Long): String {
        val simpleDateFormat = SimpleDateFormat(datePattern, Locale.ENGLISH)
        simpleDateFormat.timeZone = TimeZone.getTimeZone(timezoneId)
        return simpleDateFormat.format(timestamp) ?:""
    }
}