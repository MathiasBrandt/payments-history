package com.mathiasbrandt.paymentshistory

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import org.jetbrains.anko.AnkoLogger


class OverviewActivity : AppCompatActivity(), AnkoLogger {
//    private val viewModelFactory = Injector.get().viewModelFactory()
//    private lateinit var overviewVM: OverviewViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_overview)

        supportFragmentManager.beginTransaction()
                .replace(R.id.overview_fragment_container, MonthListFragment())
                .commitNow()
    }
}
