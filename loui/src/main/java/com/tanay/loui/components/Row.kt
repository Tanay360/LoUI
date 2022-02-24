@file:Suppress("FunctionName")
package com.tanay.loui.components

import android.content.Context
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.RelativeLayout
import androidx.constraintlayout.widget.ConstraintSet
import androidx.fragment.app.Fragment
import com.tanay.loui.Alignment
import com.tanay.loui.Size
import com.tanay.loui.size

open class RowScope (
    open val view: LinearLayout
)

inline fun ConstraintLayoutScope.Row(
    size: ConstraintLayoutScope.Size? = null,
    constraintThis: ConstraintLayoutScopeView.() -> Unit,
    block: RowScope.() -> Unit
): LinearLayout {
    return constraintLayout.context.Row(size?.size,block).also {
        constraintLayout.addView(it)
        constraintThis(ConstraintLayoutScopeView(constraintLayout, it))
    }
}

inline fun BoxScope.Row(
    alignment: Alignment? = null,
    size: Size? = null,
    block: RowScope.() -> Unit
): LinearLayout {
    return view.context.Row(size, block).also {
        view.addView(it)
        val params = RelativeLayout.LayoutParams(
            ViewGroup.LayoutParams.WRAP_CONTENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )
        it.layoutParams = params
        alignment?.run { align(params, this) }
    }
}

inline fun RowScope.Row(
    size: Size? = null,
    block: RowScope.() -> Unit
): LinearLayout {
    return view.context.Row(size, block).also {
        view.addView(it)
    }
}

inline fun ColumnScope.Row(
    size: Size? = null,
    block: RowScope.() -> Unit
): LinearLayout {
    return view.context.Row(size,block).also {
        view.addView(it)
    }
}

inline fun Fragment.Row(
    size: Size? = null,
    block: RowScope.() -> Unit
): LinearLayout = requireContext().Row(size,block)

inline fun Context.Row(
    size: Size? = null,
    block: RowScope.() -> Unit
): LinearLayout {
    return LinearLayout(this).also {
        size?.run {
            it.size(height, width)
        }
        block(RowScope(it))
    }
}