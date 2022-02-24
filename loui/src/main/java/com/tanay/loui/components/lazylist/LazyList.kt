@file:Suppress("FunctionName")

package com.tanay.loui.components.lazylist

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.RelativeLayout
import androidx.recyclerview.widget.LinearLayoutManager
import com.tanay.loui.Alignment
import com.tanay.loui.components.*

fun<Item: Any, Key: Any> ConstraintLayoutScope.LazyList(
    orientation: LazyListOrientation = LazyListOrientation.VERTICAL,
    constraintThis: ConstraintLayoutScopeView.() -> Unit,
    bind: (LazyList<Item, Key>) -> Unit = {},
    items: List<Item>,
    key: (Item) -> Key,
    block: ColumnScope.(Item) -> Unit
): LazyList<Item, Key> {
    return constraintLayout.context.LazyList(orientation, bind, items, key, block).also {
        constraintLayout.addView(it)
        constraintThis(ConstraintLayoutScopeView(constraintLayout, it))
    }
}

fun<Item: Any, Key: Any> BoxScope.LazyList(
    orientation: LazyListOrientation = LazyListOrientation.VERTICAL,
    alignment: Alignment? = null,
    bind: (LazyList<Item, Key>) -> Unit = {},
    items: List<Item>,
    key: (Item) -> Key,
    block: ColumnScope.(Item) -> Unit
): LazyList<Item, Key> {
    return view.context.LazyList(orientation, bind, items, key, block).also {
        view.addView(it)
        val params = RelativeLayout.LayoutParams(
            ViewGroup.LayoutParams.WRAP_CONTENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )
        it.layoutParams = params
        alignment?.run { align(params, this) }
    }
}

fun<Item: Any, Key: Any> ColumnScope.LazyList(
    orientation: LazyListOrientation = LazyListOrientation.VERTICAL,
    bind: (LazyList<Item, Key>) -> Unit = {},
    items: List<Item>,
    key: (Item) -> Key,
    block: ColumnScope.(Item) -> Unit
): LazyList<Item, Key> {
    return view.context.LazyList(orientation, bind, items, key, block).also {
        view.addView(it)
    }
}

fun<Item: Any, Key: Any> RowScope.LazyList(
    orientation: LazyListOrientation = LazyListOrientation.VERTICAL,
    bind: (LazyList<Item, Key>) -> Unit = {},
    items: List<Item>,
    key: (Item) -> Key,
    block: ColumnScope.(Item) -> Unit
): LazyList<Item, Key> {
    return view.context.LazyList(orientation, bind, items, key, block).also {
        view.addView(it)
    }
}

fun<Item: Any, Key: Any> Context.LazyList(
    orientation: LazyListOrientation = LazyListOrientation.VERTICAL,
    bind: (LazyList<Item, Key>) -> Unit = {},
    items: List<Item>,
    key: (Item) -> Key,
    block: ColumnScope.(Item) -> Unit
): LazyList<Item, Key> {
    return LazyList<Item, Key>(this).also {
        it.adapter = LazyListAdapter(view = block, items = items, key = key)
        it.layoutManager = LinearLayoutManager(this, orientation.value, false)
        bind(it)
    }
}

enum class LazyListOrientation(val value: Int) {
    VERTICAL(LinearLayoutManager.VERTICAL),
    HORIZONTAL(LinearLayoutManager.HORIZONTAL)
}