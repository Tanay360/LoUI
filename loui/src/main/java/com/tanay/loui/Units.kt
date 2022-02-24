package com.tanay.loui

import android.content.Context
import android.content.res.Resources
import android.util.TypedValue
import android.view.View
import android.widget.LinearLayout
import android.widget.RelativeLayout
import android.widget.TableRow
import android.widget.Toast
import androidx.core.view.marginBottom
import androidx.core.view.marginLeft
import androidx.core.view.marginRight
import androidx.core.view.marginTop
import kotlin.math.roundToInt

data class Dp(val value: Float) {
    val pixels get() = dpToPx(value)
    val pixelsInInt get() = pixels.toInt()

    companion object {
        val ZERO = 0.dp
        val FILL = Dp(-1f)
        val WRAP = Dp(-2f)
    }
}

data class Sp(val value: Float) {
    val pixels get() = spToPx(value)
    val pixelsInInt get() = pixels.toInt()
}

fun Int.asDp() = pxToDp(this)

val Int.dp: Dp get() = Dp(toFloat())
val Float.dp: Dp get() = Dp(this)
val Int.sp: Sp get() = Sp(toFloat())
val Float.sp: Sp get() = Sp(toFloat())

private val displayMetrics get() = Resources.getSystem().displayMetrics

private fun dpToPx(dp: Float): Float {
    return TypedValue.applyDimension(
        TypedValue.COMPLEX_UNIT_DIP,
        dp,
        displayMetrics
    )
}

private fun pxToDp(px: Int): Dp {
    return (px / displayMetrics.density).toInt().dp
}

private fun spToPx(sp: Float): Float {
    return TypedValue.applyDimension(
        TypedValue.COMPLEX_UNIT_SP,
        sp,
        displayMetrics
    )
}