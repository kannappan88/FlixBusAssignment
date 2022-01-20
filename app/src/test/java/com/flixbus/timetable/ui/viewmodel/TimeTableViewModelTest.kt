package com.flixbus.timetable.ui.viewmodel

import android.os.Parcelable
import androidx.lifecycle.MutableLiveData
import com.flixbus.timetable.BaseTest
import com.flixbus.timetable.FileUtils
import com.flixbus.timetable.api.repository.StationTimeTableRepository
import com.flixbus.timetable.api.response.ErrorResponse
import com.flixbus.timetable.api.response.ResponseData
import com.flixbus.timetable.api.response.ResponseStatus
import com.flixbus.timetable.api.response.StationTimeTableResponse
import com.google.gson.Gson
import io.mockk.MockKAnnotations
import io.mockk.every
import io.mockk.impl.annotations.MockK
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner


/**
 * Project           : FlixbusTimetable
 * File Name         : TimeTableViewModelTest
 * Description       :
 * Revision History  : version 1
 * Date              : 20/01/22
 * Original author   : Kannappan
 * Description       : Initial version
 */
@RunWith(RobolectricTestRunner::class)
class TimeTableViewModelTest : BaseTest() {
    private lateinit var viewModel: TimeTableViewModel

    @MockK()
    private lateinit var stationTimeTableRepository: StationTimeTableRepository

    @Before
    override fun setup() {
        super.setup()
        MockKAnnotations.init(this)
        viewModel = TimeTableViewModel()
    }

    @Test
    fun `verify station time table success api response when requested`() {
        val stationResponse = FileUtils.readDataFromResources(
            "station_timetable_response.json"
        )
        val stationTimeTableResponse =
            Gson().fromJson(stationResponse, StationTimeTableResponse::class.java)
        val teamListLiveData: MutableLiveData<ResponseData<Parcelable>> = MutableLiveData(
            ResponseData(
                stationTimeTableResponse,
                "SUCCESS",
                ResponseStatus.SUCCESS
            )
        )
        every { stationTimeTableRepository.getStationTimeTableData() } returns teamListLiveData
        val responseData = viewModel.getStationDepartureTimeTable(stationTimeTableRepository)
        val stationTimeTableResponseData = responseData.value?.data as StationTimeTableResponse
        val sortedDepartureList = viewModel.getSortedDepartureData(stationTimeTableResponseData)
        Assert.assertEquals(64, sortedDepartureList.size)
        Assert.assertEquals("Hanover", sortedDepartureList[0].direction)
        Assert.assertEquals("IDO TOURS  (K1920)", sortedDepartureList[0].lineCode)
        Assert.assertEquals(1642674600, sortedDepartureList[0].datetime.timestamp)
        Assert.assertEquals("GMT+01:00", sortedDepartureList[0].datetime.tz)
    }

    @Test
    fun `verify station time table failed api response when requested`() {
        val teamListLiveData: MutableLiveData<ResponseData<Parcelable>> = MutableLiveData(
            ResponseData(
                ErrorResponse(0, "Connection Error"),
                "FAILED",
                ResponseStatus.ERROR
            )
        )
        every { stationTimeTableRepository.getStationTimeTableData() } returns teamListLiveData
        val responseData = viewModel.getStationDepartureTimeTable(stationTimeTableRepository)

        val errorResponse = responseData.value?.data as ErrorResponse
        Assert.assertEquals(0, errorResponse.errorCode)
        Assert.assertEquals("Connection Error", errorResponse.errorMessage)
    }

}