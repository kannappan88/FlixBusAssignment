package com.flixbus.timetable.ui.viewmodel

import android.content.Context
import android.os.Parcelable
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.flixbus.timetable.api.ApiManager
import com.flixbus.timetable.api.repository.StationTimeTableRepository
import com.flixbus.timetable.api.response.ResponseData

/**
 * Project           : FlixbusTimetable
 * File Name         : TimeTableViewModel
 * Description       :
 * Revision History  : version 1
 * Date              : 20/01/22
 * Original author   : Kannappan
 * Description       : Initial version
 */
class TimeTableViewModel : ViewModel() {

    fun getStationDepartureTimeTable(context: Context): LiveData<ResponseData<Parcelable>> {
        val stationTimeTableRepository =
            StationTimeTableRepository(ApiManager.instance.getApiRepository(), context)
        return stationTimeTableRepository.getStationTimeTableData()
    }

}