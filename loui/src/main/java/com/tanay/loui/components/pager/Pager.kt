@file:Suppress("FunctionName")

package com.tanay.loui.components.pager

import android.content.Context
import android.view.ViewGroup
import android.widget.RelativeLayout
import androidx.viewpager2.widget.ViewPager2
import com.tanay.loui.Alignment
import com.tanay.loui.components.*

fun<Item: Any> ConstraintLayoutScope.Pager(
    constraintThis: ConstraintLayoutScopeView.() -> Unit,
    orientation: PagerOrientation = PagerOrientation.VERTICAL,
    items: List<Item>,
    block: ColumnScope.(item: Item, position: Int) -> Unit
): ViewPager2 {
    return constraintLayout.context.Pager(orientation, items, block).also {
        constraintLayout.addView(it)
        constraintThis(ConstraintLayoutScopeView(constraintLayout, it))
    }
}

fun<Item: Any> BoxScope.Pager(
    alignment: Alignment? = null,
    orientation: PagerOrientation = PagerOrientation.VERTICAL,
    items: List<Item>,
    block: ColumnScope.(item: Item, position: Int) -> Unit
): ViewPager2 {
    return view.context.Pager(orientation, items, block).also {
        view.addView(it)
        val params = RelativeLayout.LayoutParams(
            ViewGroup.LayoutParams.WRAP_CONTENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )
        it.layoutParams = params
        alignment?.run { align(params, this) }
    }
}

fun<Item: Any> ColumnScope.Pager(
    orientation: PagerOrientation = PagerOrientation.VERTICAL,
    items: List<Item>,
    block: ColumnScope.(item: Item, position: Int) -> Unit
): ViewPager2 {
    return view.context.Pager(orientation, items, block).also {
        view.addView(it)
    }
}

fun<Item: Any> RowScope.Pager(
    orientation: PagerOrientation = PagerOrientation.VERTICAL,
    items: List<Item>,
    block: ColumnScope.(item: Item, position: Int) -> Unit
): ViewPager2 {
    return view.context.Pager(orientation, items, block).also {
        view.addView(it)
    }
}

fun<Item: Any> Context.Pager(
    orientation: PagerOrientation = PagerOrientation.VERTICAL,
    items: List<Item>,
    block: ColumnScope.(item: Item, position: Int) -> Unit
): ViewPager2 {
    return ViewPager2(this).also {
        it.adapter = PagerViewAdapter(view = block, items = items)
        it.orientation = orientation.value
    }
}

enum class PagerOrientation(val value: Int) {
    VERTICAL(ViewPager2.ORIENTATION_VERTICAL),
    HORIZONTAL(ViewPager2.ORIENTATION_HORIZONTAL)
}