package com.uin.millatip.shrimpy.ui.calculation.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Html
import android.widget.Toast
import com.uin.millatip.shrimpy.R
import kotlinx.android.synthetic.main.activity_penebaran.*
import kotlinx.android.synthetic.main.activity_pengapuran.*

class PenebaranActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_penebaran)
        supportActionBar?.title = "Penebaran"
        btn_count_tebar.setOnClickListener {
            count()
        }
        first_ed_tebar.hint = "m² luas tambak"

        tv_note_tebar.text = Html.fromHtml(getString(R.string.catatan_penebaran_isi))
    }

    private fun count() {
        if (first_input_tebar.text.toString() == ""){
            Toast.makeText(this, "Tolong isi luas tambak", Toast.LENGTH_SHORT).show()
        } else{
            val area = first_input_tebar.text.toString().toInt()
            val a = 60 * area
            val b = 100 * area
            tv_left_result_tebar.text = "$a - "
            tv_right_result_tebar.text ="$b benih"
        }
    }
}
