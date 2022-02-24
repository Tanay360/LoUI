package com.tanay.loui

import android.view.Gravity
import android.view.View
import android.view.ViewGroup.LayoutParams.MATCH_PARENT
import android.view.ViewGroup.LayoutParams.WRAP_CONTENT
import android.widget.LinearLayout
import android.widget.RelativeLayout
import androidx.constraintlayout.widget.ConstraintLayout
import com.tanay.loui.components.ColumnScope
import com.tanay.loui.components.ConstraintLayoutScope
import com.tanay.loui.components.RowScope

fun RowScope.arrangement(
    arrangement: Arrangement
) {
    val layoutParams = view.layoutParams?.let {
        return@let if (it is LinearLayout.LayoutParams) {
            it
        } else {
            LinearLayout.LayoutParams(it.width, it.height).also { lp ->
                view.layoutParams = lp
            }
        }
    } ?: view.let {
        return@let LinearLayout.LayoutParams(WRAP_CONTENT, MATCH_PARENT).also { lp ->
            it.layoutParams = lp
        }
    }
    layoutParams.gravity = arrangement.value
}

fun ColumnScope.arrangement(
    arrangement: Arrangement
) {
    val layoutParams = view.layoutParams?.let {
        return@let if (it is LinearLayout.LayoutParams) {
            it
        } else {
            LinearLayout.LayoutParams(it.width, it.height).also { lp ->
                view.layoutParams = lp
            }
        }
    } ?: view.let {
        return@let LinearLayout.LayoutParams(MATCH_PARENT, WRAP_CONTENT).also { lp ->
            it.layoutParams = lp
        }
    }
    layoutParams.gravity = arrangement.value
}

fun View.arrangement(
    arrangement: Arrangement
) {
    val layoutParams = layoutParams?.let {
        return@let if (it is LinearLayout.LayoutParams) {
            it
        } else {
            LinearLayout.LayoutParams(it.width, it.height).also { lp ->
                layoutParams = lp
            }
        }
    } ?: let {
        return@let LinearLayout.LayoutParams(WRAP_CONTENT, WRAP_CONTENT).also { lp ->
            it.layoutParams = lp
        }
    }
    layoutParams.gravity = arrangement.value
}

enum class Arrangement(val value: Int) {
    CENTER(Gravity.CENTER),
    CENTER_HORIZONTAL(Gravity.CENTER_HORIZONTAL),
    CENTER_VERTICAL(Gravity.CENTER_VERTICAL),
    LEFT(Gravity.LEFT),
    RIGHT(Gravity.RIGHT),
}