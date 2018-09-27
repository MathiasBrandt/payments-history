package com.mathiasbrandt.paymentshistory

import android.animation.ObjectAnimator
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_month_list.*
import org.jetbrains.anko.AnkoLogger

class MonthListFragment: Fragment(), AnkoLogger {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return layoutInflater.inflate(R.layout.fragment_month_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        setUpMonthList()
    }

    private fun setUpMonthList() {
        val adapter = OverviewListAdapter(Month.getList())
        month_list.adapter = adapter
        month_list.overScrollMode = View.OVER_SCROLL_NEVER

        month_list.setOnScrollChangeListener { _, _, _, _, _ ->
            month_list_toolbar.isSelected = month_list.canScrollVertically(-1)
        }
    }
}