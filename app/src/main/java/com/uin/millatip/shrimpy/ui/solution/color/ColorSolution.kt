package com.uin.millatip.shrimpy.ui.solution.color

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.uin.millatip.shrimpy.R
import kotlinx.android.synthetic.main.color_solution_fragment.*

class ColorSolution : Fragment() {

    companion object {
        fun newInstance() = ColorSolution()
    }

    private lateinit var viewModel: ColorSolutionViewModel
    private var adapter: ColorFragmentAdapter = ColorFragmentAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.color_solution_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        rv_color.layoutManager = LinearLayoutManager(context)
        rv_color.adapter = adapter
        rv_color.hasFixedSize()
        rv_color.clearAnimation()
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(ColorSolutionViewModel::class.java)
    }
    override fun onResume() {
        super.onResume()
        viewModel.getItems().observe(this, Observer { item ->
            progress_bar_color.visibility = View.GONE
            adapter.updateWaterList(item)
        })
    }

}
