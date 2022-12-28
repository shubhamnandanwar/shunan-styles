package com.shunan.shassets.layout

import android.content.Context
import android.graphics.Canvas
import android.util.AttributeSet
import android.widget.RelativeLayout
import androidx.core.content.ContextCompat
import androidx.databinding.BindingAdapter
import com.shunan.shassets.CircularDrawable
import com.shunan.shassets.R

class OutlineRelativeLayout : RelativeLayout {
	
	var orlTint: Int = 0
	var orlStrokeWidth: Float = 0f
	var cornerRadius: Float = 0f
	
	constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {
		style(context, attrs)
	}
	
	constructor(context: Context, attrs: AttributeSet?, defStyle: Int) : super(context, attrs, defStyle) {
		style(context, attrs)
	}
	
	fun setColorTint(tint: Int) {
		this.orlTint = tint
		invalidate()
	}
	
	fun setThickness(width: Float) {
		this.orlStrokeWidth = width
		invalidate()
	}
	
	override fun dispatchDraw(canvas: Canvas?) {
		super.dispatchDraw(canvas)
		background = CircularDrawable.Builder(context)
			.strokeWidth(orlStrokeWidth.toInt())
			.cornerRadius(cornerRadius.toInt())
			.colorCode(orlTint)
			.build()
		
	}
	
	private fun style(context: Context, attrs: AttributeSet?) {
		val a = context.obtainStyledAttributes(attrs, R.styleable.OutlineRelativeLayout)
		cornerRadius = a.getDimension(R.styleable.OutlineRelativeLayout_orl_corner_radius, 0f)
		orlTint = a.getColor(R.styleable.OutlineRelativeLayout_orl_tint, ContextCompat.getColor(context, R.color.light_divider))
		orlStrokeWidth = a.getDimension(R.styleable.OutlineRelativeLayout_orl_stroke_width, 4f)
		
		elevation = 0f
		stateListAnimator = null
		background = CircularDrawable.Builder(context)
			.strokeWidth(orlStrokeWidth.toInt())
			.cornerRadius(cornerRadius.toInt())
			.colorCode(orlTint)
			.build()
		a.recycle()
	}
}

@BindingAdapter("orl_stroke_width")
fun bindStrokeWidth(view: OutlineRelativeLayout, strokeWidth: Float) {
	view.setThickness(strokeWidth)
}

@BindingAdapter("orl_tint")
fun bindTint(view: OutlineRelativeLayout, tint: Int) {
	view.setColorTint(tint)
}
