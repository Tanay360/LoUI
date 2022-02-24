package com.tanay.loui

import android.view.View

fun View.onClick(
    clicked: (View) -> Unit
) {
    setOnClickListener(clicked)
}

fun View.onLongClick(
    onLongPress: (View) -> Unit
) {
    setOnLongClickListener {
        onLongPress(it)
        true
    }
}