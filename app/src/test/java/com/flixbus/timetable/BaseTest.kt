package com.flixbus.timetable

import android.content.Context
import androidx.test.core.app.ApplicationProvider

/**
 * Project           : FlixbusTimetable
 * File Name         : BaseTest
 * Description       :
 * Revision History  : version 1
 * Date              : 20/01/22
 * Original author   : Kannappan
 * Description       : Initial version
 */
open class BaseTest {
    lateinit var context: Context


    open fun setup() {
        context = ApplicationProvider.getApplicationContext()
    }
}