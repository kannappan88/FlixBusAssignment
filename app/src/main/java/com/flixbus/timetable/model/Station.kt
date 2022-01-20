package com.flixbus.timetable.model


import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Station(
    @SerializedName("address")
    val address: String = "",
    @SerializedName("coordinates")
    val coordinates: Coordinates = Coordinates(),
    @SerializedName("default_address")
    val defaultAddress: DefaultAddress = DefaultAddress(),
    @SerializedName("full_address")
    val fullAddress: String = "",
    @SerializedName("id")
    val id: Int = 0,
    @SerializedName("name")
    val name: String = "",
    @SerializedName("uuid")
    val uuid: String = ""
) : Parcelable