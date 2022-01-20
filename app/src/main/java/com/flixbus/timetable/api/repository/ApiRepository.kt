package com.flixbus.timetable.api.repository

import com.flixbus.timetable.api.client.ApiService

/**
 * Project           : FlixbusTimetable
 * File Name         : ApiRepository
 * Description       :
 * Revision History  : version 1
 * Date              : 20/01/22
 * Original author   : Kannappan
 * Description       : Initial version
 */
class ApiRepository(private val apiService: ApiService) {
    suspend fun getStationTimeTable() = apiService.getStationTimeTable()
}