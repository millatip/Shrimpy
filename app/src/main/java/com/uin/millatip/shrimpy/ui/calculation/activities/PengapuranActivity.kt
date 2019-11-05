package com.uin.millatip.shrimpy.ui.calculation.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Html
import android.widget.Toast
import com.uin.millatip.shrimpy.R
import kotlinx.android.synthetic.main.activity_pengapuran.*

class PengapuranActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pengapuran)
        supportActionBar?.title = "Pengapuran"
        btn_count.setOnClickListener {
            count()
        }
        tv_note.text = Html.fromHtml(getString(R.string.manfaat_pengapuran))
        second_ed.hint = "m\u00B2"
    }

    private fun count() {
        if (first_input.text.toString() == "" || second_input.text.toString() == "" ){
            Toast.makeText(this, "Please input a value", Toast.LENGTH_SHORT).show()
        } else {
            val ph = first_input.text.toString().toDouble()
            val area = second_input.text.toString().toDouble()
            var a = 0.0
            var b = 0.0
            var c = 0.0
            var d = 0.0

            when(ph){
                in 0.0 .. 4.0 -> {
                    a =  0.05 * area
                    b = 0.1 * area
                    c = 0.7 * area
                    d = 1.4 * area
                }
                in 4.1 .. 4.5 -> {
                    a =  0.05 * area
                    b = 0.1 * area
                    c = 0.5 * area
                    d = 1 * area
                }
                in 4.6 .. 5.0 -> {
                    a =  0.025 * area
                    b = 0.05 * area
                    c = 0.4 * area
                    d = 0.8 * area
                }
                in 5.1 .. 5.5 -> {
                    a =  0.025 * area
                    b = 0.05 * area
                    c = 0.3 * area
                    d = 0.5 * area
                }
                in 5.5 .. 6.0 -> {
                    a =  0.025 * area
                    b = 0.05 * area
                    c = 0.15 * area
                    d = 0.3 * area
                }
                in 6.0 .. 7.0 -> {
                    a =  0.01 * area
                    b = 0.025 * area
                    c = 0.1 * area
                    d = 0.15 * area
                }
            }

            tv_first_left_result.text = "$a - "
            tv_first_right_result.text = "$b kilogram"
            tv_second_left_result.text = "$c -"
            tv_second_right_result.text = "$d kilogram"
        }
    }
}
