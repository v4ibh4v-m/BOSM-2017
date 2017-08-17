package com.bitspilanidvm.bosm2017

import android.content.Context
import android.support.v4.view.PagerAdapter
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout

class Adapter_DetailsViewPager(val context: Context, val adapters: Array<Adapter_DetailsRecyclerView>) : PagerAdapter(){

    override fun instantiateItem(container: ViewGroup?, position: Int): Any {
        val itemView = LayoutInflater.from(context).inflate(R.layout.recycler_view_view_pager_page, container, false)
        val recyclerView = itemView.findViewById<RecyclerView>(R.id.recylerViewInViewPager)

        //setting recycler view properties
        with(recyclerView){
            adapter = adapters[position]
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
            setHasFixedSize(true)
            setItemViewCacheSize(20)
            isDrawingCacheEnabled = true
            drawingCacheQuality = View.DRAWING_CACHE_QUALITY_HIGH
        }

        container?.addView(itemView)
        return itemView
    }

    override fun destroyItem(container: ViewGroup?, position: Int, `object`: Any?) {
        container?.removeView(`object` as FrameLayout)
    }

    override fun isViewFromObject(view: View?, `object`: Any?) = view == `object` as FrameLayout

    override fun getCount() = adapters.size
}