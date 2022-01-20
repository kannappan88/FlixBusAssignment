package com.flixbus.timetable.api.repository

import android.content.Context
import com.flixbus.timetable.R
import com.flixbus.timetable.api.response.ErrorResponse
import com.flixbus.timetable.util.NetworkUtil

/**
 * Project           : FlixbusTimetable
 * File Name         : BaseApiRepository
 * Description       :
 * Revision History  : version 1
 * Date              : 20/01/22
 * Original author   : Kannappan
 * Description       : Initial version
 */
open class BaseApiRepository(val apiRepository: ApiRepository, val context: Context){

    fun hasNetwork() = NetworkUtil.isNetworkOnline(context)

    fun getNetworkErrorResponse(): ErrorResponse {
        return  ErrorResponse(0, context.getString(R.string.error_network_not_available))
    }

}