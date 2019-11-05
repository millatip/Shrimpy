package com.uin.millatip.shrimpy.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.uin.millatip.shrimpy.db.model.WaterQuality

@Database(entities = [WaterQuality::class], version = 1, exportSchema = false)
abstract class ShrimpDatabase : RoomDatabase(){

    abstract fun waterQualityDao(): WaterQualityDao

    companion object{
        private const val DATABASE_NAME = "shrimpy.db"
        @Volatile private var INSTANCE: ShrimpDatabase? = null

        fun getInstance(context: Context): ShrimpDatabase =
            INSTANCE ?: synchronized(this) {
                INSTANCE ?: buildDatabase(context).also { INSTANCE = it }
            }

        private fun buildDatabase(context: Context) =
            Room.databaseBuilder(context.applicationContext,
                ShrimpDatabase::class.java, DATABASE_NAME)
                .build()
    }
}
