package com.flixbus.timetable

import java.io.BufferedReader
import java.io.IOException
import java.io.InputStream
import java.io.InputStreamReader

/**
 * Project           : FlixbusTimetable
 * File Name         : FileUtils
 * Description       :
 * Revision History  : version 1
 * Date              : 20/01/22
 * Original author   : Kannappan
 * Description       : Initial version
 */
object FileUtils {

    fun readDataFromResources(fileName: String?): String {
        val responseString = StringBuilder()
        var fIn: InputStream? = null
        var isr: InputStreamReader? = null
        var input: BufferedReader? = null
        try {
            fIn = javaClass.classLoader?.getResourceAsStream(fileName!!)
            isr = InputStreamReader(fIn)
            input = BufferedReader(isr)
            var line: String? = ""
            while (input.readLine().also { line = it } != null) {
                responseString.append(line)
            }
        } catch (e: Exception) {
            e.message
        } finally {
            if (isr != null) {
                try {
                    isr.close()
                } catch (e: IOException) {
                    e.printStackTrace()
                }
            }
            if (fIn != null) {
                try {
                    fIn.close()
                } catch (e: IOException) {
                    e.printStackTrace()
                }
            }
            if (input != null) {
                try {
                    input.close()
                } catch (e: IOException) {
                    e.printStackTrace()
                }
            }
        }
        return responseString.toString()
    }
}