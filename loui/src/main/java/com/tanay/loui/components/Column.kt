@file:Suppress("FunctionName")

package com.tanay.loui.components

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.RelativeLayout
import androidx.constraintlayout.widget.ConstraintSet
import androidx.fragment.app.Fragment
import com.tanay.loui.Alignment
import com.tanay.loui.Size
import com.tanay.loui.size

open class ColumnScope (
    open val view: LinearLayout
)

inline fun ConstraintLayoutScope.Column(
    size: ConstraintLayoutScope.Size? = null,
    constraintThis: ConstraintLayoutScopeView.() -> Unit,
    block: ColumnScope.() -> Unit
): LinearLayout {
    return constraintLayout.context.Column(size?.size,block).also {
        constraintLayout.addView(it)
        constraintThis(ConstraintLayoutScopeView(constraintLayout, it))
    }
}


inline fun BoxScope.Column(
    alignment: Alignment? = null,
    size: Size? = null,
    block: ColumnScope.() -> Unit
): LinearLayout {
    return view.context.Column(size, block).also {
        view.addView(it)
        val params = RelativeLayout.LayoutParams(
            ViewGroup.LayoutParams.WRAP_CONTENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )
        it.layoutParams = params
        alignment?.run { align(params, this) }
    }
}

inline fun RowScope.Column(
    size: Size? = null,
    block: ColumnScope.() -> Unit
): LinearLayout {
    return view.context.Column(size, block).also {
        view.addView(it)
    }
}

inline fun ColumnScope.Column(
    size: Size? = null,
    block: ColumnScope.() -> Unit
): LinearLayout {
    return view.context.Column(size,block).also {
        view.addView(it)
    }
}

inline fun Fragment.Column(
    size: Size? = null,
    block: ColumnScope.() -> Unit
): LinearLayout = requireContext().Column(size,block)

inline fun Context.Column(
    size: Size? = null,
    block: ColumnScope.() -> Unit
): LinearLayout {
    return LinearLayout(this).also {
        size?.run {
            it.size(height, width)
        }
        it.orientation = LinearLayout.VERTICAL
        block(ColumnScope(it))
    }
}