@file:Suppress("FunctionName")

package com.tanay.loui.components

import android.content.Context
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.RelativeLayout
import androidx.constraintlayout.widget.ConstraintSet
import androidx.core.widget.NestedScrollView
import com.tanay.loui.Alignment
import com.tanay.loui.Dp
import com.tanay.loui.Size
import com.tanay.loui.size

inline fun ConstraintLayoutScope.ScrollableColumn(
    constraintThis: ConstraintLayoutScopeView.() -> Unit,
    size: ConstraintLayoutScope.Size? = null,
    block: ColumnScope.() -> Unit
): NestedScrollView {
    return constraintLayout.context.ScrollableColumn(size?.size, block).also {
        constraintLayout.addView(it)
        constraintThis(ConstraintLayoutScopeView(constraintLayout, it))
    }
}

inline fun BoxScope.ScrollableColumn(
    alignment: Alignment? = null,
    size: Size? = null,
    block: ColumnScope.() -> Unit
): NestedScrollView {
    return view.context.ScrollableColumn(size, block).also {
        view.addView(it)
        val params = RelativeLayout.LayoutParams(
            ViewGroup.LayoutParams.WRAP_CONTENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )
        it.layoutParams = params
        alignment?.run { align(params, this) }
    }
}

inline fun ColumnScope.ScrollableColumn(
    size: Size? = null,
    block: ColumnScope.() -> Unit
): NestedScrollView {
    return view.context.ScrollableColumn(size, block).also {
        view.addView(it)
    }
}

inline fun RowScope.ScrollableColumn(
    size: Size? = null,
    block: ColumnScope.() -> Unit
): NestedScrollView {
    return view.context.ScrollableColumn(size, block).also {
        view.addView(it)
    }
}

inline fun Context.ScrollableColumn(
    size: Size? = null,
    block: ColumnScope.() -> Unit
): NestedScrollView {
    return NestedScrollView(this).also {
        val innerLayout = LinearLayout(this)
        innerLayout.size(Dp.FILL, Dp.FILL)
        innerLayout.orientation = LinearLayout.VERTICAL
        it.isFillViewport = true
        it.addView(innerLayout)
        val scope = ColumnScope(innerLayout)
        size?.let { s -> it.size(s.height, s.width) }
        block(scope)
    }
}