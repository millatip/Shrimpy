package com.uin.millatip.shrimpy

import androidx.viewpager.widget.ViewPager
import com.uin.millatip.shrimpy.base.BaseActivity
import com.uin.millatip.shrimpy.ui.calculation.CalculationFragment
import com.uin.millatip.shrimpy.ui.management.ManagementFragment
import com.uin.millatip.shrimpy.ui.solution.SolutionFragment
import com.uin.millatip.shrimpy.utils.ViewPagerAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity() {
    override fun getLayoutById(): Int = R.layout.activity_main

    override fun bottomNavListener() {
        bottomNavigationView.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.action_solution -> viewPager.currentItem = 0
                R.id.action_calculate -> viewPager.currentItem = 1
                R.id.action_manage -> viewPager.currentItem = 2
            }
            true
        }
    }

    override fun setupViewPager(viewPager: ViewPager) {
        val adapter = ViewPagerAdapter(supportFragmentManager)
        adapter.addFragment(SolutionFragment(), "Inbox")
        adapter.addFragment(CalculationFragment(), "TvShow")
        adapter.addFragment(ManagementFragment(), "Favorite")
        viewPager.adapter = adapter
    }
}
