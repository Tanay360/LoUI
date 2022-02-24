package com.tanay.loui

import android.view.View
import com.tanay.loui.components.BoxScope
import com.tanay.loui.components.ColumnScope
import com.tanay.loui.components.RowScope

data class Padding(
    val left: Dp = Dp(0f),
    val right: Dp = Dp(0f),
    val top: Dp = Dp(0f),
    val bottom: Dp = Dp(0f)
) {
    companion object {
        fun all(dp: Dp): Padding = Padding(dp, dp, dp, dp)
        fun vertical(dp: Dp): Padding = Padding(0.dp, 0.dp, dp, dp)
        fun horizontal(dp: Dp): Padding = Padding(dp, dp, 0.dp, 0.dp)
    }
}

var BoxScope.padding: Padding
    get() = view.padding
    set(value) {
        view.padding = value
    }

var RowScope.padding: Padding
    get() = view.padding
    set(value) {
        view.padding = value
    }

var ColumnScope.padding: Padding
    get() = view.padding
    set(value) {
        view.padding = value
    }

var View.padding: Padding
    get() {
        return Padding(paddingLeft.dp, paddingRight.dp, paddingTop.dp, paddingBottom.dp)
    }
    set(value) {
        setPadding(
            value.left.pixelsInInt,
            value.top.pixelsInInt,
            value.right.pixelsInInt,
            value.bottom.pixelsInInt
        )
    }

