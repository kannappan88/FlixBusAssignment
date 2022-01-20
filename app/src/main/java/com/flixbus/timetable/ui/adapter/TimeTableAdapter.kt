package com.flixbus.timetable.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.flixbus.timetable.databinding.RowTimetableBinding
import com.flixbus.timetable.model.Departure
import com.flixbus.timetable.ui.OnTimeTableItemClickListener
import com.flixbus.timetable.util.DateTimeUtils
import com.flixbus.timetable.util.FlixBusConstant

/**
 * Project           : FlixbusTimetable
 * File Name         : TimeTableAdapter
 * Description       :
 * Revision History  : version 1
 * Date              : 20/01/22
 * Original author   : Kannappan
 * Description       : Initial version
 */
class TimeTableAdapter(
    private val context: Context,
    private var departureList: ArrayList<Departure>,
    private val onItemClickListener: OnTimeTableItemClickListener
) : RecyclerView.Adapter<TimeTableAdapter.RecyclerItemViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerItemViewHolder {
        val binding: RowTimetableBinding = RowTimetableBinding.inflate(LayoutInflater.from(context), parent, false)
        return RecyclerItemViewHolder(binding)
    }

    override fun getItemCount() = departureList.size

    override fun onBindViewHolder(
        holder: RecyclerItemViewHolder,
        position: Int
    ) {
        holder.bind(departureList[position])
        holder.itemView.setOnClickListener {
            onItemClickListener.onDepatureItemClick(departureList[position], position)
        }
    }

    fun updateData(departures: List<Departure>) {
        departureList.clear()
        departureList.addAll(departures)
        notifyItemRangeInserted(0, departureList.size)
    }

    inner class RecyclerItemViewHolder(private val timetableBinding: RowTimetableBinding) :
        RecyclerView.ViewHolder(timetableBinding.root) {
        fun bind(departure: Departure) {
            val datetimeX = departure.datetime
            val departureTime =
                DateTimeUtils.getTimeBasedOnTimezone(FlixBusConstant.DEPARTUE_TIME_PATTERN, datetimeX.tz, datetimeX.timestamp)
            timetableBinding.timetableTvTime.text = departureTime
            timetableBinding.model = departure
            timetableBinding.executePendingBindings()
        }
    }
}