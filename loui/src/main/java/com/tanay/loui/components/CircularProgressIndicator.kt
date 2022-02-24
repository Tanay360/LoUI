package com.tanay.loui.components

import android.content.Context
import android.content.res.ColorStateList
import android.view.ViewGroup
import android.widget.RelativeLayout
import androidx.annotation.ColorInt
import com.google.android.material.progressindicator.CircularProgressIndicator
import com.tanay.loui.Alignment
import com.tanay.loui.Dp
import com.tanay.loui.Size
import com.tanay.loui.size

inline fun ConstraintLayoutScope.CircularProgressIndicator(
    constraintThis: ConstraintLayoutScopeView.() -> Unit,
    indeterminate: Boolean = true,
    @ColorInt indicatorColor: Int? = null,
    @ColorInt trackColor: Int? = null,
    trackThickness: Dp? = null,
    indicatorSize: Dp? = null,
    indicatorInset: Dp? = null,
    bind: (CircularProgressIndicator) -> Unit = {},
    setAttributes: CircularProgressIndicator.(CircularProgressIndicator) -> Unit = {},
): CircularProgressIndicator {
    return constraintLayout.context.CircularProgressIndicator(indeterminate, indicatorColor, trackColor, trackThickness, indicatorSize, indicatorInset, bind, setAttributes).also {
        constraintLayout.addView(it)
        constraintThis(ConstraintLayoutScopeView(constraintLayout, it))
    }
}


inline fun BoxScope.CircularProgressIndicator(
    alignment: Alignment? = null,
    indeterminate: Boolean = true,
    @ColorInt indicatorColor: Int? = null,
    @ColorInt trackColor: Int? = null,
    trackThickness: Dp? = null,
    indicatorSize: Dp? = null,
    indicatorInset: Dp? = null,
    bind: (CircularProgressIndicator) -> Unit = {},
    setAttributes: CircularProgressIndicator.(CircularProgressIndicator) -> Unit = {},
): CircularProgressIndicator {
    return view.context.CircularProgressIndicator(indeterminate, indicatorColor, trackColor, trackThickness, indicatorSize, indicatorInset, bind, setAttributes).also {
        view.addView(it)
        val params = RelativeLayout.LayoutParams(
            ViewGroup.LayoutParams.WRAP_CONTENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )
        it.layoutParams = params
        alignment?.run { align(params, this) }
    }
}

inline fun ColumnScope.CircularProgressIndicator(
    indeterminate: Boolean = true,
    @ColorInt indicatorColor: Int? = null,
    @ColorInt trackColor: Int? = null,
    trackThickness: Dp? = null,
    indicatorSize: Dp? = null,
    indicatorInset: Dp? = null,
    bind: (CircularProgressIndicator) -> Unit = {},
    setAttributes: CircularProgressIndicator.(CircularProgressIndicator) -> Unit = {},
): CircularProgressIndicator {
    return view.context.CircularProgressIndicator(indeterminate, indicatorColor, trackColor, trackThickness, indicatorSize, indicatorInset, bind, setAttributes).also {
        view.addView(it)
    }
}

inline fun RowScope.CircularProgressIndicator(
    indeterminate: Boolean = true,
    @ColorInt indicatorColor: Int? = null,
    @ColorInt trackColor: Int? = null,
    trackThickness: Dp? = null,
    indicatorSize: Dp? = null,
    indicatorInset: Dp? = null,
    bind: (CircularProgressIndicator) -> Unit = {},
    setAttributes: CircularProgressIndicator.(CircularProgressIndicator) -> Unit = {}
): CircularProgressIndicator {
    return view.context.CircularProgressIndicator(indeterminate, indicatorColor, trackColor, trackThickness, indicatorSize, indicatorInset, bind, setAttributes).also {
        view.addView(it)
    }
}


inline fun Context.CircularProgressIndicator(
    indeterminate: Boolean = true,
    @ColorInt indicatorColor: Int? = null,
    @ColorInt trackColor: Int? = null,
    trackThickness: Dp? = null,
    indicatorSize: Dp? = null,
    indicatorInset: Dp? = null,
    bind: (CircularProgressIndicator) -> Unit = {},
    setAttributes: CircularProgressIndicator.(CircularProgressIndicator) -> Unit = {},
): CircularProgressIndicator {
    return CircularProgressIndicator(this).also { cpi ->
        cpi.isIndeterminate = indeterminate
        indicatorColor?.let { cpi.setIndicatorColor(it) }
        trackColor?.let { cpi.trackColor = it }
        indicatorSize?.let { cpi.indicatorSize = it.pixelsInInt }
        trackThickness?.let { cpi.trackThickness = it.pixelsInInt }
        indicatorInset?.let { cpi.indicatorInset = it.pixelsInInt }
        bind(cpi)
        setAttributes(cpi, cpi)
    }
}