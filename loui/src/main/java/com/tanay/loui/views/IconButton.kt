package com.tanay.loui.views

import android.animation.ValueAnimator
import android.content.Context
import android.content.res.TypedArray
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Rect
import android.graphics.drawable.GradientDrawable
import android.util.AttributeSet
import android.util.TypedValue
import android.view.MotionEvent
import android.view.View
import android.view.View.OnTouchListener
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import com.google.android.material.imageview.ShapeableImageView
import com.tanay.loui.Dp
import com.tanay.loui.R
import com.tanay.loui.dp
import kotlin.math.roundToInt

class IconButton @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null
) : ShapeableImageView(context, attrs) {

    private fun fetchAccentColor(): Int {
        val typedValue = TypedValue()
        val a: TypedArray =
            context.obtainStyledAttributes(typedValue.data, intArrayOf(android.R.attr.colorAccent))
        val color = a.getColor(0, 0)
        a.recycle()
        return color
    }


    private var _backgroundColor: Int = fetchAccentColor()
    var bgColor: Int
        get() = _backgroundColor
        set(value) {
            _backgroundColor = value
            background = getBackgroundShape(_backgroundColor)
            setOnTouchListener()
        }

    init {
        isClickable = true
        isFocusable = true
        background = getBackgroundShape(_backgroundColor)
        setOnTouchListener()
    }

    private fun manipulateColor(color: Int): Int {
        val a: Int = Color.alpha(color)
        val r = (Color.red(color) * 0.7f).roundToInt()
        val g = (Color.green(color) * 0.7f).roundToInt()
        val b = (Color.blue(color) * 0.7f).roundToInt()
        return Color.argb(
            a,
            r.coerceAtMost(255),
            g.coerceAtMost(255),
            b.coerceAtMost(255)
        )
    }

    private fun getBackgroundShape(color: Int): GradientDrawable {
        val gradientDrawable = GradientDrawable()
        gradientDrawable.shape = GradientDrawable.RECTANGLE
        gradientDrawable.setColor(color)
        return gradientDrawable
    }


    private fun getDefaultBackgroundAnimator(): ValueAnimator? {
        val from = FloatArray(3)
        val to = FloatArray(3)
        Color.colorToHSV(_backgroundColor, from)
        Color.colorToHSV(manipulateColor(_backgroundColor), to)
        val anim = ValueAnimator.ofFloat(0f, 1f)
        anim.duration = 200
        val hsv = FloatArray(3)
        anim.addUpdateListener { animation -> // Transition along each axis of HSV (hue, saturation, value)
            hsv[0] = from[0] + (to[0] - from[0]) * animation.animatedFraction
            hsv[1] = from[1] + (to[1] - from[1]) * animation.animatedFraction
            hsv[2] = from[2] + (to[2] - from[2]) * animation.animatedFraction
            val gradientDrawable = getBackgroundShape(_backgroundColor)
            gradientDrawable.setColor(Color.HSVToColor(hsv))
            background = gradientDrawable
        }
        return anim
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
    }

    override fun performClick(): Boolean {
        super.performClick()
        return true
    }

    fun setOnTouchListener() {
        this.setOnTouchListener(OnTouchListener { v, event ->
            val defaultAnimator = getDefaultBackgroundAnimator()
            when (event.action) {
                MotionEvent.ACTION_DOWN -> {
                    val onClickEffectPress: Animation =
                        AnimationUtils.loadAnimation(context, R.anim.view_press)
                    defaultAnimator!!.start()
                    v.startAnimation(onClickEffectPress)
                    return@OnTouchListener true
                }
                MotionEvent.ACTION_UP -> {
                    val onClickEffectRelease: Animation =
                        AnimationUtils.loadAnimation(context, R.anim.view_release)
                    defaultAnimator!!.reverse()
                    v.startAnimation(onClickEffectRelease)
                    if (isMotionEventInsideView(v, event)) {
                        performClick()
                    }
                    return@OnTouchListener true
                }
            }
            false
        })
    }

    private fun isMotionEventInsideView(view: View, event: MotionEvent): Boolean {
        val viewRect = Rect(
            view.left,
            view.top,
            view.right,
            view.bottom
        )
        return viewRect.contains(
            view.left + event.x.toInt(),
            view.top + event.y.toInt()
        )
    }
}