package com.flixbus.timetable.model


import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Departure(
    @SerializedName("datetime")
    val datetime: DatetimeX = DatetimeX(),
    @SerializedName("direction")
    val direction: String = "",
    @SerializedName("has_tracker")
    val hasTracker: Boolean = false,
    @SerializedName("is_cancelled")
    val isCancelled: Boolean = false,
    @SerializedName("line_code")
    val lineCode: String = "",
    @SerializedName("line_direction")
    val lineDirection: String = "",
    @SerializedName("ride_id")
    val rideId: Int = 0,
    @SerializedName("route")
    val route: List<RouteX> = listOf(),
    @SerializedName("through_the_stations")
    val throughTheStations: String = "",
    @SerializedName("trip_uid")
    val tripUid: String = ""
) : Parcelable