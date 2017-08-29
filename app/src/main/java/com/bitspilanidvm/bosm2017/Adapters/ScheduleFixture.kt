package com.bitspilanidvm.bosm2017.Adapters

import android.graphics.Typeface
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.bitspilanidvm.bosm2017.Modals.FixtureSportsData
import com.bitspilanidvm.bosm2017.R
import com.bitspilanidvm.bosm2017.ViewHolder.ScheduleFixture
import java.text.SimpleDateFormat

class ScheduleFixture(val data: List<FixtureSportsData>, val typeface: Typeface) : RecyclerView.Adapter<ScheduleFixture>(){

    val dateFormat = SimpleDateFormat("MMM dd yyyy HH:mm:ss")
    val formattedDate = SimpleDateFormat("MMMM dd")
    val formattedTime = SimpleDateFormat("HH:mm")

    override fun onBindViewHolder(holder: ScheduleFixture, position: Int) {
        val date = dateFormat.parse("${data[position].date} ${data[position].time}")
        holder.tdv.text = "${formattedDate.format(date)} | ${formattedTime.format(date)} | ${data[position].venue}"
        holder.round.text = data[position].round
        holder.teamA.text = data[position].teamA
        holder.teamB.text = data[position].teamB

        holder.round.typeface = typeface
        holder.tdv.typeface = typeface
        holder.teamA.typeface = typeface
        holder.teamB.typeface = typeface
        holder.vs.typeface = typeface

    }

    override fun getItemCount() = data.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ScheduleFixture {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.schedule_fixture_item_layout_new, parent, false)
        return com.bitspilanidvm.bosm2017.ViewHolder.ScheduleFixture(view)
    }
}