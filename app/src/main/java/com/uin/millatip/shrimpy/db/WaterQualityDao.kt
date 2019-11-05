package com.uin.millatip.shrimpy.db

import androidx.room.Dao
import androidx.room.Query
import com.uin.millatip.shrimpy.db.model.BaseDao
import com.uin.millatip.shrimpy.db.model.WaterQuality
import io.reactivex.Flowable

@Dao
abstract class WaterQualityDao : BaseDao<WaterQuality> {

    @Query("SELECT * FROM water_quality")
    abstract fun allWaterQualityData(): androidx.paging.DataSource.Factory<Int, WaterQuality>

    @Query("SELECT * from water_quality WHERE id = :id")
    abstract fun getWaterQualityById(id: String): Flowable<List<WaterQuality>>

}
