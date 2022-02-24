@file:Suppress("FunctionName")

package com.tanay.loui.components

import android.content.Context
import android.graphics.Paint
import android.graphics.Typeface
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.annotation.FontRes
import androidx.core.content.res.ResourcesCompat
import com.google.android.material.button.MaterialButton
import com.tanay.loui.*

inline fun ConstraintLayoutScope.Button(
    text: CharSequence,
    constraintThis: ConstraintLayoutScopeView.() -> Unit,
    noinline onClick: ((View) -> Unit)? = null,
    noinline onLongClick: ((View) -> Unit)? = null,
    backgroundColor: Int? = null,
    borderRadius: Dp? = null,
    textSize: Sp? = null,
    color: Int? = null,
    @FontRes fontFamily: Int? = null,
    fontStyle: FontStyle? = null,
    underline: Boolean = false,
    textAllCaps: Boolean = true,
    bind: (MaterialButton) -> Unit = {},
    setAttributes: MaterialButton.(MaterialButton) -> Unit = {}
): MaterialButton {
    return constraintLayout.context.Button(text, onClick, onLongClick, backgroundColor, borderRadius, textSize, color, fontFamily, fontStyle, underline, textAllCaps, bind, setAttributes).also {
        constraintLayout.addView(it)
        constraintThis(ConstraintLayoutScopeView(constraintLayout, it))
    }
}

inline fun BoxScope.Button(
    text: CharSequence,
    noinline onClick: ((View) -> Unit)? = null,
    noinline onLongClick: ((View) -> Unit)? = null,
    backgroundColor: Int? = null,
    borderRadius: Dp? = null,
    textSize: Sp? = null,
    color: Int? = null,
    @FontRes fontFamily: Int? = null,
    fontStyle: FontStyle? = null,
    underline: Boolean = false,
    alignment: Alignment? = null,
    textAllCaps: Boolean = true,
    bind: (MaterialButton) -> Unit = {},
    setAttributes: MaterialButton.(MaterialButton) -> Unit = {}
): MaterialButton {
    return view.context.Button(text, onClick, onLongClick, backgroundColor, borderRadius, textSize, color, fontFamily, fontStyle, underline, textAllCaps, bind, setAttributes).also {
        view.addView(it)
        val params = RelativeLayout.LayoutParams(
            ViewGroup.LayoutParams.WRAP_CONTENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )
        it.layoutParams = params
        alignment?.run { align(params, this) }
    }
}

inline fun ColumnScope.Button(
    text: CharSequence,
    noinline onClick: ((View) -> Unit)? = null,
    noinline onLongClick: ((View) -> Unit)? = null,
    backgroundColor: Int? = null,
    borderRadius: Dp? = null,
    textSize: Sp? = null,
    color: Int? = null,
    @FontRes fontFamily: Int? = null,
    fontStyle: FontStyle? = null,
    underline: Boolean = false,
    textAllCaps: Boolean = true,
    bind: (MaterialButton) -> Unit = {},
    setAttributes: MaterialButton.(MaterialButton) -> Unit = {}
): MaterialButton {
    return view.context.Button(text, onClick, onLongClick, backgroundColor, borderRadius, textSize, color, fontFamily, fontStyle, underline, textAllCaps, bind, setAttributes).also {
        view.addView(it)
    }
}

inline fun RowScope.Button(
    text: CharSequence,
    noinline onClick: ((View) -> Unit)? = null,
    noinline onLongClick: ((View) -> Unit)? = null,
    backgroundColor: Int? = null,
    borderRadius: Dp? = null,
    textSize: Sp? = null,
    color: Int? = null,
    @FontRes fontFamily: Int? = null,
    fontStyle: FontStyle? = null,
    underline: Boolean = false,
    textAllCaps: Boolean = true,
    bind: (MaterialButton) -> Unit = {},
    setAttributes: MaterialButton.(MaterialButton) -> Unit = {}
): MaterialButton {
    return view.context.Button(text, onClick, onLongClick, backgroundColor, borderRadius, textSize, color, fontFamily, fontStyle, underline, textAllCaps, bind, setAttributes).also {
        view.addView(it)
    }
}

inline fun Context.Button(
    text: CharSequence,
    noinline onClick: ((View) -> Unit)? = null,
    noinline onLongClick: ((View) -> Unit)? = null,
    backgroundColor: Int? = null,
    borderRadius: Dp? = null,
    textSize: Sp? = null,
    color: Int? = null,
    @FontRes fontFamily: Int? = null,
    fontStyle: FontStyle? = null,
    underline: Boolean = false,
    textAllCaps: Boolean = true,
    bind: (MaterialButton) -> Unit = {},
    setAttributes: MaterialButton.(MaterialButton) -> Unit = {}
): MaterialButton {
    return MaterialButton(this).also {
        it.textContent = text
        textSize?.run { it.textSize = pixels }
        color?.run { it.setTextColor(this) }
        fontFamily?.run {
            val typeface = ResourcesCompat.getFont(this@Button, this)
            it.typeface = typeface
        }
        fontStyle?.run {
            when(this) {
                FontStyle.NORMAL -> {
                    it.setTypeface(it.typeface, Typeface.NORMAL)
                }
                FontStyle.BOLD -> {
                    it.setTypeface(it.typeface, Typeface.BOLD)
                }
                FontStyle.BOLD_ITALIC -> {
                    it.setTypeface(it.typeface, Typeface.BOLD_ITALIC)
                }
                FontStyle.ITALIC -> {
                    it.setTypeface(it.typeface, Typeface.ITALIC)
                }
            }
        }
        it.isAllCaps = textAllCaps
        if (underline) {
            it.paintFlags = it.paintFlags or Paint.UNDERLINE_TEXT_FLAG
        }
        backgroundColor?.run { it.setBackgroundColor(this) }
        onClick?.run { it.onClick(this) }
        onLongClick?.run { it.onLongClick(this) }
        borderRadius?.run { it.cornerRadius = pixelsInInt }
        bind(it)
        setAttributes(it,it)
    }
}