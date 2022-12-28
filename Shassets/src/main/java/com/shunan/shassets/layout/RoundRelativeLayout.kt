package com.shunan.shassets.layout

import android.content.Context
import android.graphics.Canvas
import android.util.AttributeSet
import android.widget.RelativeLayout
import androidx.core.content.ContextCompat
import androidx.databinding.BindingAdapter
import com.shunan.shassets.CircularDrawable
import com.shunan.shassets.R

class RoundRelativeLayout : RelativeLayout {
	
	var rrlTint: Int = 0
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
		val a = context.obtainStyledAttributes(attrs, R.styleable.RoundRelativeLayout)
		cornerRadius = a.getDimension(R.styleable.RoundRelativeLayout_rrl_corner_radius, 0f)
		rrlTint = a.getColor(R.styleable.RoundRelativeLayout_rrl_tint, ContextCompat.getColor(context, R.color.colorPrimary))
		elevation = 0f
		stateListAnimator = null
		background = CircularDrawable.Builder(context)
			.cornerRadius(cornerRadius.toInt())
			.colorCode(rrlTint)
			.build()
		
		a.recycle()
	}
	
	fun setColorTint(tint: Int) {
		this.rrlTint = tint
		invalidate()
	}
	
	
	override fun dispatchDraw(canvas: Canvas?) {
		super.dispatchDraw(canvas)
		background = CircularDrawable.Builder(context)
			.cornerRadius(cornerRadius.toInt())
			.colorCode(rrlTint)
			.build()
	}
	
}


@BindingAdapter("rrl_tint")
fun bindTint(view: RoundRelativeLayout, tint: Int) {
	view.setColorTint(tint)
}
