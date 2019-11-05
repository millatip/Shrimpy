package com.uin.millatip.shrimpy.ui.solution.disease

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager

import com.uin.millatip.shrimpy.R
import com.uin.millatip.shrimpy.ui.solution.color.ColorFragmentAdapter
import kotlinx.android.synthetic.main.color_solution_fragment.*
import kotlinx.android.synthetic.main.disease_solution_fragment.*

class DiseaseSolutionFragment : Fragment() {

    companion object {
        fun newInstance() = DiseaseSolutionFragment()
    }

    private lateinit var viewModel: DiseaseSolutionViewModel
    private val adapter: ColorFragmentAdapter = ColorFragmentAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.disease_solution_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        rv_disease.layoutManager = LinearLayoutManager(context)
        rv_disease.adapter = adapter
        rv_disease.hasFixedSize()
        rv_disease.clearAnimation()
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(DiseaseSolutionViewModel::class.java)
        // TODO: Use the ViewModel
    }

    override fun onResume() {
        super.onResume()
        viewModel.getItems().observe(this, Observer { item ->
            progress_bar_disease.visibility = View.GONE
            adapter.updateWaterList(item)
        })
    }
}
