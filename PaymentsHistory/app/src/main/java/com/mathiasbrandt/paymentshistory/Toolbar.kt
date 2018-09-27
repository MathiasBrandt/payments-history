package com.mathiasbrandt.paymentshistory

import android.content.Context
import android.content.res.TypedArray
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.constraintlayout.widget.ConstraintLayout
import kotlinx.android.synthetic.main.custom_view_toolbar.view.*
import org.jetbrains.anko.AnkoLogger
import org.jetbrains.anko.info

class Toolbar @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0):
        ConstraintLayout(context, attrs, defStyleAttr), AnkoLogger {

    init {
        LayoutInflater.from(context).inflate(R.layout.custom_view_toolbar, this, true)

        attrs?.let {
            val attributes = context.obtainStyledAttributes(it, R.styleable.Toolbar)
            setUpAttributes(attributes)
            attributes.recycle()
        }
    }

    private fun setUpAttributes(attrs: TypedArray) {
        val title = attrs.getString(R.styleable.Toolbar_android_text) ?: ""
        setTitle(title)
    }

    private fun setTitle(title: String) {
        toolbar_title.text = title
    }

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)
        outlineProvider = CustomOutlineProvider(w, h)
    }
}