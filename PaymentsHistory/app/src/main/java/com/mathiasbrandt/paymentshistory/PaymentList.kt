package com.mathiasbrandt.paymentshistory

class PaymentList {
    private val payments = mutableMapOf<Long, MutableList<Payment>>()

    init {
        for(month: Long in Month.JAN..Month.DEC) {
            payments[month] = mutableListOf()
        }
    }

    fun addPayment(payment: Payment) {
        payments[payment.month]?.add(payment)
    }
}