@file:Suppress("FunctionName")

package com.tanay.loui

import android.view.View
import android.view.ViewGroup
import android.view.ViewGroup.LayoutParams.MATCH_PARENT
import android.view.ViewGroup.LayoutParams.WRAP_CONTENT
import android.widget.LinearLayout
import android.widget.Toast
import com.tanay.loui.components.BoxScope
import com.tanay.loui.components.ColumnScope
import com.tanay.loui.components.ConstraintLayoutScope
import com.tanay.loui.components.RowScope

fun View.size(height: Dp, width: Dp) {
    val params = layoutParams
    if (params != null) {
        changeSize(height, width)
    } else {
        layoutParams = LinearLayout.LayoutParams(WRAP_CONTENT, WRAP_CONTENT)
        changeSize(height, width)
    }
}

fun ConstraintLayoutScope.size(height: Dp, width: Dp) {
    constraintLayout.size(height, width)
}

fun RowScope.size(height: Dp, width: Dp) {
    view.size(height, width)
}

fun ColumnScope.size(height: Dp, width: Dp) {
    view.size(height, width)
}

fun BoxScope.size(height: Dp, width: Dp) {
    view.size(height, width)
}

internal fun View.changeSize(height: Dp, width: Dp) {
    if (height == Dp.FILL && width == Dp.FILL) {
        fillMaxSize()
    } else if (height == Dp.FILL) {
        fillMaxHeight()
        if (width != Dp.WRAP) {
            layoutParams.width = width.pixelsInInt
        }
    } else if (width == Dp.FILL) {
        fillMaxWidth()
        if (height != Dp.WRAP) {
            layoutParams.height = height.pixelsInInt
        }
    } else {
        layoutParams.height = height.pixelsInInt
        layoutParams.width = height.pixelsInInt
    }
}

fun View.fillMaxSize(fillMaxSize: Boolean = true) {
    if (fillMaxSize) {
        val params = layoutParams
        if (params != null) {
            params.width = MATCH_PARENT
            params.height = MATCH_PARENT
        } else {
            layoutParams = LinearLayout.LayoutParams(MATCH_PARENT, MATCH_PARENT)
        }
    }
}

fun View.fillMaxWidth(fillMaxWidth: Boolean = true) {
    if (fillMaxWidth) {
        val params = layoutParams
        if (params != null) {
            params.width = MATCH_PARENT
        } else {
            layoutParams = LinearLayout.LayoutParams(MATCH_PARENT, WRAP_CONTENT)
        }
    }
}

fun View.fillMaxHeight(fillMaxHeight: Boolean = true) {
    if (fillMaxHeight) {
        val params = layoutParams
        if (params != null) {
            params.height = MATCH_PARENT
        } else {
            layoutParams = LinearLayout.LayoutParams(WRAP_CONTENT, MATCH_PARENT)
        }
    }
}