package com.shunan.shassets.view

import android.content.Context
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatTextView
import androidx.core.content.ContextCompat
import com.shunan.shassets.CircularDrawable
import com.shunan.shassets.R

class OutlinedTextView : AppCompatTextView {
	
	constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {
		style(context, attrs)
	}
	
	constructor(context: Context, attrs: AttributeSet?, defStyle: Int) : super(context, attrs, defStyle) {
		style(context, attrs)
	}
	
	private fun style(context: Context, attrs: AttributeSet?) {
		val a = context.obtainStyledAttributes(attrs, R.styleable.OutlinedTextView)
		val cornerRadius = a.getDimension(R.styleable.OutlinedTextView_otv_corner_radius, 0f)
		val tintColor = a.getColor(R.styleable.OutlinedTextView_otv_tint, ContextCompat.getColor(context, R.color.light_divider))
		val strokeWidth = a.getDimension(R.styleable.OutlinedTextView_otv_stroke_width, 4f)
		
		background = CircularDrawable.Builder(context)
			.cornerRadius(cornerRadius.toInt())
			.strokeWidth(strokeWidth.toInt())
			.colorCode(tintColor)
			.build()
		
		a.recycle()
	}
}