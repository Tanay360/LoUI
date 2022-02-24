@file:Suppress("FunctionName")

package com.tanay.loui.components

import android.content.Context
import android.graphics.drawable.Drawable
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.RelativeLayout
import androidx.annotation.ColorInt
import com.tanay.loui.Alignment
import com.tanay.loui.Sp

fun ConstraintLayoutScope.CheckBox(
    text: CharSequence,
    textSize: Sp? = null,
    @ColorInt textColor: Int? = null,
    background: Drawable? = null,
    constraintThis: ConstraintLayoutScopeView.() -> Unit,
    bind: (CheckBox) -> Unit = {},
    setAttributes: CheckBox.(CheckBox) -> Unit = {}
): CheckBox {
    return constraintLayout.context.CheckBox(text, textSize, textColor, background, bind, setAttributes).also {
        constraintLayout.addView(it)
        constraintThis(ConstraintLayoutScopeView(constraintLayout, it))
    }
}

fun BoxScope.CheckBox(
    text: CharSequence,
    textSize: Sp? = null,
    @ColorInt textColor: Int? = null,
    background: Drawable? = null,
    alignment: Alignment? = null,
    bind: (CheckBox) -> Unit = {},
    setAttributes: CheckBox.(CheckBox) -> Unit = {}
): CheckBox {
    return view.context.CheckBox(text, textSize, textColor, background, bind, setAttributes).also {
        view.addView(it)
        val params = RelativeLayout.LayoutParams(
            ViewGroup.LayoutParams.WRAP_CONTENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )
        it.layoutParams = params
        alignment?.run { align(params, this) }
    }
}

fun ColumnScope.CheckBox(
    text: CharSequence,
    textSize: Sp? = null,
    @ColorInt textColor: Int? = null,
    background: Drawable? = null,
    bind: (CheckBox) -> Unit = {},
    setAttributes: CheckBox.(CheckBox) -> Unit = {}
): CheckBox {
    return view.context.CheckBox(text, textSize, textColor, background, bind, setAttributes).also {
        view.addView(it)
    }
}

fun RowScope.CheckBox(
    text: CharSequence,
    textSize: Sp? = null,
    @ColorInt textColor: Int? = null,
    background: Drawable? = null,
    bind: (CheckBox) -> Unit = {},
    setAttributes: CheckBox.(CheckBox) -> Unit = {}
): CheckBox {
    return view.context.CheckBox(text, textSize, textColor, background, bind, setAttributes).also {
        view.addView(it)
    }
}

fun Context.CheckBox(
    text: CharSequence,
    textSize: Sp? = null,
    @ColorInt textColor: Int? = null,
    background: Drawable? = null,
    bind: (CheckBox) -> Unit = {},
    setAttributes: CheckBox.(CheckBox) -> Unit = {}
): CheckBox {
    return CheckBox(this).also {
        it.text = text
        textSize?.let { ts -> it.textSize = ts.pixels }
        textColor?.let { tc -> it.setTextColor(tc) }
        it.background = background
        bind(it)
        setAttributes(it,it)
    }
}