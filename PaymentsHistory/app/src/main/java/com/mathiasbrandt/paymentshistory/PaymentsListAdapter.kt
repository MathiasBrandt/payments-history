package com.mathiasbrandt.paymentshistory

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class PaymentsListAdapter(val items: List<Payment>): RecyclerView.Adapter<PaymentsListViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PaymentsListViewHolder {
        return PaymentsListViewHolder(View(parent.context))
    }

    override fun onBindViewHolder(holder: PaymentsListViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int = items.size
}

class PaymentsListViewHolder(view: View): RecyclerView.ViewHolder(view) {



    fun bind(item: Payment) {

    }
}