package com.flixbus.timetable.api.client

import com.flixbus.timetable.api.response.StationTimeTableResponse
import retrofit2.Call
import retrofit2.http.GET

/**
 * Project           : FlixbusTimetable
 * File Name         : ApiService
 * Description       :
 * Revision History  : version 1
 * Date              : 20/01/22
 * Original author   : Kannappan
 * Description       : Initial version
 */
interface ApiService {

    @GET("mobile/v1/network/station/1/timetable.json")
    fun getStationTimeTable(): Call<StationTimeTableResponse?>?
}