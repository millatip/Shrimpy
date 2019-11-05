package com.uin.millatip.shrimpy.ui.management.detail_water

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.uin.millatip.shrimpy.db.WaterQualityDao
import com.uin.millatip.shrimpy.db.model.WaterQuality
import com.uin.millatip.shrimpy.utils.androidThread
import com.uin.millatip.shrimpy.utils.ioThread
import io.reactivex.disposables.CompositeDisposable

class DetailWaterActivityViewModel(private val waterQualityDao: WaterQualityDao) : ViewModel() {

    lateinit var water: WaterQuality

    var disposable: CompositeDisposable = CompositeDisposable()

    val message: MutableLiveData<String> = MutableLiveData()

    override fun onCleared() {
        this.disposable.dispose()
        super.onCleared()
    }

    fun setData(water: WaterQuality) {
        this.water = water
    }

    fun deleteMovieFavorite() {
        this.disposable.addAll(waterQualityDao.delete(water)
            .subscribeOn(ioThread())
            .observeOn(androidThread())
            .subscribe(
                { message.value = "Data has been deleted" },
                { message.value = null }
            ))
    }
}
