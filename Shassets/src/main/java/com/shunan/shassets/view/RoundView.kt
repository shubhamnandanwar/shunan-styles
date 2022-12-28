package com.shunan.shassets.view

import android.content.Context
import android.util.AttributeSet
import android.view.View
import androidx.core.content.ContextCompat
import com.shunan.shassets.CircularDrawable
import com.shunan.shassets.R

class RoundView : View {
	
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
		val a = context.obtainStyledAttributes(attrs, R.styleable.RoundView)
		cornerRadius = a.getDimension(R.styleable.RoundView_rv_corner_radius, 0f)
		cbTint = a.getColor(R.styleable.RoundView_rv_tint, ContextCompat.getColor(context, R.color.colorPrimary))
		elevation = 0f
		stateListAnimator = null
		background = CircularDrawable.Builder(context)
			.cornerRadius(cornerRadius.toInt())
			.colorCode(cbTint)
			.build()
		
		a.recycle()
	}
}
