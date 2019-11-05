package com.uin.millatip.shrimpy.ui.management

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.DataSource
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.uin.millatip.shrimpy.db.WaterQualityDao
import com.uin.millatip.shrimpy.db.model.WaterQuality

class ManagementViewModel(waterSource: WaterQualityDao) : ViewModel() {
    private var water: LiveData<PagedList<WaterQuality>>

    init {
        val factory: DataSource.Factory<Int, WaterQuality> = waterSource.allWaterQualityData()
        val pagedListBuilder: LivePagedListBuilder<Int, WaterQuality> = LivePagedListBuilder(factory, 30)
        water = pagedListBuilder.build()
    }

    fun getWaterLiveData() = water
}
