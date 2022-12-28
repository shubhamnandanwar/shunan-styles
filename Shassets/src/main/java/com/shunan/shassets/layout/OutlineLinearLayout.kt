package com.shunan.shassets.layout

import android.content.Context
import android.graphics.Canvas
import android.util.AttributeSet
import android.widget.LinearLayout
import androidx.core.content.ContextCompat
import androidx.databinding.BindingAdapter
import com.shunan.shassets.CircularDrawable
import com.shunan.shassets.R

class OutlineLinearLayout : LinearLayout {
	
	var ollTint: Int = 0
		set(value) {
			field = value
			background = CircularDrawable.Builder(context)
				.cornerRadius(cornerRadius.toInt())
				.colorCode(field)
				.build()
		}
	
	var ollStrokeWidth: Float = 0f
	var cornerRadius: Float = 0f
	
	constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {
		style(context, attrs)
	}
	
	constructor(context: Context, attrs: AttributeSet?, defStyle: Int) : super(context, attrs, defStyle) {
		style(context, attrs)
	}
	
	private fun style(context: Context, attrs: AttributeSet?) {
		val a = context.obtainStyledAttributes(attrs, R.styleable.OutlineLinearLayout)
		cornerRadius = a.getDimension(R.styleable.OutlineLinearLayout_oll_corner_radius, 0f)
		ollTint = a.getColor(R.styleable.OutlineLinearLayout_oll_tint, ContextCompat.getColor(context, R.color.colorPrimary))
		ollStrokeWidth = a.getDimension(R.styleable.OutlineLinearLayout_oll_stroke_width, 4f)
		
		elevation = 0f
		stateListAnimator = null
		background = CircularDrawable.Builder(context)
			.strokeWidth(ollStrokeWidth.toInt())
			.cornerRadius(cornerRadius.toInt())
			.colorCode(ollTint)
			.build()
		
		a.recycle()
	}
	
	override fun dispatchDraw(canvas: Canvas?) {
		super.dispatchDraw(canvas)
		background = CircularDrawable.Builder(context)
			.strokeWidth(ollStrokeWidth.toInt())
			.cornerRadius(cornerRadius.toInt())
			.colorCode(ollTint)
			.build()
	}
	
	fun setThickness(width: Float) {
		this.ollStrokeWidth = width
		invalidate()
	}
	
	fun setColorTint(tint: Int) {
		this.ollTint = tint
		invalidate()
	}
	
}

@BindingAdapter("oll_stroke_width")
fun bindStrokeWidth(view: OutlineLinearLayout, strokeWidth: Float) {
	view.setThickness(strokeWidth)
}

@BindingAdapter("oll_tint")
fun bindTint(view: OutlineLinearLayout, tint: Int) {
	view.setColorTint(tint)
}

