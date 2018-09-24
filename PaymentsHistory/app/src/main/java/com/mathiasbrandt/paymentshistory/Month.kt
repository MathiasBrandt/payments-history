package com.mathiasbrandt.paymentshistory

class Month {
    companion object {
        const val JAN: Long = 1
        const val FEB: Long = 2
        const val MAR: Long = 3
        const val APR: Long = 4
        const val MAY: Long = 5
        const val JUN: Long = 6
        const val JUL: Long = 7
        const val AUG: Long = 8
        const val SEP: Long = 9
        const val OCT: Long = 10
        const val NOV: Long = 11
        const val DEC: Long = 12

        fun isValid(month: Int): Boolean = month in JAN..DEC
    }
}