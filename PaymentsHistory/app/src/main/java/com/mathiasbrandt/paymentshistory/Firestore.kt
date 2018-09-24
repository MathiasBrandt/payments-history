package com.mathiasbrandt.paymentshistory

import com.google.firebase.firestore.CollectionReference
import com.google.firebase.firestore.FirebaseFirestore

class Firestore {
    companion object {
        private val db = FirebaseFirestore.getInstance()

        fun payments(groupId: String): CollectionReference {
            return db.collection(FirebaseConstants.COLLECTION_USER_GROUPS).document(groupId).collection(FirebaseConstants.COLLECTION_PAYMENTS)
        }
    }
}