package com.flixbus.timetable.util

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities

/**
 * Project           : FlixbusTimetable
 * File Name         : NetworkUtil
 * Description       :
 * Revision History  : version 1
 * Date              : 20/01/22
 * Original author   : Kannappan
 * Description       : Initial version
 */
object NetworkUtil {

    fun isNetworkOnline(context: Context): Boolean {
        var isOnline = false
        try {
            val manager =
                (context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager)
            val capabilities =
                manager.getNetworkCapabilities(manager.activeNetwork)
            isOnline =
                capabilities != null && capabilities.hasCapability(NetworkCapabilities.NET_CAPABILITY_VALIDATED)
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return isOnline
    }
}