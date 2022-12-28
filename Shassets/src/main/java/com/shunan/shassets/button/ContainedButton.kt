package com.shunan.shassets.button

import android.content.Context
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatButton
import androidx.core.content.ContextCompat
import com.shunan.shassets.CircularDrawable
import com.shunan.shassets.R

class ContainedButton : AppCompatButton {
	
	var cbTint: Int = 0
	set(value) {
		field = value
		background = CircularDrawable.Builder(context)
			.cornerRadius(cornerRadius.toInt())
			.colorCode(field)
			.build()
	}
	
	var cornerRadius: Float = 0f
	
	constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {
		style(context, attrs)
	}
	
	constructor(context: Context, attrs: AttributeSet?, defStyle: Int) : super(context, attrs, defStyle) {
		style(context, attrs)
	}
	
	private fun style(context: Context, attrs: AttributeSet?) {
		val a = context.obtainStyledAttributes(attrs, R.styleable.ContainedButton)
		cornerRadius = a.getDimension(R.styleable.ContainedButton_cb_corner_radius, 0f)
		cbTint = a.getColor(R.styleable.ContainedButton_cb_tint, ContextCompat.getColor(context, R.color.colorPrimary))
		elevation = 0f
		stateListAnimator = null
		background = CircularDrawable.Builder(context)
			.cornerRadius(cornerRadius.toInt())
			.colorCode(cbTint)
			.build()
		
		a.recycle()
	}
	
	
}

