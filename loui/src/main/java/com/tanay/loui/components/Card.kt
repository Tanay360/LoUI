@file:Suppress("FunctionName")

package com.tanay.loui.components

import android.content.Context
import android.content.res.ColorStateList
import android.view.View
import android.view.ViewGroup
import android.widget.RelativeLayout
import androidx.annotation.ColorInt
import com.google.android.material.card.MaterialCardView
import com.tanay.loui.Alignment
import com.tanay.loui.Dp

fun ConstraintLayoutScope.Card(
    borderRadius: Dp? = null,
    strokeWidth: Dp? = null,
    strokeColor: Int? = null,
    cardElevation: Dp? = null,
    @ColorInt cardBackgroundColor: Int? = null,
    cardForegroundColor: ColorStateList? = null,
    rippleColor: ColorStateList? = null,
    checkable: Boolean = false,
    constraintThis: ConstraintLayoutScopeView.() -> Unit,
    content: Context.(MaterialCardView) -> View,
): MaterialCardView {
    return constraintLayout.context.Card(borderRadius, strokeWidth, strokeColor, cardElevation, cardBackgroundColor, cardForegroundColor, rippleColor, checkable, content).also {
        constraintLayout.addView(it)
        constraintThis(ConstraintLayoutScopeView(constraintLayout, it))
    }
}

fun BoxScope.Card(
    borderRadius: Dp? = null,
    strokeWidth: Dp? = null,
    strokeColor: Int? = null,
    cardElevation: Dp? = null,
    @ColorInt cardBackgroundColor: Int? = null,
    cardForegroundColor: ColorStateList? = null,
    rippleColor: ColorStateList? = null,
    checkable: Boolean = false,
    alignment: Alignment? = null,
    content: Context.(MaterialCardView) -> View,
): MaterialCardView {
    return view.context.Card(borderRadius, strokeWidth, strokeColor, cardElevation, cardBackgroundColor, cardForegroundColor, rippleColor, checkable, content).also {
        view.addView(it)
        val params = RelativeLayout.LayoutParams(
            ViewGroup.LayoutParams.WRAP_CONTENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )
        it.layoutParams = params
        alignment?.run { align(params, this) }
    }
}

fun ColumnScope.Card(
    borderRadius: Dp? = null,
    strokeWidth: Dp? = null,
    strokeColor: Int? = null,
    cardElevation: Dp? = null,
    @ColorInt cardBackgroundColor: Int? = null,
    cardForegroundColor: ColorStateList? = null,
    rippleColor: ColorStateList? = null,
    checkable: Boolean = false,
    content: Context.(MaterialCardView) -> View,
): MaterialCardView {
    return view.context.Card(borderRadius, strokeWidth, strokeColor, cardElevation, cardBackgroundColor, cardForegroundColor, rippleColor, checkable, content).also {
        view.addView(it)
    }
}

fun RowScope.Card(
    borderRadius: Dp? = null,
    strokeWidth: Dp? = null,
    strokeColor: Int? = null,
    cardElevation: Dp? = null,
    @ColorInt cardBackgroundColor: Int? = null,
    cardForegroundColor: ColorStateList? = null,
    rippleColor: ColorStateList? = null,
    checkable: Boolean = false,
    content: Context.(MaterialCardView) -> View,
): MaterialCardView {
    return view.context.Card(borderRadius, strokeWidth, strokeColor, cardElevation, cardBackgroundColor, cardForegroundColor, rippleColor, checkable, content).also {
        view.addView(it)
    }
}

fun Context.Card(
    borderRadius: Dp? = null,
    strokeWidth: Dp? = null,
    strokeColor: Int? = null,
    cardElevation: Dp? = null,
    @ColorInt cardBackgroundColor: Int? = null,
    cardForegroundColor: ColorStateList? = null,
    rippleColor: ColorStateList? = null,
    checkable: Boolean = false,
    content: Context.(MaterialCardView) -> View,
): MaterialCardView {
    return MaterialCardView(this).also {
        borderRadius?.pixels?.let { rad -> it.radius = rad }
        strokeWidth?.pixelsInInt?.let { stroke -> it.strokeWidth = stroke }
        strokeColor?.let { sc -> it.strokeColor = sc }
        cardElevation?.let { ce -> it.cardElevation = ce.pixels }
        cardBackgroundColor?.let { cbc -> it.setCardBackgroundColor(cbc) }
        cardForegroundColor?.let { cbc -> it.setCardForegroundColor(cbc) }
        rippleColor?.let { rc ->
            it.isClickable = true
            it.isFocusable = true
            it.rippleColor = rc
        }
        it.isCheckable = checkable
        it.addView(content(it))
    }
}