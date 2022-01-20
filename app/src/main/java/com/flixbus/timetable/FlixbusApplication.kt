package com.flixbus.timetable

import android.app.Application

/**
 * Project           : FlixbusTimetable
 * File Name         : FlixbusApplication
 * Description       :
 * Revision History  : version 1
 * Date              : 20/01/22
 * Original author   : Kannappan
 * Description       : Initial version
 */
class FlixbusApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        application = this
    }

    companion object {
        var application: FlixbusApplication? = null
            private set
    }
}