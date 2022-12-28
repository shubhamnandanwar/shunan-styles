package com.shunan.shassets.view

import android.content.Context
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatTextView
import androidx.core.content.ContextCompat
import com.shunan.shassets.CircularDrawable
import com.shunan.shassets.R

class RoundTextView : AppCompatTextView {
	
	constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {
		style(context, attrs)
	}
	
	constructor(context: Context, attrs: AttributeSet?, defStyle: Int) : super(context, attrs, defStyle) {
		style(context, attrs)
	}
	
	private fun style(context: Context, attrs: AttributeSet?) {
		val a = context.obtainStyledAttributes(attrs, R.styleable.RoundTextView)
		val cornerRadius = a.getDimension(R.styleable.RoundTextView_corner_radius, 0f)
		val strokeWidth = a.getDimension(R.styleable.RoundTextView_stroke_width, 0f)
		val leftTopRadius = a.getDimension(R.styleable.RoundTextView_left_top_radius, cornerRadius)
		val leftBottomRadius = a.getDimension(R.styleable.RoundTextView_left_bottom_radius, cornerRadius)
		val rightBottomRadius = a.getDimension(R.styleable.RoundTextView_right_bottom_radius, cornerRadius)
		val rightTopRadius = a.getDimension(R.styleable.RoundTextView_right_top_radius, cornerRadius)
		val outlineFlag = a.getBoolean(R.styleable.RoundTextView_draw_outline, false)
		val tintColor = a.getColor(R.styleable.RoundTextView_tint_color, ContextCompat.getColor(context, R.color.colorPrimary))
		
		background = CircularDrawable.Builder(context)
			.cornerRadius(leftTopRadius = leftTopRadius.toInt(), leftBottomRadius = leftBottomRadius.toInt(), rightTopRadius = rightTopRadius.toInt(), rightBottomRadius = rightBottomRadius.toInt())
			.strokeWidth(if (outlineFlag) strokeWidth.toInt() else 0)
			.colorCode(tintColor)
			.build()
		
		a.recycle()
	}
}
