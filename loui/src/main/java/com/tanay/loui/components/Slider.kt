@file:Suppress("FunctionName")

package com.tanay.loui.components

import android.content.Context
import android.content.res.ColorStateList
import android.view.ViewGroup
import android.widget.RelativeLayout
import com.google.android.material.slider.Slider
import com.tanay.loui.Alignment
import com.tanay.loui.Dp

inline fun ConstraintLayoutScope.Slider(
    valueFrom: Float,
    valueTo: Float,
    stepSize: Float? = null,
    value: Float? = null,
    trackHeight: Dp? = null,
    trackColor: ColorStateList? = null,
    trackColorActive: ColorStateList? = null,
    trackColorInactive: ColorStateList? = null,
    thumbColor: ColorStateList? = null,
    thumbRadius: Dp? = null,
    thumbElevation: Dp? = null,
    constraintThis: ConstraintLayoutScopeView.() -> Unit,
    bind: (Slider) -> Unit = {},
    setAttributes: Slider.(Slider) -> Unit = {}
): Slider {
    return constraintLayout.context.Slider(valueFrom, valueTo, stepSize, value, trackHeight, trackColor, trackColorActive, trackColorInactive, thumbColor, thumbRadius, thumbElevation, bind, setAttributes).also {
        constraintLayout.addView(it)
        constraintThis(ConstraintLayoutScopeView(constraintLayout, it))
    }
}

inline fun BoxScope.Slider(
    valueFrom: Float,
    valueTo: Float,
    stepSize: Float? = null,
    value: Float? = null,
    trackHeight: Dp? = null,
    trackColor: ColorStateList? = null,
    trackColorActive: ColorStateList? = null,
    trackColorInactive: ColorStateList? = null,
    thumbColor: ColorStateList? = null,
    thumbRadius: Dp? = null,
    thumbElevation: Dp? = null,
    alignment: Alignment? = null,
    bind: (Slider) -> Unit = {},
    setAttributes: Slider.(Slider) -> Unit = {}
): Slider {
    return view.context.Slider(valueFrom, valueTo, stepSize, value, trackHeight, trackColor, trackColorActive, trackColorInactive, thumbColor, thumbRadius, thumbElevation, bind, setAttributes).also {
        view.addView(it)
        val params = RelativeLayout.LayoutParams(
            ViewGroup.LayoutParams.WRAP_CONTENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )
        it.layoutParams = params
        alignment?.run { align(params, this) }
    }
}


inline fun ColumnScope.Slider(
    valueFrom: Float,
    valueTo: Float,
    stepSize: Float? = null,
    value: Float? = null,
    trackHeight: Dp? = null,
    trackColor: ColorStateList? = null,
    trackColorActive: ColorStateList? = null,
    trackColorInactive: ColorStateList? = null,
    thumbColor: ColorStateList? = null,
    thumbRadius: Dp? = null,
    thumbElevation: Dp? = null,
    bind: (Slider) -> Unit = {},
    setAttributes: Slider.(Slider) -> Unit = {}
): Slider {
    return view.context.Slider(valueFrom, valueTo, stepSize, value, trackHeight, trackColor, trackColorActive, trackColorInactive, thumbColor, thumbRadius, thumbElevation, bind, setAttributes).also {
        view.addView(it)
    }
}

inline fun RowScope.Slider(
    valueFrom: Float,
    valueTo: Float,
    stepSize: Float? = null,
    value: Float? = null,
    trackHeight: Dp? = null,
    trackColor: ColorStateList? = null,
    trackColorActive: ColorStateList? = null,
    trackColorInactive: ColorStateList? = null,
    thumbColor: ColorStateList? = null,
    thumbRadius: Dp? = null,
    thumbElevation: Dp? = null,
    bind: (Slider) -> Unit = {},
    setAttributes: Slider.(Slider) -> Unit = {}
): Slider {
    return view.context.Slider(valueFrom, valueTo, stepSize, value, trackHeight, trackColor, trackColorActive, trackColorInactive, thumbColor, thumbRadius, thumbElevation, bind, setAttributes).also {
        view.addView(it)
    }
}

inline fun Context.Slider(
    valueFrom: Float,
    valueTo: Float,
    stepSize: Float? = null,
    value: Float? = null,
    trackHeight: Dp? = null,
    trackColor: ColorStateList? = null,
    trackColorActive: ColorStateList? = null,
    trackColorInactive: ColorStateList? = null,
    thumbColor: ColorStateList? = null,
    thumbRadius: Dp? = null,
    thumbElevation: Dp? = null,
    bind: (Slider) -> Unit = {},
    setAttributes: Slider.(Slider) -> Unit = {}
): Slider {
    return Slider(this).also {
        it.valueFrom = valueFrom
        it.valueTo = valueTo
        if (stepSize != null) {
            it.stepSize = stepSize
        }
        value?.let { v -> it.value = v }
        trackHeight?.let { th -> it.trackHeight = th.pixelsInInt }
        trackColor?.let { tc -> it.trackTintList = tc }
        trackColorActive?.let { tca -> it.trackActiveTintList = tca }
        trackColorInactive?.let { tca -> it.trackInactiveTintList = tca }
        thumbColor?.let { tc -> it.thumbTintList = tc }
        thumbElevation?.let { te -> it.thumbElevation = te.pixels }
        thumbRadius?.let { tr -> it.thumbRadius = tr.pixelsInInt }
        bind(it)
        setAttributes(it, it)
    }
}