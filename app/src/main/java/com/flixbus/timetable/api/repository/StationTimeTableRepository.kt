package com.flixbus.timetable.api.repository

import androidx.lifecycle.liveData
import com.flixbus.timetable.api.response.ResponseData
import com.flixbus.timetable.api.response.ResponseStatus
import retrofit2.await

/**
 * Project           : FlixbusTimetable
 * File Name         : StationTimeTableRepository
 * Description       :
 * Revision History  : version 1
 * Date              : 20/01/22
 * Original author   : Kannappan
 * Description       : Initial version
 */
class StationTimeTableRepository(apiRepository: ApiRepository): BaseApiRepository(apiRepository) {

    fun getStationTimeTableData() = liveData{
        try {
            val data = apiRepository.getStationTimeTable()?.await()
            emit(ResponseData(data = data, message = "SUCCESS", ResponseStatus.SUCCESS))
        } catch (exception: Exception) {
            emit(ResponseData(data = null, message = exception.message ?: "Error", ResponseStatus.ERROR))
        }
    }
}