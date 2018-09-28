package com.mathiasbrandt.paymentshistory

import com.mathiasbrandt.paymentshistory.models.Month

class PaymentList {
    private val payments = mutableMapOf<Month, MutableList<Payment>>()

    init {
        for(month in Month.getList()) {
            payments[month] = mutableListOf()
        }
    }

    fun addPayment(payment: Payment) {
        payments[payment.month]?.add(payment)
    }
}