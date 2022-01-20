package com.flixbus.timetable.ui.viewmodel

import android.os.Parcelable
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.flixbus.timetable.api.repository.StationTimeTableRepository
import com.flixbus.timetable.api.response.ResponseData
import com.flixbus.timetable.api.response.StationTimeTableResponse
import com.flixbus.timetable.model.Departure

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

    fun getStationDepartureTimeTable(repository: StationTimeTableRepository): LiveData<ResponseData<Parcelable>> {
        return repository.getStationTimeTableData()
    }

    fun getSortedDepartureData(timeTableData: StationTimeTableResponse): List<Departure> {
        val departures = timeTableData.timetable.departures
        return departures.sortedBy {
            it.datetime.timestamp
        }
    }

}