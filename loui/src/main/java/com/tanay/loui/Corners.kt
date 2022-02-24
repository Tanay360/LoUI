package com.tanay.loui

data class Corners(
    val topStart: Dp? = null,
    val topEnd: Dp? = null,
    val bottomStart: Dp? = null,
    val bottomEnd: Dp? = null,
) {
    companion object {
        fun all(size: Dp): Corners = Corners(size, size, size, size)
    }
}