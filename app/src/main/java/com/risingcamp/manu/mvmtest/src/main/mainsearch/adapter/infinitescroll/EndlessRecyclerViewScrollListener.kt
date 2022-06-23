package com.risingcamp.manu.mvmtest.src.main.mainsearch.adapter.infinitescroll

import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager

abstract class EndlessRecyclerViewScrollListener : RecyclerView.OnScrollListener {

    private var visivbleThresholds = 10

    private var currentCount = 0

    private var previousTotalItemCount = 0

    private var loading = true

    private val perPage = 1

    var mLayoutManager : RecyclerView.LayoutManager
    constructor(layoutManager: LinearLayoutManager) {
        mLayoutManager = layoutManager
    }

    constructor(layoutManager: GridLayoutManager) {
        mLayoutManager = layoutManager
        visivbleThresholds *= layoutManager.spanCount
    }

    constructor(layoutManager: StaggeredGridLayoutManager){
        mLayoutManager = layoutManager
        visivbleThresholds *= layoutManager.spanCount
    }

    private fun getLastVisibleItem(lastVisibleItemPosition : IntArray) : Int{
        var maxSize = 0
        for (i in lastVisibleItemPosition.indices) {
            if (i == 0) {
                maxSize = lastVisibleItemPosition[i]
            } else if (lastVisibleItemPosition[i] > maxSize) {
                maxSize = lastVisibleItemPosition[i]
            }
        }
        return maxSize
    }

    override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
        var lastVisibleItemPosition = 0
        val totalItemCount = mLayoutManager.itemCount
        if (mLayoutManager is StaggeredGridLayoutManager) {
            val lastVisibleItemPositions =
                (mLayoutManager as StaggeredGridLayoutManager).findLastVisibleItemPositions(null)
            // get maximum element within the list
            lastVisibleItemPosition = getLastVisibleItem(lastVisibleItemPositions)
        } else if (mLayoutManager is GridLayoutManager) {
            lastVisibleItemPosition =
                (mLayoutManager as GridLayoutManager).findLastVisibleItemPosition()
        } else if (mLayoutManager is LinearLayoutManager) {
            lastVisibleItemPosition =
                (mLayoutManager as LinearLayoutManager).findLastVisibleItemPosition()
        }

        if (totalItemCount < previousTotalItemCount) {
            currentCount = perPage
            previousTotalItemCount = totalItemCount
            if (totalItemCount == 0) {
                loading = true
            }
        }

        if (loading && totalItemCount > previousTotalItemCount) {
            loading = false
            previousTotalItemCount = totalItemCount
        }

        if (!loading && lastVisibleItemPosition + visivbleThresholds > totalItemCount) {
            currentCount++
            onLoadMore(currentCount, totalItemCount, recyclerView)
            loading = true
        }
    }

    fun resetState() {
        currentCount = perPage
        previousTotalItemCount = 0
        loading = true
    }

    abstract fun onLoadMore(page : Int, totalItemCount : Int, view : RecyclerView)
}