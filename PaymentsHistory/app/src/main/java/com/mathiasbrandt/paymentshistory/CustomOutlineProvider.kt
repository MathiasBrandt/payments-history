package com.mathiasbrandt.paymentshistory

import android.graphics.Outline
import android.view.View
import android.view.ViewOutlineProvider

class CustomOutlineProvider(val width: Int, val height: Int): ViewOutlineProvider() {
    override fun getOutline(view: View?, outline: Outline?) {
        outline?.setRect(0, 0, width, height)
    }
}