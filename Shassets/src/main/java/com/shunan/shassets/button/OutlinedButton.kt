package com.shunan.shassets.button

import android.content.Context
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatButton
import androidx.core.content.ContextCompat
import com.shunan.shassets.CircularDrawable
import com.shunan.shassets.R

class OutlinedButton : AppCompatButton {
	
	constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {
		style(context, attrs)
	}
	
	constructor(context: Context, attrs: AttributeSet?, defStyle: Int) : super(context, attrs, defStyle) {
		style(context, attrs)
	}
	
	private fun style(context: Context, attrs: AttributeSet?) {
		val a = context.obtainStyledAttributes(attrs, R.styleable.OutlinedButton)
		val cornerRadius = a.getDimension(R.styleable.OutlinedButton_ob_corner_radius, 0f)
		val tintColor = a.getColor(R.styleable.OutlinedButton_ob_tint, ContextCompat.getColor(context, R.color.light_divider))
		val strokeWidth = a.getDimension(R.styleable.OutlinedButton_ob_stroke_width, 4f)
		
		background = CircularDrawable.Builder(context)
			.cornerRadius(cornerRadius.toInt())
			.strokeWidth(strokeWidth.toInt())
			.colorCode(tintColor)
			.build()
		
		a.recycle()
	}
}