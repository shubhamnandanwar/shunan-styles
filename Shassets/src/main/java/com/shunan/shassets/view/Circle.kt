package com.shunan.shassets.view

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import androidx.appcompat.widget.AppCompatTextView
import android.util.AttributeSet
import com.shunan.shassets.R

class Circle : AppCompatTextView {
    var circleColor = Color.LTGRAY
        set(value) {
            field = value
            circlePaint.color = value
            invalidate()
        }

    var circlePaint = Paint()

    constructor(context: Context) : super(context) {
        init(context, null)
    }

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        init(context, attrs)
    }

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        init(context, attrs)
    }

    override fun draw(canvas: Canvas) {
        val h = this.height
        val w = this.width

        val diameter = if (h > w) h else w
        val radius = diameter / 2

        this.height = diameter
        this.width = diameter

        canvas.drawCircle(radius.toFloat(), radius.toFloat(), radius.toFloat(), circlePaint)

        super.draw(canvas)
    }

    private fun init(context: Context, attrs: AttributeSet?) {

        circlePaint.flags = Paint.ANTI_ALIAS_FLAG
        circlePaint.isAntiAlias = true
        circlePaint.style = Paint.Style.FILL

        if (attrs != null) {
            val typedArray = context.theme.obtainStyledAttributes(attrs, R.styleable.Circle, 0, 0)
            circleColor = typedArray.getColor(R.styleable.Circle_cir_color, Color.LTGRAY)
            typedArray.recycle()
        }
        circlePaint.color = circleColor

    }

}
