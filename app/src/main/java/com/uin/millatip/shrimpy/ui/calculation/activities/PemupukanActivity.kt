package com.uin.millatip.shrimpy.ui.calculation.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Html
import android.widget.Toast
import com.uin.millatip.shrimpy.R
import kotlinx.android.synthetic.main.activity_pemupukan.*
import kotlinx.android.synthetic.main.activity_pengapuran.*

class PemupukanActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pemupukan)
        supportActionBar?.title = "Pemupukan"
        ed_pupuk_first.hint = "m² luas tambak"
        btn_count_pupuk.setOnClickListener {
            count()
        }
        tv_pupuk_first.text = Html.fromHtml(getString(R.string.tujuan_pemupukan))
        tv_pupuk_second.text = Html.fromHtml(getString(R.string.aturan_pemupukan))
    }

    private fun count() {
        if ( pupuk_first_input.text.toString() == "" || pupuk_second_input.text.toString() == "" ){
            Toast.makeText(this, "Please input a value", Toast.LENGTH_SHORT).show()
        } else {
            val area = pupuk_first_input.text.toString().toDouble()
            val depth = pupuk_second_input.text.toString().toDouble()
            val kg = area * depth / 1000
            tv_result_pupuk.text = "$kg kilogram pupuk Sp36"
        }

    }
}
