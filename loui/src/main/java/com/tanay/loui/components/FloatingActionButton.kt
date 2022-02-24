@file:Suppress("FunctionName")

package com.tanay.loui.components

import android.content.Context
import android.graphics.drawable.Drawable
import android.view.View
import android.view.ViewGroup
import android.widget.RelativeLayout
import androidx.annotation.ColorInt
import androidx.annotation.DrawableRes
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.tanay.loui.Alignment
import com.tanay.loui.Size
import com.tanay.loui.onClick
import com.tanay.loui.size

inline fun ConstraintLayoutScope.FloatingActionButton(
    icon: Drawable?,
    size: Size? = null,
    @ColorInt backgroundColor: Int? = null,
    noinline onClick: ((View) -> Unit)? = null,
    constraintThis: ConstraintLayoutScopeView.() -> Unit,
    bind: (FloatingActionButton) -> Unit = {},
    setAttributes: FloatingActionButton.(FloatingActionButton) -> Unit = {}
): FloatingActionButton {
    return constraintLayout.context.FloatingActionButton(icon, size, backgroundColor, onClick, bind, setAttributes).also {
        constraintLayout.addView(it)
        constraintThis(ConstraintLayoutScopeView(constraintLayout, it))
    }
}

inline fun BoxScope.FloatingActionButton(
    icon: Drawable?,
    size: Size? = null,
    alignment: Alignment? = null,
    @ColorInt backgroundColor: Int? = null,
    noinline onClick: ((View) -> Unit)? = null,
    bind: (FloatingActionButton) -> Unit = {},
    setAttributes: FloatingActionButton.(FloatingActionButton) -> Unit = {}
): FloatingActionButton {
    return view.context.FloatingActionButton(icon, size, backgroundColor, onClick, bind, setAttributes).also {
        view.addView(it)
        val params = RelativeLayout.LayoutParams(
            ViewGroup.LayoutParams.WRAP_CONTENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )
        it.layoutParams = params
        alignment?.run { align(params, this) }
        size?.let { s -> it.size(s.height, s.width)}
    }
}

inline fun ColumnScope.FloatingActionButton(
    icon: Drawable?,
    size: Size? = null,
    @ColorInt backgroundColor: Int? = null,
    noinline onClick: ((View) -> Unit)? = null,
    bind: (FloatingActionButton) -> Unit = {},
    setAttributes: FloatingActionButton.(FloatingActionButton) -> Unit = {}
): FloatingActionButton {
    return view.context.FloatingActionButton(icon, size, backgroundColor, onClick, bind, setAttributes).also {
        view.addView(it)
    }
}

inline fun RowScope.FloatingActionButton(
    icon: Drawable?,
    size: Size? = null,
    @ColorInt backgroundColor: Int? = null,
    noinline onClick: ((View) -> Unit)? = null,
    bind: (FloatingActionButton) -> Unit = {},
    setAttributes: FloatingActionButton.(FloatingActionButton) -> Unit = {}
): FloatingActionButton {
    return view.context.FloatingActionButton(icon, size, backgroundColor, onClick, bind, setAttributes).also {
        view.addView(it)
    }
}

inline fun Context.FloatingActionButton(
    icon: Drawable?,
    size: Size? = null,
    @ColorInt backgroundColor: Int? = null,
    noinline onClick: ((View) -> Unit)? = null,
    bind: (FloatingActionButton) -> Unit = {},
    setAttributes: FloatingActionButton.(FloatingActionButton) -> Unit = {}
): FloatingActionButton {
    return FloatingActionButton(this).also {
        size?.let { s -> it.size(s.height, s.width) }
        it.setImageDrawable(icon)
        backgroundColor?.let { bc -> it.setBackgroundColor(bc) }
        onClick?.let { oc -> it.onClick(oc) }
        bind(it)
        setAttributes(it,it)
    }
}