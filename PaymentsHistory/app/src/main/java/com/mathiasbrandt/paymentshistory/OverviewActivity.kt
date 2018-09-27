package com.mathiasbrandt.paymentshistory

import android.animation.Animator
import android.animation.ObjectAnimator
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import kotlinx.android.synthetic.main.activity_overview.*
import org.jetbrains.anko.AnkoLogger
import org.jetbrains.anko.info

class OverviewActivity : AppCompatActivity(), AnkoLogger {
    private val viewModelFactory = Injector.get().viewModelFactory()
    private lateinit var overviewVM: OverviewViewModel

    // replace "elevation" with "translationZ"? (set default elevation=10 and translationZ=0 first)
    private lateinit var headerAnimator: ObjectAnimator
    private var isAnimatingList = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_overview)
        supportActionBar?.let { actionBar ->
            headerAnimator = ObjectAnimator.ofFloat(actionBar, "elevation", 10F).apply {
                duration = 200
                addListener(object : AnimationEndListener() {
                    override fun onAnimationEnd(p0: Animator?) {
                        isAnimatingList = false
                    }
                })
                setAutoCancel(false)
            }
        }

        overviewVM = ViewModelProviders.of(this, viewModelFactory).get(OverviewViewModel::class.java)
        overviewVM.getLivePayments().observe(this, Observer { payments -> payments?.let { paymentListUpdated(payments) } })

        val adapter = OverviewListAdapter(listOf(Month(), Month(), Month(), Month(), Month(), Month(), Month(), Month(), Month(), Month(), Month(), Month(), Month(), Month(), Month(), Month(), Month(), Month(), Month(), Month(), Month(), Month(), Month(), Month(), Month(), Month(), Month(), Month(), Month(), Month(), Month(), Month(), Month(), Month(), Month(), Month(), Month(), Month(), Month(), Month(), Month(), Month(), Month(), Month(), Month(), Month(), Month(), Month(), Month(), Month(), Month(), Month(), Month(), Month()))
        activity_overview_list.adapter = adapter
        activity_overview_list.overScrollMode = View.OVER_SCROLL_NEVER

        activity_overview_list.setOnScrollChangeListener { _, _, _, _, _ ->
            val canScrollUp = activity_overview_list.canScrollVertically(-1)

            supportActionBar?.let { actionBar ->
                if (!isAnimatingList && canScrollUp && actionBar.elevation == 0F) {
                    isAnimatingList = true
                    headerAnimator.start()
                } else if (!isAnimatingList && !canScrollUp && actionBar.elevation > 0F) {
                    isAnimatingList = true
                    headerAnimator.reverse()
                }
            }

        }
    }

    private fun paymentListUpdated(paymentList: PaymentList) {

    }
}
