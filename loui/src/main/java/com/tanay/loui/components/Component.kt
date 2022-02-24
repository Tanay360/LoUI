@file:Suppress("FunctionName")

package com.tanay.loui.components

import android.annotation.SuppressLint
import android.content.Context
import android.view.View
import android.view.ViewGroup.LayoutParams.WRAP_CONTENT
import android.widget.RelativeLayout
import com.tanay.loui.Alignment

@SuppressLint("SetTextI18n")
inline fun <reified T : View> Context.Component(
    bind: (T) -> Unit = {},
    setAttributes: T.(T) -> Unit = {}
): T {
    val viewClass = T::class.java
    return viewClass.getDeclaredConstructor(Context::class.java).newInstance(this).also { view ->
        bind(view)
        setAttributes(view, view)
    }
}

inline fun <reified T: View> Context.Component(
    view: T,
    bind: (T) -> Unit = {},
    setAttributes: T.(T) -> Unit = {}
): T {
    return view.also {
        bind(it)
        setAttributes(it, it)
    }
}

inline fun <reified T : View> RowScope.Component(
    bind: (T) -> Unit = {},
    setAttributes: T.(T) -> Unit = {}
): T {
    return view.context.Component(bind, setAttributes).also {
        view.addView(it)
    }
}

inline fun <reified T: View> RowScope.Component(
    view: T,
    bind: (T) -> Unit = {},
    setAttributes: T.(T) -> Unit = {}
): T {
    return this.view.context.Component(view, bind, setAttributes).also {
        this.view.addView(it)
    }
}

inline fun <reified T : View> ColumnScope.Component(
    bind: (T) -> Unit = {},
    setAttributes: T.(T) -> Unit = {}
): T {
    return view.context.Component(bind, setAttributes).also {
        view.addView(it)
    }
}

inline fun <reified T: View> ColumnScope.Component(
    view: T,
    bind: (T) -> Unit = {},
    setAttributes: T.(T) -> Unit = {}
): T {
    return this.view.context.Component(view, bind, setAttributes).also {
        this.view.addView(it)
    }
}

inline fun <reified T: View> BoxScope.Component(
    alignment: Alignment? = null,
    bind: (T) -> Unit = {},
    setAttributes: T.(T) -> Unit = {}
): T {
    return view.context.Component(bind, setAttributes).also {
        view.addView(it)
        val params = RelativeLayout.LayoutParams(WRAP_CONTENT, WRAP_CONTENT)
        it.layoutParams = params
        alignment?.run { align(params, this) }
    }
}

inline fun <reified T: View> BoxScope.Component(
    view: T,
    alignment: Alignment? = null,
    bind: (T) -> Unit = {},
    setAttributes: T.(T) -> Unit = {}
): T {
    return this.view.context.Component(view, bind, setAttributes).also {
        this.view.addView(it)
        val params = RelativeLayout.LayoutParams(WRAP_CONTENT, WRAP_CONTENT)
        it.layoutParams = params
        alignment?.run { align(params, this) }
    }
}

inline fun <reified T : View> ConstraintLayoutScope.Component(
    constraintThis: ConstraintLayoutScopeView.() -> Unit,
    bind: (T) -> Unit = {},
    setAttributes: T.(T) -> Unit = {}
): T {
    return constraintLayout.context.Component(bind, setAttributes).also {
        constraintLayout.addView(it)
        constraintThis(ConstraintLayoutScopeView(constraintLayout, it))
    }
}

inline fun <reified T: View> ConstraintLayoutScope.Component(
    constraintThis: ConstraintLayoutScopeView.() -> Unit,
    view: T,
    bind: (T) -> Unit = {},
    setAttributes: T.(T) -> Unit = {}
): T {
    return constraintLayout.context.Component(view, bind, setAttributes).also {
        constraintLayout.addView(it)
        constraintThis(ConstraintLayoutScopeView(constraintLayout, it))
    }
}