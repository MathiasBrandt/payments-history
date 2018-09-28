package com.mathiasbrandt.paymentshistory.overview

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.mathiasbrandt.paymentshistory.Payment
import com.mathiasbrandt.paymentshistory.PaymentList
import com.mathiasbrandt.paymentshistory.firebase.FirebaseConstants
import com.mathiasbrandt.paymentshistory.firebase.Firestore
import org.jetbrains.anko.AnkoLogger
import javax.inject.Inject

class OverviewViewModel @Inject constructor(): ViewModel(), AnkoLogger {
    private val livePayments = MutableLiveData<PaymentList>()
    fun getLivePayments(): LiveData<PaymentList> = livePayments

    fun getPayments() {
        Firestore.payments(FirebaseConstants.GROUP_ID).get().addOnCompleteListener { task ->
            if(task.isSuccessful) {
                val payments = Payment.parse(task.result)
                livePayments.value = payments
            }
        }
    }

    fun getPayments(month: Int) {
//        val payments = Firestore.payments(FirebaseConstants.GROUP_ID).whereEqualTo(FirebaseConstants.MONTH, month).get().addOnCompleteListener { task ->
//            if(task.isSuccessful) {
//                info("got payments for month: $month")
//                val payments = Payment.parse(task.result)
//                info("### END")
//            }
//        }
    }
}