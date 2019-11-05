package com.uin.millatip.shrimpy.ui.management.detail_water

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.lifecycle.ViewModelProviders
import com.google.android.material.snackbar.Snackbar
import com.uin.millatip.shrimpy.R
import com.uin.millatip.shrimpy.db.Injection
import com.uin.millatip.shrimpy.db.ViewModelFactory
import com.uin.millatip.shrimpy.db.model.WaterQuality
import com.uin.millatip.shrimpy.ui.management.water_quality.CreateNoteActivityViewModel
import kotlinx.android.synthetic.main.activity_create_note.*
import kotlinx.android.synthetic.main.activity_detail_water.*

class DetailWaterActivity : AppCompatActivity() {

    private var menuItem: Menu? = null
    private var errorSnackbar: Snackbar? = null


    private lateinit var viewModelFactory: ViewModelFactory

    lateinit var viewModel: DetailWaterActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_water)

        viewModelFactory = Injection.provideViewModelFactory(this)
        viewModel = ViewModelProviders.of(this, viewModelFactory).get(DetailWaterActivityViewModel::class.java)

        val item = intent.getParcelableExtra<WaterQuality>("extra_water")
        initItem(item)
        viewModel.setData(item)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_delete, menu)
        menuItem = menu
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            android.R.id.home -> {
                onBackPressed()
                true
            }
            R.id.action_delete -> {
                viewModel.deleteMovieFavorite()
                viewModel.message.observe(this, androidx.lifecycle.Observer {
                    if (it != null) showMessage(it)
                })
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun initItem(item: WaterQuality) {
        tv_detail_date.text = item.date
        tv_detail_time.text = item.time
//        DO

        when (item.waterDo?.toInt()){
            in 0 .. 3 -> {
                do_detail_title.text = "DO : ${item.waterDo}"
                do_detail_title.setTextColor(resources.getColor(R.color.design_default_color_error))
                do_detail_note.text = getString(R.string.less_do_solution)
                do_detail_note.visibility = View.VISIBLE
            }
            in 3 .. 10 -> {
                do_detail_title.text = "DO : ${item.waterDo}"
                do_detail_note.text = getString(R.string.optimal)
                do_detail_note.visibility = View.VISIBLE
            }
            else -> {
                do_detail_title.text = "DO : ${item.waterDo}"
            }
        }

//        pH
            when (item.ph?.toDouble()!!){
            in 0.0..6.9 -> {
                ph_detail_title.text = "pH : ${item.ph}"
                ph_detail_title.setTextColor(resources.getColor(R.color.design_default_color_error))
                ph_detail_note.text = getString(R.string.less_ph_sol)
                ph_detail_note.visibility = View.VISIBLE
            }
            in 7.0 .. 7.4 -> {
                ph_detail_title.text = "pH : ${item.ph}"
                ph_detail_note.text = getString(R.string.toleransi)
                ph_detail_note.visibility = View.VISIBLE
            }
            in 7.5 .. 8.0 -> {
                ph_detail_title.text = "pH : ${item.ph}"
                ph_detail_note.text = getString(R.string.optimal)
                ph_detail_note.visibility = View.VISIBLE
            }
            in 8.0 .. 8.5 -> {
                ph_detail_title.text = "pH : ${item.ph}"
                ph_detail_note.text = getString(R.string.toleransi)
                ph_detail_note.visibility = View.VISIBLE
            }
            else -> {
                ph_detail_title.text = "pH : ${item.ph}"
                ph_detail_title.setTextColor(resources.getColor(R.color.design_default_color_error))
                ph_detail_note.text = getString(R.string.more_ph_sol)
                ph_detail_note.visibility = View.VISIBLE
            }
        }

//        Kecerahan
        when (item.brightness.toInt()){
            in 0 .. 20 -> {
                brightness_detail_title.text = "Kecerahan : ${item.brightness} cm"
                brightness_detail_title.setTextColor(resources.getColor(R.color.design_default_color_error))
                brightness_detail_note.text = getString(R.string.brightness_low_sol)
                brightness_detail_note.visibility = View.VISIBLE
            }
            in 20 .. 40 -> {
                brightness_detail_title.text = "Kecerahan : ${item.brightness} cm"
                brightness_detail_note.text = getString(R.string.optimal)
                brightness_detail_note.visibility = View.VISIBLE
            }
            else -> {
                brightness_detail_title.text = "Kecerahan : ${item.brightness} cm"
                brightness_detail_title.setTextColor(resources.getColor(R.color.design_default_color_error))
                brightness_detail_note.text = getString(R.string.brightness_more_sol)
                brightness_detail_note.visibility = View.VISIBLE
            }
        }

//        Salinitas
        when (item.salinity?.toInt()){
            in 0 .. 15 -> {
                salinity_detail_title.text = "Salinitas : ${item.salinity} ppt"
                salinity_detail_title.setTextColor(resources.getColor(R.color.design_default_color_error))
                salinity_detail_note.text = getString(R.string.low_salinity_sol)
                salinity_detail_note.visibility = View.VISIBLE
            }
            in 15 .. 35 -> {
                salinity_detail_title.text = "Salinitas : ${item.salinity} ppt"
                salinity_detail_note.text = getString(R.string.optimal)
                salinity_detail_note.visibility = View.VISIBLE
            }
            else -> {
                salinity_detail_title.text = "Salinitas : ${item.salinity} ppt"
                salinity_detail_note.text = getString(R.string.high_salinity)
                salinity_detail_note.visibility = View.VISIBLE

            }
        }

        when (item.temperature?.toInt()){
            in 0 .. 25 -> {
                temperature_detail_title.text = "Suhu : ${item.temperature} C"
                temp_detail_note.text = getString(R.string.low_temp)
                temp_detail_note.visibility = View.VISIBLE
            }
            in 26 .. 27 -> {
                temperature_detail_title.text = "Suhu : ${item.temperature} C"
                temp_detail_note.text = getString(R.string.toleransi)
                temp_detail_note.visibility = View.VISIBLE
            }
            in 28 .. 32 -> {
                temperature_detail_title.text = "Suhu : ${item.temperature} C"
                temp_detail_note.text = getString(R.string.optimal)
                temp_detail_note.visibility = View.VISIBLE
            }
            in 33 .. 35 -> {
                temperature_detail_title.text = "Suhu : ${item.temperature} C"
                temp_detail_note.text = getString(R.string.toleransi)
                temp_detail_note.visibility = View.VISIBLE
            }
            else -> {
                temperature_detail_title.text = "Suhu : ${item.temperature} C"
                temp_detail_note.text = getString(R.string.high_temp)
                temp_detail_note.visibility = View.VISIBLE
            }
        }

//        Warna Air
        val waterColor = item.waterColor
        if (waterColor == "Hijau Kecoklatan"){
            water_color_detail_title.text = "Warna air : $waterColor"
            water_color_detail_note.text = getString(R.string.optimal)
            water_color_detail_note.visibility = View.VISIBLE
        } else {
            water_color_detail_title.text = "Warna air : $waterColor"
            water_color_detail_note.text = getString(R.string.water_sol)
            water_color_detail_note.visibility = View.VISIBLE
        }
    }

    private fun showMessage(message: String) {
        errorSnackbar = Snackbar.make(detail_layout, message, Snackbar.LENGTH_INDEFINITE)
        errorSnackbar?.show()
    }
}
