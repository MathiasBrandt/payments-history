package com.mathiasbrandt.paymentshistory.models

import com.mathiasbrandt.paymentshistory.R

enum class Month(val id: Int, val nameResId: Int) {
    JAN(1, R.string.month_jan),
    FEB(2, R.string.month_feb),
    MAR(3, R.string.month_mar),
    APR(4, R.string.month_apr),
    MAY(5, R.string.month_may),
    JUN(6, R.string.month_jun),
    JUL(7, R.string.month_jul),
    AUG(8, R.string.month_aug),
    SEP(9, R.string.month_sep),
    OCT(10, R.string.month_oct),
    NOV(11, R.string.month_nov),
    DEC(12, R.string.month_dec);

    companion object {
        fun getList(): List<Month> {
            return listOf(JAN, FEB, MAR, APR, MAY, JUN, JUL, AUG, SEP, OCT, NOV, DEC)
        }
    }
}