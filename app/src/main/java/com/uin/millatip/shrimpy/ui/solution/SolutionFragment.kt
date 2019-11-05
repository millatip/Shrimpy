package com.uin.millatip.shrimpy.ui.solution

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager.widget.ViewPager

import com.uin.millatip.shrimpy.R
import com.uin.millatip.shrimpy.ui.solution.color.ColorSolution
import com.uin.millatip.shrimpy.ui.solution.disease.DiseaseSolutionFragment
import com.uin.millatip.shrimpy.utils.ViewPagerAdapter
import kotlinx.android.synthetic.main.solution_fragment.*

class SolutionFragment : Fragment() {

    companion object {
        fun newInstance() = SolutionFragment()
    }

    private lateinit var viewModel: SolutionViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.solution_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(SolutionViewModel::class.java)
        // TODO: Use the ViewModel
        setupViewPager(viewPagerSol)
        tabLayoutSol.setupWithViewPager(viewPagerSol)
    }

    private fun setupViewPager(viewPagerSol: ViewPager) {
        val adapter = ViewPagerAdapter(childFragmentManager)
        adapter.addFragment(ColorSolution(), "Warna Air")
        adapter.addFragment(DiseaseSolutionFragment(), "Penyakit Udang")
        viewPagerSol.adapter = adapter
    }

}
