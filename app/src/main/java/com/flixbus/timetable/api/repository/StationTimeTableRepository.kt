package com.flixbus.timetable.api.repository

import android.content.Context
import androidx.lifecycle.liveData
import com.flixbus.timetable.api.response.ResponseData
import com.flixbus.timetable.api.response.ResponseStatus
import retrofit2.awaitResponse

/**
 * Project           : FlixbusTimetable
 * File Name         : StationTimeTableRepository
 * Description       :
 * Revision History  : version 1
 * Date              : 20/01/22
 * Original author   : Kannappan
 * Description       : Initial version
 */
class StationTimeTableRepository(apiRepository: ApiRepository, context: Context): BaseApiRepository(apiRepository, context) {

    fun getStationTimeTableData() = liveData{
        try {
            val data = apiRepository.getStationTimeTable()?.awaitResponse()
            if (data?.isSuccessful == true) {
                emit(ResponseData(data = data.body(), message = "SUCCESS", ResponseStatus.SUCCESS))
            } else {
                emit(ResponseData(data = getNetworkErrorResponse(), message = "Error", ResponseStatus.ERROR))
            }
        } catch (exception: Exception) {
            emit(ResponseData(data = getNetworkErrorResponse(), message = exception.message ?: "Error", ResponseStatus.ERROR))
        }
    }

}