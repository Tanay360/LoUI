@file:Suppress("FunctionName")

package com.tanay.loui.components

import android.content.Context
import android.graphics.Paint
import android.graphics.Typeface
import android.view.View
import android.view.ViewGroup
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.annotation.FontRes
import androidx.core.content.res.ResourcesCompat
import com.tanay.loui.Alignment
import com.tanay.loui.Sp
import com.tanay.loui.components.ColumnScope
import com.tanay.loui.textContent

inline fun ConstraintLayoutScope.Text(
    text: CharSequence,
    id: Int? = null,
    textSize: Sp? = null,
    color: Int? = null,
    @FontRes fontFamily: Int? = null,
    fontStyle: FontStyle? = null,
    underline: Boolean = false,
    textIsSelectable: Boolean = false,
    bind: (TextView) -> Unit = {},
    constraintThis: ConstraintLayoutScopeView.() -> Unit,
    setAttributes: TextView.(TextView) -> Unit = {}
): TextView {
    return constraintLayout.context.Text(text, textSize, color, fontFamily, fontStyle, underline, textIsSelectable, bind, setAttributes).also {
        constraintLayout.addView(it)
        id?.let { i -> it.id = i }
        val scope = ConstraintLayoutScopeView(constraintLayout, it)
        constraintThis(scope)
    }
}


inline fun ColumnScope.Text(
    text: CharSequence,
    textSize: Sp? = null,
    color: Int? = null,
    @FontRes fontFamily: Int? = null,
    fontStyle: FontStyle? = null,
    underline: Boolean = false,
    textIsSelectable: Boolean = false,
    bind: (TextView) -> Unit = {},
    setAttributes: TextView.(TextView) -> Unit = {}
): TextView {
    return view.context.Text(text, textSize, color, fontFamily, fontStyle, underline, textIsSelectable, bind, setAttributes).also {
        view.addView(it)
    }
}


inline fun RowScope.Text(
    text: CharSequence,
    textSize: Sp? = null,
    color: Int? = null,
    @FontRes fontFamily: Int? = null,
    fontStyle: FontStyle? = null,
    underline: Boolean = false,
    textIsSelectable: Boolean = false,
    bind: (TextView) -> Unit = {},
    setAttributes: TextView.(TextView) -> Unit = {}
): TextView {
    return view.context.Text(text, textSize, color, fontFamily, fontStyle, underline, textIsSelectable, bind, setAttributes).also {
        view.addView(it)
    }
}

inline fun BoxScope.Text(
    text: CharSequence,
    textSize: Sp? = null,
    color: Int? = null,
    @FontRes fontFamily: Int? = null,
    fontStyle: FontStyle? = null,
    underline: Boolean = false,
    textIsSelectable: Boolean = false,
    alignment: Alignment? = null,
    bind: (TextView) -> Unit = {},
    setAttributes: TextView.(TextView) -> Unit = {}
): TextView {
    return view.context.Text(text,textSize,color, fontFamily, fontStyle, underline, textIsSelectable, bind, setAttributes).also {
        view.addView(it)
        val params = RelativeLayout.LayoutParams(
            ViewGroup.LayoutParams.WRAP_CONTENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )
        it.layoutParams = params
        alignment?.run { align(params, this) }
    }
}

inline fun Context.Text(
    text: CharSequence,
    textSize: Sp? = null,
    color: Int? = null,
    @FontRes fontFamily: Int? = null,
    fontStyle: FontStyle? = null,
    underline: Boolean = false,
    textIsSelectable: Boolean = false,
    bind: (TextView) -> Unit = {},
    setAttributes: TextView.(TextView) -> Unit = {}
): TextView {
    return TextView(this).also {
        it.setTextIsSelectable(textIsSelectable)
        it.textContent = text
        textSize?.run { it.textSize = pixels }
        fontFamily?.run {
            val typeface = ResourcesCompat.getFont(this@Text, this)
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
        if (underline) {
            it.paintFlags = it.paintFlags or Paint.UNDERLINE_TEXT_FLAG
        }
        color?.run { it.setTextColor(this) }
        bind(it)
        setAttributes(it,it)
    }
}

enum class FontStyle {
    NORMAL,
    BOLD,
    BOLD_ITALIC,
    ITALIC
}