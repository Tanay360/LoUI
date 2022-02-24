@file:Suppress("FunctionName")

package com.tanay.loui.components

import android.content.Context
import android.content.res.ColorStateList
import android.graphics.drawable.Drawable
import android.view.View
import android.view.ViewGroup
import android.widget.RelativeLayout
import androidx.annotation.ColorInt
import com.google.android.material.chip.Chip
import com.google.android.material.chip.ChipGroup
import com.tanay.loui.Alignment
import com.tanay.loui.Icons
import com.tanay.loui.Sp
import com.tanay.loui.onClick

inline fun ChipGroupScope.Chip(
    text: CharSequence,
    @ColorInt textColor: Int? = null,
    textSize: Sp? = null,
    chipIcon: Drawable? = null,
    chipIconColor: ColorStateList? = null,
    checkedIcon: Drawable? = null,
    bind: (Chip) -> Unit = {},
    setAttributes: Chip.(Chip) -> Unit = {}
): Chip {
    return view.context.Chip(text, textColor, textSize, chipIcon, chipIconColor, checkedIcon, bind, setAttributes).also {
        view.addView(it)
    }
}


inline fun ConstraintLayoutScope.Chip(
    text: CharSequence,
    @ColorInt textColor: Int? = null,
    textSize: Sp? = null,
    chipIcon: Drawable? = null,
    chipIconColor: ColorStateList? = null,
    checkedIcon: Drawable? = null,
    constraintThis: ConstraintLayoutScopeView.() -> Unit,
    bind: (Chip) -> Unit = {},
    setAttributes: Chip.(Chip) -> Unit = {}
): Chip {
    return constraintLayout.context.Chip(text, textColor, textSize, chipIcon, chipIconColor, checkedIcon, bind, setAttributes).also {
        constraintLayout.addView(it)
        constraintThis(ConstraintLayoutScopeView(constraintLayout, it))
    }
}

inline fun BoxScope.Chip(
    text: CharSequence,
    @ColorInt textColor: Int? = null,
    textSize: Sp? = null,
    chipIcon: Drawable? = null,
    chipIconColor: ColorStateList? = null,
    checkedIcon: Drawable? = null,
    alignment: Alignment? = null,
    bind: (Chip) -> Unit = {},
    setAttributes: Chip.(Chip) -> Unit = {}
): Chip {
    return view.context.Chip(text, textColor, textSize, chipIcon, chipIconColor, checkedIcon, bind, setAttributes).also {
        view.addView(it)
        val params = RelativeLayout.LayoutParams(
            ViewGroup.LayoutParams.WRAP_CONTENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )
        it.layoutParams = params
        alignment?.run { align(params, this) }
    }
}

inline fun ColumnScope.Chip(
    text: CharSequence,
    @ColorInt textColor: Int? = null,
    textSize: Sp? = null,
    chipIcon: Drawable? = null,
    chipIconColor: ColorStateList? = null,
    checkedIcon: Drawable? = null,
    bind: (Chip) -> Unit = {},
    setAttributes: Chip.(Chip) -> Unit = {}
): Chip {
    return view.context.Chip(text, textColor, textSize, chipIcon, chipIconColor, checkedIcon, bind, setAttributes).also {
        view.addView(it)
    }
}

inline fun RowScope.Chip(
    text: CharSequence,
    @ColorInt textColor: Int? = null,
    textSize: Sp? = null,
    chipIcon: Drawable? = null,
    chipIconColor: ColorStateList? = null,
    checkedIcon: Drawable? = null,
    bind: (Chip) -> Unit = {},
    setAttributes: Chip.(Chip) -> Unit = {}
): Chip {
    return view.context.Chip(text, textColor, textSize, chipIcon, chipIconColor, checkedIcon, bind, setAttributes).also {
        view.addView(it)
    }
}

inline fun Context.Chip(
    text: CharSequence,
    @ColorInt textColor: Int? = null,
    textSize: Sp? = null,
    chipIcon: Drawable? = null,
    chipIconColor: ColorStateList? = null,
    checkedIcon: Drawable? = null,
    bind: (Chip) -> Unit = {},
    setAttributes: Chip.(Chip) -> Unit = {}
): Chip {
    return Chip(this).also {
        it.text = text
        it.isCheckable = true
        textColor?.let { tc -> it.setTextColor(tc) }
        textSize?.let { ts -> it.textSize = ts.pixels }
        chipIcon?.let { ci -> it.chipIcon = ci }
        chipIconColor?.let { cic -> it.checkedIconTint = cic }
        checkedIcon?.let { ci -> it.checkedIcon = ci }
        it.layoutDirection = View.LAYOUT_DIRECTION_LOCALE
        it.isCheckedIconVisible = true
        bind(it)
        setAttributes(it,it)
    }
}

inline fun ConstraintLayoutScope.ChipGroup(
    isSingleLine: Boolean = false,
    bind: (ChipGroup) -> Unit = {},
    constraintThis: ConstraintLayoutScopeView.() -> Unit,
    block: ChipGroupScope.() -> Unit
): ChipGroup {
    return constraintLayout.context.ChipGroup(isSingleLine, bind, block).also {
        constraintLayout.addView(it)
        constraintThis(ConstraintLayoutScopeView(constraintLayout, it))
    }
}


inline fun BoxScope.ChipGroup(
    isSingleLine: Boolean = false,
    bind: (ChipGroup) -> Unit = {},
    alignment: Alignment? = null,
    block: ChipGroupScope.() -> Unit
): ChipGroup {
    return view.context.ChipGroup(isSingleLine, bind, block).also {
        view.addView(it)
        val params = RelativeLayout.LayoutParams(
            ViewGroup.LayoutParams.WRAP_CONTENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )
        it.layoutParams = params
        alignment?.run { align(params, this) }
    }
}

inline fun ColumnScope.ChipGroup(
    isSingleLine: Boolean = false,
    bind: (ChipGroup) -> Unit = {},
    block: ChipGroupScope.() -> Unit
): ChipGroup {
    return view.context.ChipGroup(isSingleLine, bind, block).also {
        view.addView(it)
    }
}

inline fun RowScope.ChipGroup(
    isSingleLine: Boolean = false,
    bind: (ChipGroup) -> Unit = {},
    block: ChipGroupScope.() -> Unit
): ChipGroup {
    return view.context.ChipGroup(isSingleLine, bind, block).also {
        view.addView(it)
    }
}

/**
 * If you use [isSingleLine], then please note that you should wrap it within a [ScrollableRow] so that it is scrollable
 */

inline fun Context.ChipGroup(
    isSingleLine: Boolean = false,
    bind: (ChipGroup) -> Unit = {},
    block: ChipGroupScope.() -> Unit
): ChipGroup {
    return ChipGroup(this).also {
        it.isSingleLine = isSingleLine
        bind(it)
        block(ChipGroupScope(it))
    }
}

data class ChipGroupScope(
    val view: ChipGroup
)