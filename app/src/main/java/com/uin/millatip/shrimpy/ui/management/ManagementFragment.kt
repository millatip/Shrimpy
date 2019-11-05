package com.uin.millatip.shrimpy.ui.management

import android.content.Intent
import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager

import com.uin.millatip.shrimpy.R
import com.uin.millatip.shrimpy.db.Injection
import com.uin.millatip.shrimpy.db.ViewModelFactory
import com.uin.millatip.shrimpy.ui.management.water_quality.CreateNoteActivity
import kotlinx.android.synthetic.main.management_fragment.*

class ManagementFragment : Fragment() {

    companion object {
        fun newInstance() = ManagementFragment()
    }

    private lateinit var viewModel: ManagementViewModel
    private lateinit var viewModelFactory: ViewModelFactory

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.management_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModelFactory = Injection.provideViewModelFactory(this.context!!)
        viewModel = ViewModelProviders.of(this, viewModelFactory).get(ManagementViewModel::class.java)

        val adapter = WaterPagedAdapter()
        rv_water.layoutManager = LinearLayoutManager(context)
        rv_water.adapter = adapter

        viewModel.getWaterLiveData().observe(this, Observer {
            if (it != null) {
                adapter.submitList(it)
                adapter.notifyDataSetChanged()
            }
        })

        floating_action_button.setOnClickListener {
            val intent = Intent(context, CreateNoteActivity::class.java)
            startActivity(intent)
        }
    }

}
