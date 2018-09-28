package com.mathiasbrandt.paymentshistory

import com.google.firebase.firestore.QueryDocumentSnapshot
import com.google.firebase.firestore.QuerySnapshot
import com.mathiasbrandt.paymentshistory.models.Month

data class Payment(val id: String, val userId: String, val description: String, val amount: Long, val month: Month) {
    companion object {
        fun parse(result: QuerySnapshot): PaymentList {
            val list = PaymentList()
            result.forEach { document ->
                list.addPayment(parse(document))
            }
            return list
        }
        fun parse(document: QueryDocumentSnapshot): Payment {
            return Payment(
                    document.id,
                    document.data["userId"] as? String ?: "",
                    document.data["description"] as? String ?: "",
                    document.data["amount"] as? Long ?: 0,
                    document.data["month"] as? Month
                            ?: Month.JAN
            )
        }
    }
}