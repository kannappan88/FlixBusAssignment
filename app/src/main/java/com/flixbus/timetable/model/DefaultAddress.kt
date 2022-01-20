package com.flixbus.timetable.model


import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class DefaultAddress(
    @SerializedName("address")
    val address: String = "",
    @SerializedName("coordinates")
    val coordinates: Coordinates = Coordinates(),
    @SerializedName("full_address")
    val fullAddress: String = ""
) : Parcelable