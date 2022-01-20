package com.flixbus.timetable.ui.common

import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

/**
 * Project           : FlixbusTimetable
 * File Name         : BaseActivity
 * Description       :
 * Revision History  : version 1
 * Date              : 20/01/22
 * Original author   : Kannappan
 * Description       : Initial version
 */
open class BaseActivity : AppCompatActivity() {

    fun showToast(message: String?) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }

}