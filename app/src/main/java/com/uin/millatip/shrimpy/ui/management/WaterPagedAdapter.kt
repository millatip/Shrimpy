package com.uin.millatip.shrimpy.ui.management

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.uin.millatip.shrimpy.R
import com.uin.millatip.shrimpy.db.model.WaterQuality
import com.uin.millatip.shrimpy.ui.management.detail_water.DetailWaterActivity
import kotlinx.android.synthetic.main.water_note_item.view.*

class WaterPagedAdapter : PagedListAdapter<WaterQuality, WaterPagedAdapter.PagedWaterViewHolder>(
    DIFF_CALLBACK
) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PagedWaterViewHolder {
        return PagedWaterViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.water_note_item,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: PagedWaterViewHolder, position: Int) {
        val water = getItem(position)
        holder.bind(water!!)
    }

    class PagedWaterViewHolder(view: View) : RecyclerView.ViewHolder(view){
        fun bind(waterQuality: WaterQuality){
            itemView.tv_water_color.text = " : ${waterQuality.waterColor}"
            itemView.tv_date.text = waterQuality.date
            itemView.tv_time.text = waterQuality.time
            itemView.tv_brightness.text = " : ${waterQuality.brightness} cm"
            itemView.tv_ph.text = " : ${waterQuality.ph}"
            itemView.tv_do.text = " : ${waterQuality.waterDo} ppm"
            itemView.tv_salinity.text = " : ${waterQuality.salinity} ppt"
            itemView.tv_temp.text = " : ${waterQuality.temperature} C"
            itemView.setOnClickListener {
                val intent = Intent(itemView.context, DetailWaterActivity::class.java)
                intent.putExtra("extra_water", waterQuality)
                itemView.context.startActivity(intent)
            }
        }
    }

    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<WaterQuality>() {
            override fun areItemsTheSame(oldItem: WaterQuality, newItem: WaterQuality): Boolean = oldItem.id == newItem.id
            override fun areContentsTheSame(oldItem: WaterQuality, newItem: WaterQuality): Boolean = oldItem == newItem
        }
    }
}
