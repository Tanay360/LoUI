@file:Suppress("FunctionName")

package com.tanay.loui.components

import android.content.Context
import android.view.ViewGroup
import android.widget.RelativeLayout
import androidx.constraintlayout.widget.ConstraintSet
import androidx.fragment.app.Fragment
import com.tanay.loui.Alignment
import com.tanay.loui.Size
import com.tanay.loui.size

class BoxScope(
    val view: RelativeLayout
)

inline fun ConstraintLayoutScope.Box(
    size: ConstraintLayoutScope.Size? = null,
    constraintThis: ConstraintLayoutScopeView.() -> Unit,
    block: BoxScope.() -> Unit
): RelativeLayout {
    return constraintLayout.context.Box(size?.size,block).also {
        constraintLayout.addView(it)
        constraintThis(ConstraintLayoutScopeView(constraintLayout, it))
    }
}

inline fun RowScope.Box(
    size: Size? = null,
    block: BoxScope.() -> Unit
): RelativeLayout {
    return view.context.Box(size, block).also{
        view.addView(it)
    }
}

inline fun ColumnScope.Box(
    size: Size? = null,
    block: BoxScope.() -> Unit
): RelativeLayout {
    return view.context.Box(size, block).also {
        view.addView(it)
    }
}

inline fun BoxScope.Box(
    alignment: Alignment? = null,
    size: Size? = null,
    block: BoxScope.() -> Unit
): RelativeLayout {
    return view.context.Box(size, block).also {
        view.addView(it)
        val params = RelativeLayout.LayoutParams(
            ViewGroup.LayoutParams.WRAP_CONTENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )
        it.layoutParams = params
        alignment?.run { align(params, this) }
    }
}

inline fun Fragment.Box(
    size: Size? = null,
    block: BoxScope.() -> Unit
): RelativeLayout = requireContext().Box(size,block)

inline fun Context.Box(
    size: Size? = null,
    block: BoxScope.() -> Unit
): RelativeLayout {
    return RelativeLayout(this).also {
        size?.run {
            it.size(height, width)
        }
        block(BoxScope(it))
    }
}

fun BoxScope.align(params: RelativeLayout.LayoutParams, alignment: Alignment) {
    when (alignment) {
        Alignment.ALIGN_TOP -> params.addRule(RelativeLayout.ALIGN_PARENT_TOP, RelativeLayout.TRUE)
        Alignment.ALIGN_TOP_LEFT -> {
            params.addRule(RelativeLayout.ALIGN_PARENT_TOP, RelativeLayout.TRUE)
            params.addRule(RelativeLayout.ALIGN_PARENT_START, RelativeLayout.TRUE)
        }
        Alignment.ALIGN_TOP_RIGHT -> {
            params.addRule(RelativeLayout.ALIGN_PARENT_TOP, RelativeLayout.TRUE)
            params.addRule(RelativeLayout.ALIGN_PARENT_END, RelativeLayout.TRUE)
        }
        Alignment.ALIGN_TOP_CENTER ->  {
            params.addRule(RelativeLayout.ALIGN_PARENT_TOP, RelativeLayout.TRUE)
            params.addRule(RelativeLayout.CENTER_HORIZONTAL, RelativeLayout.TRUE)
        }
        Alignment.ALIGN_CENTER -> params.addRule(RelativeLayout.CENTER_IN_PARENT, RelativeLayout.TRUE)
        Alignment.ALIGN_CENTER_LEFT -> {
            params.addRule(RelativeLayout.CENTER_VERTICAL, RelativeLayout.TRUE)
            params.addRule(RelativeLayout.ALIGN_PARENT_START, RelativeLayout.TRUE)
        }
        Alignment.ALIGN_CENTER_RIGHT -> {
            params.addRule(RelativeLayout.CENTER_VERTICAL, RelativeLayout.TRUE)
            params.addRule(RelativeLayout.ALIGN_PARENT_END, RelativeLayout.TRUE)
        }
        Alignment.ALIGN_BOTTOM_LEFT -> {
            params.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM, RelativeLayout.TRUE)
            params.addRule(RelativeLayout.ALIGN_PARENT_START, RelativeLayout.TRUE)
        }
        Alignment.ALIGN_BOTTOM_RIGHT -> {
            params.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM, RelativeLayout.TRUE)
            params.addRule(RelativeLayout.ALIGN_PARENT_END, RelativeLayout.TRUE)
        }
        Alignment.ALIGN_BOTTOM_CENTER -> {
            params.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM, RelativeLayout.TRUE)
            params.addRule(RelativeLayout.CENTER_HORIZONTAL, RelativeLayout.TRUE)
        }
    }
}

