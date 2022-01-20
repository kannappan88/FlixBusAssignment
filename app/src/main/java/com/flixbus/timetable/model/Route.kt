package com.flixbus.timetable.model


import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Route(
    @SerializedName("address")
    val address: String = "",
    @SerializedName("coordinates")
    val coordinates: CoordinatesXX = CoordinatesXX(),
    @SerializedName("default_address")
    val defaultAddress: DefaultAddressX = DefaultAddressX(),
    @SerializedName("full_address")
    val fullAddress: String = "",
    @SerializedName("id")
    val id: Int = 0,
    @SerializedName("name")
    val name: String = "",
    @SerializedName("uuid")
    val uuid: String = ""
) : Parcelable