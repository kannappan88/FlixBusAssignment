package com.flixbus.timetable.model


import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class RouteX(
    @SerializedName("address")
    val address: String = "",
    @SerializedName("coordinates")
    val coordinates: CoordinatesXXXX = CoordinatesXXXX(),
    @SerializedName("default_address")
    val defaultAddress: DefaultAddressXX = DefaultAddressXX(),
    @SerializedName("full_address")
    val fullAddress: String = "",
    @SerializedName("id")
    val id: Int = 0,
    @SerializedName("name")
    val name: String = "",
    @SerializedName("uuid")
    val uuid: String = ""
) : Parcelable