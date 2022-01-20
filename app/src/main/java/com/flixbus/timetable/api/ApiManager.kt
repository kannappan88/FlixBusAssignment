package com.flixbus.timetable.api

import com.flixbus.timetable.api.client.ApiClient
import com.flixbus.timetable.api.client.ApiService
import com.flixbus.timetable.api.repository.ApiRepository

/**
 * Project           : FlixbusTimetable
 * File Name         : ApiManager
 * Description       :
 * Revision History  : version 1
 * Date              : 20/01/22
 * Original author   : Kannappan
 * Description       : Initial version
 */
class ApiManager private constructor() {

    fun getApiRepository(): ApiRepository {
        return ApiRepository(getAPIService())
    }

    private fun getAPIService(): ApiService {
        return ApiClient.apiService
    }

    companion object {
        val instance = ApiManager()
    }
}