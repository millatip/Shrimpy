package com.uin.millatip.shrimpy.ui.solution.color

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.uin.millatip.shrimpy.R
import com.uin.millatip.shrimpy.databinding.ExpandableItemBinding
import com.uin.millatip.shrimpy.models.Problem
import com.uin.millatip.shrimpy.ui.solution.color.item.ItemViewModel

class ColorFragmentAdapter : RecyclerView.Adapter<ColorFragmentAdapter.ViewHolder>() {

    private lateinit var waterList: List<Problem>

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding: ExpandableItemBinding =
            DataBindingUtil.inflate(LayoutInflater.from(parent.context), R.layout.expandable_item, parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return if (::waterList.isInitialized) waterList.size else 0
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(waterList[position])
    }

    fun updateWaterList(waterList: List<Problem>) {
        this.waterList = waterList
        notifyDataSetChanged()
    }


    class ViewHolder(private val binding: ExpandableItemBinding) : RecyclerView.ViewHolder(binding.root) {
        private val viewModel = ItemViewModel()

        fun bind(waterItem: Problem) {
            viewModel.bind(waterItem)
            binding.viewModel = viewModel
        }
    }
}
