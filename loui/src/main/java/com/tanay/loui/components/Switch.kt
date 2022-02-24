@file:Suppress("FunctionName")

package com.tanay.loui.components

import android.content.Context
import android.content.res.ColorStateList
import android.view.ViewGroup
import android.widget.RelativeLayout
import androidx.annotation.ColorInt
import com.google.android.material.switchmaterial.SwitchMaterial
import com.tanay.loui.Alignment
import com.tanay.loui.Sp

inline fun ConstraintLayoutScope.Switch(
    text: CharSequence,
    @ColorInt textColor: Int? = null,
    textSize: Sp? = null,
    thumbColor: ColorStateList? = null,
    trackColor: ColorStateList? = null,
    constraintThis: ConstraintLayoutScopeView.() -> Unit,
    bind: (SwitchMaterial) -> Unit = {},
    setAttributes: SwitchMaterial.(SwitchMaterial) -> Unit = {}
): SwitchMaterial {
    return constraintLayout.context.Switch(text, textColor, textSize, thumbColor, trackColor, bind, setAttributes).also {
        constraintLayout.addView(it)
        constraintThis(ConstraintLayoutScopeView(constraintLayout, it))
    }
}

inline fun BoxScope.Switch(
    text: CharSequence,
    @ColorInt textColor: Int? = null,
    textSize: Sp? = null,
    thumbColor: ColorStateList? = null,
    trackColor: ColorStateList? = null,
    alignment: Alignment? = null,
    bind: (SwitchMaterial) -> Unit = {},
    setAttributes: SwitchMaterial.(SwitchMaterial) -> Unit = {}
): SwitchMaterial {
    return view.context.Switch(text, textColor, textSize, thumbColor, trackColor, bind, setAttributes).also {
        view.addView(it)
        val params = RelativeLayout.LayoutParams(
            ViewGroup.LayoutParams.WRAP_CONTENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )
        it.layoutParams = params
        alignment?.run { align(params, this) }
    }
}

inline fun ColumnScope.Switch(
    text: CharSequence,
    @ColorInt textColor: Int? = null,
    textSize: Sp? = null,
    thumbColor: ColorStateList? = null,
    trackColor: ColorStateList? = null,
    bind: (SwitchMaterial) -> Unit = {},
    setAttributes: SwitchMaterial.(SwitchMaterial) -> Unit = {}
): SwitchMaterial {
    return view.context.Switch(text, textColor, textSize, thumbColor, trackColor, bind, setAttributes).also {
        view.addView(it)
    }
}

inline fun RowScope.Switch(
    text: CharSequence,
    @ColorInt textColor: Int? = null,
    textSize: Sp? = null,
    thumbColor: ColorStateList? = null,
    trackColor: ColorStateList? = null,
    bind: (SwitchMaterial) -> Unit = {},
    setAttributes: SwitchMaterial.(SwitchMaterial) -> Unit = {}
): SwitchMaterial {
    return view.context.Switch(text, textColor, textSize, thumbColor, trackColor, bind, setAttributes).also {
        view.addView(it)
    }
}

inline fun Context.Switch(
    text: CharSequence,
    @ColorInt textColor: Int? = null,
    textSize: Sp? = null,
    thumbColor: ColorStateList? = null,
    trackColor: ColorStateList? = null,
    bind: (SwitchMaterial) -> Unit = {},
    setAttributes: SwitchMaterial.(SwitchMaterial) -> Unit = {}
): SwitchMaterial {
    return SwitchMaterial(this).also {
        it.text = text
        textColor?.let { tc -> it.setTextColor(tc) }
        textSize?.let { ts -> it.textSize = ts.pixels }
        thumbColor?.let { tc -> it.thumbTintList = tc }
        trackColor?.let { tc -> it.trackTintList = tc }
        bind(it)
        setAttributes(it,it)
    }
}