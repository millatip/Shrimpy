package com.uin.millatip.shrimpy.db.model

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize
import java.time.OffsetDateTime

@Parcelize
@Entity(tableName = "water_quality")
data class WaterQuality  (
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    val id: Int = 0,
    @ColumnInfo(name = "date")
    val date: String,
    @ColumnInfo(name = "time")
    val time: String,
    @ColumnInfo(name = "waterColor")
    val waterColor: String,
    @ColumnInfo(name = "brightness")
    val brightness: String,
    @ColumnInfo(name = "ph")
    val ph: String?,
    @ColumnInfo(name = "waterDo")
    val waterDo: String?,
    @ColumnInfo(name = "salinity")
    var salinity: String?,
    @ColumnInfo(name = "temperature")
    var temperature: String?
    ) : Parcelable
