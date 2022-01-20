package com.flixbus.timetable.ui

import com.flixbus.timetable.model.Departure

/**
 * Project           : FlixbusTimetable
 * File Name         : OnTimeTableItemClickListener
 * Description       :
 * Revision History  : version 1
 * Date              : 20/01/22
 * Original author   : Kannappan
 * Description       : Initial version
 */
interface OnTimeTableItemClickListener {
    fun onDepatureItemClick(departure: Departure, position: Int) {}
}