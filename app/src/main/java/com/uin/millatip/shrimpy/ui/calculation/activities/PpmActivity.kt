package com.uin.millatip.shrimpy.ui.calculation.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.uin.millatip.shrimpy.R
import kotlinx.android.synthetic.main.activity_ppm.*

class PpmActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ppm)
        ed_ppm_first.hint = "m² luas tambak"
        supportActionBar?.title = "Part per Million"
        btn_count_ppm.setOnClickListener {
            count()
        }
    }

    private fun count() {
        if ( ppm_first_input.text.toString() == "" || ppm_second_input.text.toString() == "" || ppm_third_input.text.toString() == "" ){
            Toast.makeText(this, "Please input a value", Toast.LENGTH_SHORT).show()
        } else {
            val area = ppm_first_input.text.toString().toInt()
            val depth = ppm_second_input.text.toString().toInt()
            val ppm = ppm_third_input.text.toString().toInt()
            val kg = area * depth  * ppm / 1000
            tv_result_ppm.text = "$kg kilogram"
        }
    }
}
