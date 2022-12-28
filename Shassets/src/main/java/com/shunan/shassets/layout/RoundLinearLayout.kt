package com.shunan.shassets.layout

import android.content.Context
import android.graphics.Canvas
import android.util.AttributeSet
import android.widget.LinearLayout
import androidx.core.content.ContextCompat
import androidx.databinding.BindingAdapter
import com.shunan.shassets.CircularDrawable
import com.shunan.shassets.R

class RoundLinearLayout : LinearLayout {
	
	var rllTint: Int = 0
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
		val a = context.obtainStyledAttributes(attrs, R.styleable.RoundLinearLayout)
		cornerRadius = a.getDimension(R.styleable.RoundLinearLayout_rll_corner_radius, 0f)
		rllTint = a.getColor(R.styleable.RoundLinearLayout_rll_tint, ContextCompat.getColor(context, R.color.colorPrimary))
		elevation = 0f
		stateListAnimator = null
		background = CircularDrawable.Builder(context)
			.cornerRadius(cornerRadius.toInt())
			.colorCode(rllTint)
			.build()
		
		a.recycle()
	}
	
	fun setColorTint(tint: Int) {
		this.rllTint = tint
		invalidate()
	}
	
	
	override fun dispatchDraw(canvas: Canvas?) {
		super.dispatchDraw(canvas)
		background = CircularDrawable.Builder(context)
			.cornerRadius(cornerRadius.toInt())
			.colorCode(rllTint)
			.build()
	}
	
}


@BindingAdapter("oll_tint")
fun bindTint(view: RoundLinearLayout, tint: Int) {
	view.setColorTint(tint)
}
