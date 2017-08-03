package com.bitspilanidvm.bosm2017

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup

class MainRecyclerViewAdapter(var dataList: List<Pair<String, Int>>) : RecyclerView.Adapter<MainItemViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): MainItemViewHolder {
        val view = LayoutInflater.from(parent?.context).inflate(R.layout.item_main_nav_recycler_view, parent, false)
        return MainItemViewHolder(view)
    }

    override fun onBindViewHolder(holder: MainItemViewHolder?, position: Int) {
        holder?.itemText?.text = dataList[position].first
        holder?.itemImage?.setImageResource(dataList[position].second)

    }

    override fun onViewAttachedToWindow(holder: MainItemViewHolder?) {
        super.onViewAttachedToWindow(holder)

    }

    override fun getItemCount() = dataList.size
}