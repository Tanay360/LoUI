@file:Suppress("FunctionName")

package com.tanay.loui.components

import android.content.Context
import android.graphics.drawable.Drawable
import android.view.ContextThemeWrapper
import android.view.View
import android.view.ViewGroup
import android.widget.RelativeLayout
import androidx.annotation.ColorInt
import androidx.constraintlayout.widget.ConstraintSet
import com.google.android.material.shape.CornerFamily
import com.tanay.loui.*
import com.tanay.loui.views.IconButton

inline fun ConstraintLayoutScope.IconButton(
    constraintThis: ConstraintLayoutScopeView.() -> Unit,
    icon: Drawable,
    contentDescription: CharSequence,
    borderRadius: Dp? = null,
    @ColorInt backgroundColor: Int? = null,
    size: ConstraintLayoutScope.Size? = null,
    noinline onClick: ((View) -> Unit)? = null,
    noinline onLongClick: ((View) -> Unit)? = null,
    isRounded: Boolean = false,
    bind: (IconButton) -> Unit = {},
    setAttributes: IconButton.(IconButton) -> Unit = {}
): IconButton {
    return constraintLayout.context.IconButton(icon, contentDescription, borderRadius, backgroundColor, size?.size, onClick, onLongClick, isRounded, bind, setAttributes).also{
        constraintLayout.addView(it)
        constraintThis(ConstraintLayoutScopeView(constraintLayout, it))
    }
}

inline fun BoxScope.IconButton(
    icon: Drawable,
    contentDescription: CharSequence,
    alignment: Alignment? = null,
    borderRadius: Dp? = null,
    @ColorInt backgroundColor: Int? = null,
    size: Size? = null,
    noinline onClick: ((View) -> Unit)? = null,
    noinline onLongClick: ((View) -> Unit)? = null,
    isRounded: Boolean = false,
    bind: (IconButton) -> Unit = {},
    setAttributes: IconButton.(IconButton) -> Unit = {}
): IconButton {
    return view.context.IconButton(icon, contentDescription, borderRadius, backgroundColor, size, onClick, onLongClick, isRounded, bind, setAttributes).also{
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

inline fun ColumnScope.IconButton(
    icon: Drawable,
    contentDescription: CharSequence,
    borderRadius: Dp? = null,
    @ColorInt backgroundColor: Int? = null,
    size: Size? = null,
    noinline onClick: ((View) -> Unit)? = null,
    noinline onLongClick: ((View) -> Unit)? = null,
    isRounded: Boolean = false,
    bind: (IconButton) -> Unit = {},
    setAttributes: IconButton.(IconButton) -> Unit = {}
): IconButton {
    return view.context.IconButton(icon, contentDescription, borderRadius, backgroundColor, size, onClick, onLongClick, isRounded, bind, setAttributes).also{
        view.addView(it)
    }
}

inline fun RowScope.IconButton(
    icon: Drawable,
    contentDescription: CharSequence,
    borderRadius: Dp? = null,
    @ColorInt backgroundColor: Int? = null,
    size: Size? = null,
    noinline onClick: ((View) -> Unit)? = null,
    noinline onLongClick: ((View) -> Unit)? = null,
    isRounded: Boolean = false,
    bind: (IconButton) -> Unit = {},
    setAttributes: IconButton.(IconButton) -> Unit = {}
): IconButton {
    return view.context.IconButton(icon, contentDescription, borderRadius, backgroundColor, size, onClick, onLongClick, isRounded, bind, setAttributes).also{
        view.addView(it)
    }
}

inline fun Context.IconButton(
    icon: Drawable,
    contentDescription: CharSequence,
    borderRadius: Dp? = null,
    @ColorInt backgroundColor: Int? = null,
    size: Size? = null,
    noinline onClick: ((View) -> Unit)? = null,
    noinline onLongClick: ((View) -> Unit)? = null,
    isRounded: Boolean = false,
    bind: (IconButton) -> Unit = {},
    setAttributes: IconButton.(IconButton) -> Unit = {}
): IconButton {
    val button = if (isRounded) {
        IconButton(ContextThemeWrapper(this, R.style.CircularShape))
    } else {
        IconButton(this).also {
            borderRadius?.let { rad ->
                it.shapeAppearanceModel = it.shapeAppearanceModel
                    .toBuilder()
                    .setAllCorners(CornerFamily.ROUNDED,rad.pixels)
                    .build()
            }
        }
    }
    return button.also {
        it.setImageDrawable(icon)
        it.contentDescription = contentDescription
        size?.let { s -> it.size(s.height, s.width) }
        backgroundColor?.let { bg -> it.bgColor = bg }
        onClick?.let { onc -> it.onClick(onc) }
        onLongClick?.let { olc -> it.onLongClick(olc) }
        bind(it)
        setAttributes(it,it)
    }
}