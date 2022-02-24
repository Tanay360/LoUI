package com.tanay.loui

import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.widget.*
import androidx.appcompat.app.ActionBar
import androidx.appcompat.widget.ActionBarOverlayLayout
import androidx.appcompat.widget.ActionMenuView
import androidx.appcompat.widget.LinearLayoutCompat
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.constraintlayout.widget.Constraints
import androidx.coordinatorlayout.widget.CoordinatorLayout
import androidx.core.view.*
import androidx.drawerlayout.widget.DrawerLayout
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.google.android.material.appbar.CollapsingToolbarLayout
import com.google.android.material.chip.ChipGroup
import com.tanay.loui.components.BoxScope
import com.tanay.loui.components.ColumnScope
import com.tanay.loui.components.RowScope

data class Margins(
    val left: Dp = Dp(0f),
    val right: Dp = Dp(0f),
    val top: Dp = Dp(0f),
    val bottom: Dp = Dp(0f)
) {
    companion object {
        fun all(dp: Dp): Margins = Margins(dp, dp, dp, dp)
        fun vertical(dp: Dp): Margins = Margins(0.dp, 0.dp, dp, dp)
        fun horizontal(dp: Dp): Margins = Margins(dp, dp, 0.dp, 0.dp)
    }
}

var BoxScope.margins: Margins
    get() = view.margins
    set(value) {
        view.margins = value
    }

var ColumnScope.margins: Margins
    get() = view.margins
    set(value) {
        view.margins = value
    }

var RowScope.margins: Margins
    get() = view.margins
    set(value) {
        view.margins = value
    }

var View.margins: Margins
    get() {
        return Margins(marginStart.dp, marginEnd.dp, marginTop.dp, marginBottom.dp)
    }
    set(value) {
        val p = this.layoutParams
        if (p != null) {
            when (p) {
                is ViewGroup.MarginLayoutParams -> {
                    p.leftMargin = value.left.pixelsInInt
                    p.rightMargin = value.right.pixelsInInt
                    p.topMargin = value.top.pixelsInInt
                    p.bottomMargin = value.bottom.pixelsInInt
                }
                is LinearLayout.LayoutParams -> {
                    p.setMargins(value.left.pixelsInInt, value.top.pixelsInInt, value.right.pixelsInInt, value.bottom.pixelsInInt)
                }
                is RelativeLayout.LayoutParams -> {
                    p.setMargins(value.left.pixelsInInt, value.top.pixelsInInt, value.right.pixelsInInt, value.bottom.pixelsInInt)
                }
                is TableRow.LayoutParams -> {
                    p.setMargins(value.left.pixelsInInt, value.top.pixelsInInt, value.right.pixelsInInt, value.bottom.pixelsInInt)
                }
                is FrameLayout.LayoutParams -> {
                    p.setMargins(value.left.pixelsInInt, value.top.pixelsInInt, value.right.pixelsInInt, value.bottom.pixelsInInt)
                }
                is GridLayout.LayoutParams -> {
                    p.setMargins(value.left.pixelsInInt, value.top.pixelsInInt, value.right.pixelsInInt, value.bottom.pixelsInInt)
                }
                is DrawerLayout.LayoutParams -> {
                    p.setMargins(value.left.pixelsInInt, value.top.pixelsInInt, value.right.pixelsInInt, value.bottom.pixelsInInt)
                }
                is RecyclerView.LayoutParams -> {
                    p.setMargins(value.left.pixelsInInt, value.top.pixelsInInt, value.right.pixelsInInt, value.bottom.pixelsInInt)
                }
                is ConstraintLayout.LayoutParams -> {
                    p.setMargins(value.left.pixelsInInt, value.top.pixelsInInt, value.right.pixelsInInt, value.bottom.pixelsInInt)
                }
                is CoordinatorLayout.LayoutParams -> {
                    p.setMargins(value.left.pixelsInInt, value.top.pixelsInInt, value.right.pixelsInInt, value.bottom.pixelsInInt)
                }
                is Toolbar.LayoutParams -> {
                    p.setMargins(value.left.pixelsInInt, value.top.pixelsInInt, value.right.pixelsInInt, value.bottom.pixelsInInt)
                }
                is androidx.appcompat.widget.Toolbar.LayoutParams -> {
                    p.setMargins(value.left.pixelsInInt, value.top.pixelsInInt, value.right.pixelsInInt, value.bottom.pixelsInInt)
                }
                is LinearLayoutCompat.LayoutParams -> {
                    p.setMargins(value.left.pixelsInInt, value.top.pixelsInInt, value.right.pixelsInInt, value.bottom.pixelsInInt)
                }
                is ChipGroup.LayoutParams -> {
                    p.setMargins(value.left.pixelsInInt, value.top.pixelsInInt, value.right.pixelsInInt, value.bottom.pixelsInInt)
                }
                is GridLayoutManager.LayoutParams -> {
                    p.setMargins(value.left.pixelsInInt, value.top.pixelsInInt, value.right.pixelsInInt, value.bottom.pixelsInInt)
                }
                is ActionBarOverlayLayout.LayoutParams -> {
                    p.setMargins(value.left.pixelsInInt, value.top.pixelsInInt, value.right.pixelsInInt, value.bottom.pixelsInInt)
                }
                is CollapsingToolbarLayout.LayoutParams -> {
                    p.setMargins(value.left.pixelsInInt, value.top.pixelsInInt, value.right.pixelsInInt, value.bottom.pixelsInInt)
                }
                is StaggeredGridLayoutManager.LayoutParams -> {
                    p.setMargins(value.left.pixelsInInt, value.top.pixelsInInt, value.right.pixelsInInt, value.bottom.pixelsInInt)
                }
                is Constraints.LayoutParams -> {
                    p.setMargins(value.left.pixelsInInt, value.top.pixelsInInt, value.right.pixelsInInt, value.bottom.pixelsInInt)
                }
                is ActionMenuView.LayoutParams -> {
                    p.setMargins(value.left.pixelsInInt, value.top.pixelsInInt, value.right.pixelsInInt, value.bottom.pixelsInInt)
                }
                is ActionBar.LayoutParams -> {
                    p.setMargins(value.left.pixelsInInt, value.top.pixelsInInt, value.right.pixelsInInt, value.bottom.pixelsInInt)
                }
                is android.widget.ActionMenuView.LayoutParams -> {
                    p.setMargins(value.left.pixelsInInt, value.top.pixelsInInt, value.right.pixelsInInt, value.bottom.pixelsInInt)
                }
            }
        } else {
            val params = ViewGroup.MarginLayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            )
            params.leftMargin = value.left.pixelsInInt
            params.rightMargin = value.right.pixelsInInt
            params.topMargin = value.top.pixelsInInt
            params.bottomMargin = value.bottom.pixelsInInt
            this.layoutParams = params
        }
        requestLayout()
    }