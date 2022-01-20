package com.flixbus.timetable.model


import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class DefaultAddressX(
    @SerializedName("address")
    val address: String = "",
    @SerializedName("coordinates")
    val coordinates: CoordinatesXXX = CoordinatesXXX(),
    @SerializedName("full_address")
    val fullAddress: String = ""
) : Parcelable