package com.mathiasbrandt.paymentshistory.custom

import android.graphics.Outline
import android.view.View
import android.view.ViewOutlineProvider

class RectangularOutlineProvider(val width: Int, val height: Int): ViewOutlineProvider() {
    override fun getOutline(view: View?, outline: Outline?) {
        outline?.setRect(0, 0, width, height)
    }
}