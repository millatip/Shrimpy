package com.uin.millatip.shrimpy.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager
import kotlinx.android.synthetic.main.activity_main.*

abstract class BaseActivity : AppCompatActivity() {

    // --- LIFECYCLE METHODS ---
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayoutById())
        this.bottomNavListener()
        this.setupViewPager(viewPager)
    }

    // --- ABSTRACT METHODS ---
    abstract fun getLayoutById(): Int

    abstract fun bottomNavListener()
    abstract fun setupViewPager(viewPager: ViewPager)
}
