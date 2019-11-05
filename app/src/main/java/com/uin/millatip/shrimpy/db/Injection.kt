

package com.uin.millatip.shrimpy.db

import android.content.Context

/**
 * Enables injection of data sources.
 */
object Injection {

    fun provideWaterQualityDataSource(context: Context): WaterQualityDao {
        val database = ShrimpDatabase.getInstance(context)
        return database.waterQualityDao()
    }

    fun provideViewModelFactory(context: Context): ViewModelFactory {
        val waterQualityDao = provideWaterQualityDataSource(context)
        return ViewModelFactory(waterQualityDao)
    }
}
