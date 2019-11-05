package com.uin.millatip.shrimpy.ui.calculation

import android.content.Intent
import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.uin.millatip.shrimpy.R
import com.uin.millatip.shrimpy.ui.calculation.activities.*
import kotlinx.android.synthetic.main.calculation_fragment.*

class CalculationFragment : Fragment() {

    companion object {
        fun newInstance() = CalculationFragment()
    }

    private lateinit var viewModel: CalculationViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.calculation_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(CalculationViewModel::class.java)
        pengapuran_card.setOnClickListener {
            val intent = Intent(context, PengapuranActivity::class.java)
            startActivity(intent)
        }
        penebaran_card.setOnClickListener {
            val intent = Intent(context, PenebaranActivity::class.java)
            startActivity(intent)
        }
        pangan_card.setOnClickListener {
            val intent = Intent(context, MakananActivity::class.java)
            startActivity(intent)
        }
        pupuk_card.setOnClickListener {
            val intent = Intent(context, PemupukanActivity::class.java)
            startActivity(intent)
        }
        ppm_card.setOnClickListener {
            val intent = Intent(context, PpmActivity::class.java)
            startActivity(intent)
        }
        fcr_card.setOnClickListener {
            val intent = Intent(context, FcrActivity::class.java)
            startActivity(intent)
        }
    }

}
