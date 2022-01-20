package com.flixbus.timetable.model


import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class TimeTable(
    @SerializedName("station")
    val station: Station = Station(),
    @SerializedName("timetable")
    val timetable: TimetableX = TimetableX()
) : Parcelable