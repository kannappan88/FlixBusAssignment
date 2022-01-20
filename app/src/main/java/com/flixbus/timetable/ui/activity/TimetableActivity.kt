package com.flixbus.timetable.ui.activity

import android.os.Bundle
import android.os.Parcelable
import androidx.activity.viewModels
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import com.flixbus.timetable.api.response.ErrorResponse
import com.flixbus.timetable.api.response.ResponseData
import com.flixbus.timetable.api.response.ResponseStatus
import com.flixbus.timetable.api.response.StationTimeTableResponse
import com.flixbus.timetable.databinding.ActivityTimetableBinding
import com.flixbus.timetable.ui.OnTimeTableItemClickListener
import com.flixbus.timetable.ui.adapter.TimeTableAdapter
import com.flixbus.timetable.ui.common.BaseActivity
import com.flixbus.timetable.ui.viewmodel.TimeTableViewModel
import com.flixbus.timetable.util.hide
import com.flixbus.timetable.util.show


/**
 * Project           : FlixbusTimetable
 * File Name         : HomeActivity
 * Description       :
 * Revision History  : version 1
 * Date              : 20/01/22
 * Original author   : Kannappan
 * Description       : Initial version
 */
class TimetableActivity : BaseActivity(), OnTimeTableItemClickListener {

    private lateinit var mAdapter: TimeTableAdapter
    private lateinit var mBinding: ActivityTimetableBinding
    private val mViewModel : TimeTableViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityTimetableBinding.inflate(layoutInflater, null, false)
        setContentView(mBinding.root)

        initView()

        //read data from API
        mViewModel.getStationDepartureTimeTable(this).observe(this, {
            responseData -> handleStationResponseData(responseData)
        })
    }

    private fun initView() {
        val recyclerView = mBinding.timetableRecyclerView
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.itemAnimator = DefaultItemAnimator()
        recyclerView.setHasFixedSize(true)

        mAdapter = TimeTableAdapter(this, arrayListOf(), this)
        recyclerView.adapter = mAdapter
    }

    private fun handleStationResponseData(responseData: ResponseData<Parcelable>) {
        if (responseData.status == ResponseStatus.SUCCESS) {
            val timeTableData = responseData.data as StationTimeTableResponse
            mBinding.timetableRecyclerView.show()
            mBinding.timetableTvInfo.hide()
            val departureList = timeTableData.timetable.departures.sortedBy {
                it.datetime.timestamp
            }
            mAdapter.updateData(departureList)
        } else {
            val errorResponse = responseData.data as ErrorResponse
            mBinding.timetableRecyclerView.hide()
            mBinding.timetableTvInfo.show()
            mBinding.timetableTvInfo.text = errorResponse.errorMessage
            showToast(responseData.message)
        }
    }
}