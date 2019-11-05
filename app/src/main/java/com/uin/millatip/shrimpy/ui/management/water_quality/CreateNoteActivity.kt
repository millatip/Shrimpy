package com.uin.millatip.shrimpy.ui.management.water_quality

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.os.Bundle
import android.text.InputType
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProviders
import com.google.android.material.snackbar.Snackbar
import com.uin.millatip.shrimpy.R
import com.uin.millatip.shrimpy.db.Injection
import com.uin.millatip.shrimpy.db.ViewModelFactory
import com.uin.millatip.shrimpy.models.Water
import kotlinx.android.synthetic.main.activity_create_note.*
import java.util.*

class CreateNoteActivity : AppCompatActivity() {

    private lateinit var viewModelFactory: ViewModelFactory

    lateinit var viewModel: CreateNoteActivityViewModel
    private var waterColor: String = ""


    private var errorSnackbar: Snackbar? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_note)
        viewModelFactory = Injection.provideViewModelFactory(this)
        viewModel = ViewModelProviders.of(this, viewModelFactory)
            .get(CreateNoteActivityViewModel::class.java)
        initSpinner()
        ed_date_picker.inputType = InputType.TYPE_NULL
        ed_time_picker.inputType = InputType.TYPE_NULL
        ed_date_picker.setOnClickListener {
            val c = Calendar.getInstance()
            val year = c.get(Calendar.YEAR)
            val month = c.get(Calendar.MONTH)
            val day = c.get(Calendar.DAY_OF_MONTH)

            val dpd = DatePickerDialog(
                this,
                DatePickerDialog.OnDateSetListener { view, year, monthOfYear, dayOfMonth ->
                    // Display Selected date in Toast
                    ed_date_picker.setText("""$dayOfMonth/${monthOfYear + 1}/$year""")
                },
                year,
                month,
                day
            )
            dpd.show()
        }
        ed_time_picker.setOnClickListener {
            val c = Calendar.getInstance()
            val hour = c.get(Calendar.HOUR)
            val minute = c.get(Calendar.MINUTE)

            val tpd =
                TimePickerDialog(this, TimePickerDialog.OnTimeSetListener(function = { view, h, m ->

                    ed_time_picker.setText(h.toString() + " : " + m)

                }), hour, minute, true)

            tpd.show()
        }
        btn_submit.setOnClickListener {
            if (fourth_value.text != null && fifth_value.text != null && sixth_value.text != null && seventh_value.text != null && eight_value.text != null && ed_date_picker.text != null && ed_time_picker.text != null) {
                getValues()
            } else {
                Toast.makeText(this, "Tolong lengkapi data", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun getValues() {
        val water = Water(
            brightness = fourth_value.text.toString(),
            ph = fifth_value.text.toString(),
            waterDo = sixth_value.text.toString(),
            salinity = seventh_value.text.toString(),
            temp = eight_value.text.toString(),
            date = ed_date_picker.text.toString(),
            time = ed_time_picker.text.toString(),
            waterColor = waterColor
        )
        viewModel.setData(water)
        viewModel.message.observe(this, androidx.lifecycle.Observer {
            if (it != null) showMessage(it)
        })
        onBackPressed()
    }

    private fun initSpinner() {
        val waterColors = arrayOf(
            "Kuning",
            "Hijau Muda",
            "Hijau Pekat",
            "Hijau Kecoklatan",
            "Hijau Biru",
            "Coklat",
            "Coklat Kemerahan",
            "Hitam"
        )
        val adapter = ArrayAdapter(
            this, // Context
            android.R.layout.simple_spinner_item, // Layout
            waterColors// Array
        )
        adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line)
        spinner.adapter = adapter
        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(p0: AdapterView<*>?) {

            }

            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                waterColor = p0?.getItemAtPosition(p2).toString()
            }

        }
    }

    private fun showMessage(message: String) {
        errorSnackbar = Snackbar.make(create_note, message, Snackbar.LENGTH_INDEFINITE)
        errorSnackbar?.show()
    }
}
