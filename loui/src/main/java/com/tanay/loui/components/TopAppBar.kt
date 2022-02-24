@file:Suppress("FunctionName")

package com.tanay.loui.components

import android.content.Context
import android.content.res.TypedArray
import android.util.TypedValue
import android.widget.LinearLayout
import androidx.annotation.ColorInt
import androidx.annotation.StyleRes
import androidx.appcompat.widget.Toolbar
import com.tanay.loui.Dp
import com.tanay.loui.Size
import com.tanay.loui.dp
import com.tanay.loui.size

fun Context.TopAppBar(
    size: Size = Size(Dp.FILL, 60.dp),
    title: CharSequence,
    @StyleRes popupTheme: Int? = null,
    @ColorInt backgroundColor: Int = fetchPrimaryColor(),
    @ColorInt titleColor: Int? = null
): Toolbar {
    return Toolbar(this).also {
        it.size(size.height, size.width)
        it.title = title
        if (popupTheme != null) {
            it.popupTheme = popupTheme
        }
        it.setBackgroundColor(backgroundColor)
        titleColor?.let { color -> it.setTitleTextColor(color) }
    }
}
