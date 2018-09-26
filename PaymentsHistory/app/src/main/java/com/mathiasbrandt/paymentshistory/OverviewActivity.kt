package com.mathiasbrandt.paymentshistory

import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class OverviewActivity : AppCompatActivity() {
    private val viewModelFactory = Injector.get().viewModelFactory()
    private lateinit var overviewVM: OverviewViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_overview)

        overviewVM = ViewModelProviders.of(this, viewModelFactory).get(OverviewViewModel::class.java)
        overviewVM.getLivePayments().observe(this, Observer { payments -> payments?.let { paymentListUpdated(payments) } })
    }

    private fun paymentListUpdated(paymentList: PaymentList) {

    }
}
