package com.flixbus.timetable.model


import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class TimetableX(
    @SerializedName("arrivals")
    val arrivals: List<Arrival> = listOf(),
    @SerializedName("departures")
    val departures: List<Departure> = listOf(),
    @SerializedName("message")
    val message: String = ""
) : Parcelable