package com.flixbus.timetable.model


import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Datetime(
    @SerializedName("timestamp")
    val timestamp: Long = 0,
    @SerializedName("tz")
    val tz: String = ""
) : Parcelable