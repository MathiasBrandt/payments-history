package com.mathiasbrandt.paymentshistory

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.item_overview.view.*

class OverviewListAdapter(val items: List<Month>): RecyclerView.Adapter<OverviewListViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OverviewListViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_overview, parent, false)
        return OverviewListViewHolder(view)
    }

    override fun onBindViewHolder(holder: OverviewListViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int = items.size
}

class OverviewListViewHolder(override val containerView: View): RecyclerView.ViewHolder(containerView), LayoutContainer {
    fun bind(item: Month) {
        containerView.item_overview_title.text = "September"
    }
}