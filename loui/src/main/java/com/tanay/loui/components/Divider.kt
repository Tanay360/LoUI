@file:Suppress("FunctionName")

package com.tanay.loui.components

import android.content.Context
import android.graphics.Color
import android.view.View
import android.view.ViewGroup.LayoutParams.MATCH_PARENT
import android.widget.LinearLayout
import com.tanay.loui.Dp
import com.tanay.loui.dp

inline fun ConstraintLayoutScope.Divider(
    constraintThis: ConstraintLayoutScopeView.() -> Unit,
    color: Int = Color.DKGRAY,
    thickness: Dp = 2.dp,
    setAttributes: View.(View) -> Unit = {}
): View {
    return constraintLayout.context.Divider(color, thickness, setAttributes).also {
        constraintLayout.addView(it)
        constraintThis(ConstraintLayoutScopeView(constraintLayout, it))
    }
}

inline fun ColumnScope.Divider(
    color: Int = Color.DKGRAY,
    thickness: Dp = 2.dp,
    setAttributes: View.(View) -> Unit = {}
): View {
    return view.context.Divider(color, thickness, setAttributes).also {
        view.addView(it)
    }
}

inline fun Context.Divider(
    color: Int = Color.GRAY,
    thickness: Dp = 2.dp,
    setAttributes: View.(View) -> Unit = {}
): View {
    return View(this).also {
        it.layoutParams = LinearLayout.LayoutParams(MATCH_PARENT, thickness.pixelsInInt)
        it.setBackgroundColor(color)
        setAttributes(it, it)
    }
}