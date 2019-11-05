package com.uin.millatip.shrimpy.ui.calculation.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.uin.millatip.shrimpy.R
import kotlinx.android.synthetic.main.activity_fcr.*

class FcrActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fcr)
        supportActionBar?.title = "Rasio Konvensi Makanan"
        btn_count_fcr_fcr.setOnClickListener {
            countFcr()
        }
        btn_count_fcr_pakan.setOnClickListener {
            countPakan()
        }
        btn_count_fcr_panen.setOnClickListener {
            countPanen()
        }
    }

    private fun countPanen() {
        if ( first_fcr_panen_input.text.toString() == "" || fcr_panen_second_input.text.toString() == "" ){
            Toast.makeText(this, "Please input a value", Toast.LENGTH_SHORT).show()
        } else {
            val fcr = first_fcr_panen_input.text.toString().toDouble()
            val pakan = fcr_panen_second_input.text.toString().toDouble()
            val panen = pakan / fcr
            tv_result_fcr_panen.text = "$panen gram"
        }
    }

    private fun countPakan() {
        if ( first_fcr_pakan_input.text.toString() == "" || fcr_pakan_second_input.text.toString() == "" ){
            Toast.makeText(this, "Please input a value", Toast.LENGTH_SHORT).show()
        } else {
            val fcr = first_fcr_pakan_input.text.toString().toDouble()
            val panen = fcr_pakan_second_input.text.toString().toDouble()
            val pakan = fcr * panen
            tv_result_fcr_pakan.text = "$pakan gram"
        }
    }

    private fun countFcr() {
        if ( fcr_fcr_first_input.text.toString() == "" || fcr_fcr_second_input.text.toString() == "" ){
            Toast.makeText(this, "Please input a value", Toast.LENGTH_SHORT).show()
        } else {
            val panen = fcr_fcr_first_input.text.toString().toDouble()
            val pakan = fcr_fcr_second_input.text.toString().toDouble()
            val fcr = panen / pakan
            tv_result_fcr_fcr.text = "$fcr %"
        }
    }
}
