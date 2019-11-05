package com.uin.millatip.shrimpy.ui.management.water_quality

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.uin.millatip.shrimpy.utils.androidThread
import com.uin.millatip.shrimpy.utils.ioThread
import com.uin.millatip.shrimpy.db.WaterQualityDao
import com.uin.millatip.shrimpy.db.model.WaterQuality
import com.uin.millatip.shrimpy.models.Water
import io.reactivex.disposables.CompositeDisposable

class CreateNoteActivityViewModel(private val waterQualityDao: WaterQualityDao) : ViewModel() {
    lateinit var water: Water

    var disposable: CompositeDisposable = CompositeDisposable()

    val message: MutableLiveData<String> = MutableLiveData()

    override fun onCleared() {
        this.disposable.dispose()
        super.onCleared()
    }
    fun setData (water:Water){
        this.water = water
        updateMovieFavorite()
    }
    fun updateMovieFavorite() {
        val waterQuality = WaterQuality(
            date = water.date,
            time = water.time,
            waterColor = water.waterColor,
            waterDo = water.waterDo,
            ph = water.ph,
            salinity = water.salinity,
            brightness = water.brightness,
            temperature = water.temp
        )
        this.disposable.addAll(waterQualityDao.insert(waterQuality)
            .subscribeOn(ioThread())
            .observeOn(androidThread())
            .subscribe(
                { message.value = "Data has been saved" },
                { message.value = null }
            ))
    }
}
