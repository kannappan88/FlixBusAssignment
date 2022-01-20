package com.flixbus.timetable.api.response

/**
 * Project           : FlixbusTimetable
 * File Name         : ResponseData
 * Description       :
 * Revision History  : version 1
 * Date              : 20/01/22
 * Original author   : Kannappan
 * Description       : Initial version
 */
data class ResponseData<out T>(val data: T?, val message: String?, val status: ResponseStatus)

