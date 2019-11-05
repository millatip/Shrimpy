package com.uin.millatip.shrimpy.ui.calculation.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Html
import android.widget.Toast
import com.uin.millatip.shrimpy.R
import kotlinx.android.synthetic.main.activity_makanan.*

class MakananActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_makanan)
        supportActionBar?.title = "Penjatahan Pangan"
        btn_count_makan.setOnClickListener {
            count()
        }
        tv_note_makan.text = Html.fromHtml(getString(R.string.ketentuan_pemberian_pakan_isi))
    }

    private fun count() {
        if (first_input_makan.text.toString() == "" ){
            Toast.makeText(this, "Please input a value", Toast.LENGTH_SHORT).show()
        } else {
            val age = first_input_makan.text.toString().toInt()
            var shrimpSize = ""
            var foodShape = ""
            var foodNumber = ""
            var dosis = ""
            var frequence = 0
            var ancoCheck = ""

            when(age){
                in 1 .. 15 -> {
                    shrimpSize = "PL 10-0,1 gram"
                    foodShape = "Crumble"
                    foodNumber = "0"
                    dosis = "75-25 %"
                    frequence = 3
                    ancoCheck = "-"
                }
                in 16 .. 30 -> {
                    shrimpSize = "1,1-2,5 gram"
                    foodShape = "Crumble"
                    foodNumber = "1 + 2"
                    dosis = "25-15 %"
                    frequence = 4
                    ancoCheck = "-"
                }
                in 31 .. 45 -> {
                    shrimpSize = "2,6-5,0 gram"
                    foodShape = "Pellet"
                    foodNumber = "2"
                    dosis = "15-10 %"
                    frequence = 5
                    ancoCheck = "2,0-3,0 jam"
                }
                in 45 .. 60 -> {
                    shrimpSize = "5,1-8,0 gram"
                    foodShape = "Pellet"
                    foodNumber = "2+3"
                    dosis = "10 - 7 %"
                    frequence = 5
                    ancoCheck = "2,0-2,5 jam"
                }
                in 61 .. 75 -> {
                    shrimpSize = "8,1-14,0 gram"
                    foodShape = "Pellet"
                    foodNumber = "3"
                    dosis = "7 – 5 %"
                    frequence = 5
                    ancoCheck = "1,5-2,0 jam"
                }
                in 76 .. 90 -> {
                    shrimpSize = "14,1-18,0 gram"
                    foodShape = "Pellet"
                    foodNumber = "3+4"
                    dosis = "5 – 3  %"
                    frequence = 5
                    ancoCheck = "1,5-2,0 jam"
                }
                in 91 .. 105 -> {
                    shrimpSize = "18,1-20,1 gram"
                    foodShape = "Pellet"
                    foodNumber = "4"
                    dosis = "5 – 3  %"
                    frequence = 5
                    ancoCheck = "1,0-1,5 jam"
                }
                in 106 .. 120 -> {
                    shrimpSize = "20,1-22,5 gram"
                    foodShape = "Pellet"
                    foodNumber = "4"
                    dosis = "4 – 2 %"
                    frequence = 5
                    ancoCheck = "1,0-1,5 jam"
                }
            }

            first_value.text = shrimpSize
            second_value.text = foodShape
            third_value.text = foodNumber
            fourth_value.text = dosis
            fifth_value.text = "$frequence kali per Hari"
            sixth_value.text = ancoCheck
        }
    }
}
