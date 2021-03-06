package com.flixbus.timetable.api.response

import android.os.Parcelable
import androidx.annotation.Keep
import com.flixbus.timetable.model.Station
import com.flixbus.timetable.model.Timetable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

/**
 * Project           : FlixbusTimetable
 * File Name         : StationTimeTableResponse
 * Description       :
 * Revision History  : version 1
 * Date              : 20/01/22
 * Original author   : Kannappan
 * Description       : Initial version
 */
@Parcelize
@Keep
data class StationTimeTableResponse(
    @SerializedName("station")
    val station: Station = Station(),
    @SerializedName("timetable")
    val timetable: Timetable = Timetable()
) : Parcelable
