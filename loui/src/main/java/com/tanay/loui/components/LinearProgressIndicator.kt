package com.tanay.loui.components

import android.content.Context
import android.view.ViewGroup
import android.widget.RelativeLayout
import androidx.annotation.ColorInt
import androidx.constraintlayout.widget.ConstraintSet
import com.google.android.material.progressindicator.LinearProgressIndicator
import com.tanay.loui.Alignment
import com.tanay.loui.Dp
import com.tanay.loui.Size
import com.tanay.loui.size

inline fun ConstraintLayoutScope.LinearProgressIndicator(
    constraintThis: ConstraintLayoutScopeView.() -> Unit,
    indeterminate: Boolean = true,
    @ColorInt indicatorColor: Int? = null,
    @ColorInt trackColor: Int? = null,
    trackThickness: Dp? = null,
    size: ConstraintLayoutScope.Size? = null,
    bind: (LinearProgressIndicator) -> Unit = {},
    setAttributes: LinearProgressIndicator.(LinearProgressIndicator) -> Unit = {},
): LinearProgressIndicator {
    return constraintLayout.context.LinearProgressIndicator(
        indeterminate,
        indicatorColor,
        trackColor,
        trackThickness,
        size?.size,
        bind,
        setAttributes
    ).also {
        constraintLayout.addView(it)
        constraintThis(ConstraintLayoutScopeView(constraintLayout, it))
    }
}

inline fun BoxScope.LinearProgressIndicator(
    alignment: Alignment? = null,
    indeterminate: Boolean = true,
    @ColorInt indicatorColor: Int? = null,
    @ColorInt trackColor: Int? = null,
    trackThickness: Dp? = null,
    size: Size? = null,
    bind: (LinearProgressIndicator) -> Unit = {},
    setAttributes: LinearProgressIndicator.(LinearProgressIndicator) -> Unit = {},
): LinearProgressIndicator {
    return view.context.LinearProgressIndicator(
        indeterminate,
        indicatorColor,
        trackColor,
        trackThickness,
        size,
        bind,
        setAttributes
    ).also {
        view.addView(it)
        val params = RelativeLayout.LayoutParams(
            ViewGroup.LayoutParams.WRAP_CONTENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )
        size?.let { s -> it.size(s.height, s.width) }
        it.layoutParams = params
        alignment?.run { align(params, this) }
    }
}

inline fun ColumnScope.LinearProgressIndicator(
    indeterminate: Boolean = true,
    @ColorInt indicatorColor: Int? = null,
    @ColorInt trackColor: Int? = null,
    trackThickness: Dp? = null,
    size: Size? = null,
    bind: (LinearProgressIndicator) -> Unit = {},
    setAttributes: LinearProgressIndicator.(LinearProgressIndicator) -> Unit = {},
): LinearProgressIndicator {
    return view.context.LinearProgressIndicator(
        indeterminate,
        indicatorColor,
        trackColor,
        trackThickness,
        size,
        bind,
        setAttributes
    ).also {
        view.addView(it)
    }
}

inline fun RowScope.LinearProgressIndicator(
    indeterminate: Boolean = true,
    @ColorInt indicatorColor: Int? = null,
    @ColorInt trackColor: Int? = null,
    trackThickness: Dp? = null,
    size: Size? = null,
    bind: (LinearProgressIndicator) -> Unit = {},
    setAttributes: LinearProgressIndicator.(LinearProgressIndicator) -> Unit = {}
): LinearProgressIndicator {
    return view.context.LinearProgressIndicator(
        indeterminate,
        indicatorColor,
        trackColor,
        trackThickness,
        size,
        bind,
        setAttributes
    ).also {
        view.addView(it)
    }
}


inline fun Context.LinearProgressIndicator(
    indeterminate: Boolean = true,
    @ColorInt indicatorColor: Int? = null,
    @ColorInt trackColor: Int? = null,
    trackThickness: Dp? = null,
    size: Size? = null,
    bind: (LinearProgressIndicator) -> Unit = {},
    setAttributes: LinearProgressIndicator.(LinearProgressIndicator) -> Unit = {},
): LinearProgressIndicator {
    return LinearProgressIndicator(this).also { cpi ->
        cpi.isIndeterminate = indeterminate
        indicatorColor?.let { cpi.setIndicatorColor(it) }
        trackColor?.let { cpi.trackColor = it }
        size?.let { cpi.size(it.height, it.width) }
        trackThickness?.let { cpi.trackThickness = it.pixelsInInt }
        bind(cpi)
        setAttributes(cpi, cpi)
    }
}