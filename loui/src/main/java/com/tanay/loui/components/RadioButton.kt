@file:Suppress("FunctionName")

package com.tanay.loui.components

import android.content.Context
import android.view.ViewGroup
import android.widget.RadioGroup
import android.widget.RelativeLayout
import com.google.android.material.radiobutton.MaterialRadioButton
import com.tanay.loui.Alignment

inline fun RadioGroupScope.RadioButton(
    text: CharSequence,
    bind: (MaterialRadioButton) -> Unit = {},
    setAttributes: MaterialRadioButton.(MaterialRadioButton) -> Unit = {}
): MaterialRadioButton {
    return view.context.RadioButton(text,bind, setAttributes).also {
        view.addView(it)
    }
}

inline fun ConstraintLayoutScope.RadioButton(
    text: CharSequence,
    constraintThis: ConstraintLayoutScopeView.() -> Unit,
    bind: (MaterialRadioButton) -> Unit = {},
    setAttributes: MaterialRadioButton.(MaterialRadioButton) -> Unit = {}
): MaterialRadioButton {
    return constraintLayout.context.RadioButton(text,bind, setAttributes).also {
        constraintLayout.addView(it)
        constraintThis(ConstraintLayoutScopeView(constraintLayout, it))
    }
}

inline fun BoxScope.RadioButton(
    text: CharSequence,
    alignment: Alignment? = null,
    bind: (MaterialRadioButton) -> Unit = {},
    setAttributes: MaterialRadioButton.(MaterialRadioButton) -> Unit = {}
): MaterialRadioButton {
    return view.context.RadioButton(text,bind, setAttributes).also {
        view.addView(it)
        val params = RelativeLayout.LayoutParams(
            ViewGroup.LayoutParams.WRAP_CONTENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )
        it.layoutParams = params
        alignment?.run { align(params, this) }
    }
}

inline fun ColumnScope.RadioButton(
    text: CharSequence,
    bind: (MaterialRadioButton) -> Unit = {},
    setAttributes: MaterialRadioButton.(MaterialRadioButton) -> Unit = {}
): MaterialRadioButton {
    return view.context.RadioButton(text,bind, setAttributes).also {
        view.addView(it)
    }
}

inline fun RowScope.RadioButton(
    text: CharSequence,
    bind: (MaterialRadioButton) -> Unit = {},
    setAttributes: MaterialRadioButton.(MaterialRadioButton) -> Unit = {}
): MaterialRadioButton {
    return view.context.RadioButton(text,bind, setAttributes).also {
        view.addView(it)
    }
}

inline fun Context.RadioButton(
    text: CharSequence,
    bind: (MaterialRadioButton) -> Unit = {},
    setAttributes: MaterialRadioButton.(MaterialRadioButton) -> Unit = {}
): MaterialRadioButton {
    return MaterialRadioButton(this).also {
        it.text = text
        bind(it)
        setAttributes(it,it)
    }
}

inline fun ConstraintLayoutScope.RadioGroup(
    block: RadioGroupScope.() -> Unit,
    constraintThis: ConstraintLayoutScopeView.() -> Unit,
    bind: (RadioGroup) -> Unit = {},
    setAttributes: RadioGroup.(RadioGroup) -> Unit = {}
): RadioGroup {
    return constraintLayout.context.RadioGroup(block, bind, setAttributes).also {
        constraintLayout.addView(it)
        constraintThis(ConstraintLayoutScopeView(constraintLayout, it))
    }
}

inline fun BoxScope.RadioGroup(
    block: RadioGroupScope.() -> Unit,
    alignment: Alignment? = null,
    bind: (RadioGroup) -> Unit = {},
    setAttributes: RadioGroup.(RadioGroup) -> Unit = {}
): RadioGroup {
    return view.context.RadioGroup(block, bind, setAttributes).also {
        view.addView(it)
        val params = RelativeLayout.LayoutParams(
            ViewGroup.LayoutParams.WRAP_CONTENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )
        it.layoutParams = params
        alignment?.run { align(params, this) }
    }
}

inline fun ColumnScope.RadioGroup(
    block: RadioGroupScope.() -> Unit,
    bind: (RadioGroup) -> Unit = {},
    setAttributes: RadioGroup.(RadioGroup) -> Unit = {}
): RadioGroup {
    return view.context.RadioGroup(block, bind, setAttributes).also {
        view.addView(it)
    }
}

inline fun RowScope.RadioGroup(
    block: RadioGroupScope.() -> Unit,
    bind: (RadioGroup) -> Unit = {},
    setAttributes: RadioGroup.(RadioGroup) -> Unit = {}
): RadioGroup {
    return view.context.RadioGroup(block, bind, setAttributes).also {
        view.addView(it)
    }
}

inline fun Context.RadioGroup(
    block: RadioGroupScope.() -> Unit,
    bind: (RadioGroup) -> Unit = {},
    setAttributes: RadioGroup.(RadioGroup) -> Unit = {}
): RadioGroup {
    return RadioGroup(this).also {
        block(RadioGroupScope(it))
        bind(it)
        setAttributes(it,it)
    }
}

data class RadioGroupScope(
    val view: RadioGroup
)