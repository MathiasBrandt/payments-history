package com.mathiasbrandt.paymentshistory

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.google.android.gms.tasks.OnCompleteListener
import com.google.android.gms.tasks.Task
import com.google.firebase.firestore.QuerySnapshot
import org.jetbrains.anko.AnkoLogger
import org.jetbrains.anko.info
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