package com.flixbus.timetable.api.response

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

/**
 * Project           : FlixbusTimetable
 * File Name         : EroorResponse
 * Description       :
 * Revision History  : version 1
 * Date              : 20/01/22
 * Original author   : Kannappan
 * Description       : Initial version
 */
@Parcelize
data class ErrorResponse(
    val errorCode: Int,
    val errorMessage: String
) : Parcelable