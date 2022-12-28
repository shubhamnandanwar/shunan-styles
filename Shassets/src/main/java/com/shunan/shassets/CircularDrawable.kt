package com.shunan.shassets

import android.content.Context
import android.graphics.drawable.GradientDrawable
import androidx.core.content.ContextCompat

class CircularDrawable : GradientDrawable {
	
	private constructor()
	
	class Builder(val context: Context) {
		private var strokeWidth: Int = 0
		private var leftTopRadius: Float = 0f
		private var leftBottomRadius: Float = 0f
		private var rightBottomRadius: Float = 0f
		private var rightTopRadius: Float = 0f
		
		private var colorCode: Int = ContextCompat.getColor(context, R.color.colorPrimary)
		
		fun cornerRadius(leftTopRadius: Int, rightTopRadius: Int, rightBottomRadius: Int, leftBottomRadius: Int): Builder {
			this.leftTopRadius = leftTopRadius.toFloat()
			this.leftBottomRadius = leftBottomRadius.toFloat()
			this.rightBottomRadius = rightBottomRadius.toFloat()
			this.rightTopRadius = rightTopRadius.toFloat()
			return this
		}
		
		fun cornerRadius(radius: Int): Builder {
			leftBottomRadius = radius.toFloat()
			rightBottomRadius = radius.toFloat()
			leftTopRadius = radius.toFloat()
			rightTopRadius = radius.toFloat()
			return this
		}
		
		
		fun strokeWidth(stroke: Int) = apply { strokeWidth = stroke }
		fun colorCode(color: Int) = apply { this.colorCode = color }
		
		fun build(): CircularDrawable {
			
			val drawable = CircularDrawable()
			//drawable.cornerRadius = cornerRadius.toFloat()
			drawable.cornerRadii = floatArrayOf(leftTopRadius, leftTopRadius, rightTopRadius, rightTopRadius, rightBottomRadius, rightBottomRadius, leftBottomRadius, leftBottomRadius)
			
			drawable.shape = RECTANGLE
			if (strokeWidth > 0)
				drawable.setStroke(strokeWidth, colorCode)
			else drawable.setColor(colorCode)
			return drawable
		}
	}
	
}

fun getRoundDrawable(context: Context, stroke: Int, radius: Int, colorCode: Int): CircularDrawable {
	return CircularDrawable.Builder(context).strokeWidth(stroke).cornerRadius(radius).colorCode(colorCode).build()
}
