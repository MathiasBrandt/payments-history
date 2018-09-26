package com.mathiasbrandt.paymentshistory

import android.animation.Animator
import android.animation.ObjectAnimator
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_overview.*
import org.jetbrains.anko.AnkoLogger
import org.jetbrains.anko.info

class OverviewActivity : AppCompatActivity(), AnkoLogger {
    private val viewModelFactory = Injector.get().viewModelFactory()
    private lateinit var overviewVM: OverviewViewModel

    private var isAnimatingList = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_overview)

        overviewVM = ViewModelProviders.of(this, viewModelFactory).get(OverviewViewModel::class.java)
        overviewVM.getLivePayments().observe(this, Observer { payments -> payments?.let { paymentListUpdated(payments) } })

        val adapter = OverviewListAdapter(listOf(Month(), Month(), Month(), Month(), Month(), Month(), Month(), Month(), Month(), Month(), Month(), Month(), Month(), Month(), Month(), Month(), Month(), Month(), Month(), Month(), Month(), Month(), Month(), Month(), Month(), Month(), Month(), Month(), Month(), Month(), Month(), Month(), Month(), Month(), Month(), Month(), Month(), Month(), Month(), Month(), Month(), Month(), Month(), Month(), Month(), Month(), Month(), Month(), Month(), Month(), Month(), Month(), Month(), Month()))
        activity_overview_list.adapter = adapter
        activity_overview_list.overScrollMode = View.OVER_SCROLL_NEVER

        activity_overview_list.setOnScrollChangeListener(object: View.OnScrollChangeListener {
            override fun onScrollChange(p0: View?, p1: Int, p2: Int, p3: Int, p4: Int) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

        })

        activity_overview_list.setOnScrollChangeListener { _, _, _, _, _ ->
            info("##### triggered!")
            val canScrollUp = activity_overview_list.canScrollVertically(-1)

            if(!isAnimatingList && canScrollUp) {
                isAnimatingList = true
                supportActionBar?.let { actionBar ->
                    // replace "elevation" with "translationZ"? (set default elevation=10 and translationZ=0 first)
                    ObjectAnimator.ofFloat(actionBar, "elevation", 10F).apply {
                        duration = 200
                        addListener(object: Animator.AnimatorListener {
                            override fun onAnimationRepeat(p0: Animator?) {}

                            override fun onAnimationEnd(p0: Animator?) {
                                isAnimatingList = false
                            }

                            override fun onAnimationCancel(p0: Animator?) {}

                            override fun onAnimationStart(p0: Animator?) {}

                        })
                        start()
                    }
                }
            } else if(!canScrollUp) {
                supportActionBar?.let { actionBar ->
                    ObjectAnimator.ofFloat(actionBar, "elevation", 0F).apply {
                        duration = 200
                        start()
                    }
                }
            }

        }
    }

    private fun paymentListUpdated(paymentList: PaymentList) {

    }
}
