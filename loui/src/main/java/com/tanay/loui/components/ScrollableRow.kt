@file:Suppress("FunctionName")

package com.tanay.loui.components

import android.content.Context
import android.view.ViewGroup
import android.widget.HorizontalScrollView
import android.widget.LinearLayout
import android.widget.RelativeLayout
import androidx.constraintlayout.widget.ConstraintSet
import androidx.core.widget.NestedScrollView
import com.tanay.loui.Alignment
import com.tanay.loui.Dp
import com.tanay.loui.Size
import com.tanay.loui.size

fun ConstraintLayoutScope.ScrollableRow(
    constraintThis: ConstraintLayoutScopeView.() -> Unit,
    size: ConstraintLayoutScope.Size? = null,
    block: RowScope.() -> Unit
): HorizontalScrollView {
    return constraintLayout.context.ScrollableRow(size?.size, block).also {
        constraintLayout.addView(it)
        constraintThis(ConstraintLayoutScopeView(constraintLayout, it))
    }
}

fun BoxScope.ScrollableRow(
    alignment: Alignment? = null,
    size: Size? = null,
    block: RowScope.() -> Unit
): HorizontalScrollView {
    return view.context.ScrollableRow(size, block).also {
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

fun ColumnScope.ScrollableRow(
    size: Size? = null,
    block: RowScope.() -> Unit
): HorizontalScrollView {
    return view.context.ScrollableRow(size, block).also {
        view.addView(it)
    }
}

fun RowScope.ScrollableRow(
    size: Size? = null,
    block: RowScope.() -> Unit
): HorizontalScrollView {
    return view.context.ScrollableRow(size, block).also {
        view.addView(it)
    }
}

fun Context.ScrollableRow(
    size: Size? = null,
    block: RowScope.() -> Unit
): HorizontalScrollView {
    return HorizontalScrollView(this).also {
        val innerLayout = LinearLayout(this)
        innerLayout.size(Dp.FILL, Dp.FILL)
        innerLayout.orientation = LinearLayout.HORIZONTAL
        it.isFillViewport = true
        it.addView(innerLayout)
        val scope = RowScope(innerLayout)
        size?.let { s -> it.size(s.height, s.width) }
        block(scope)
    }
}