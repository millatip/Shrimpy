

package com.uin.millatip.shrimpy.db

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.uin.millatip.shrimpy.ui.management.ManagementViewModel
import com.uin.millatip.shrimpy.ui.management.detail_water.DetailWaterActivityViewModel
import com.uin.millatip.shrimpy.ui.management.water_quality.CreateNoteActivityViewModel

/**
 * Factory for ViewModels
 */
class ViewModelFactory(private val waterQualityDao: WaterQualityDao) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(CreateNoteActivityViewModel::class.java)) {
            return CreateNoteActivityViewModel(waterQualityDao) as T
        }
        if (modelClass.isAssignableFrom(ManagementViewModel::class.java)){
            return ManagementViewModel(waterQualityDao) as T
        }
        if (modelClass.isAssignableFrom(DetailWaterActivityViewModel::class.java)){
            return DetailWaterActivityViewModel(waterQualityDao) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
