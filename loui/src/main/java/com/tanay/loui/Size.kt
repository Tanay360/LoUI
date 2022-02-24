package com.tanay.loui

data class Size(
    val width: Dp, val height: Dp
) {
    companion object {
        val FILL_MAX_SIZE = Size(Dp.FILL, Dp.FILL)
        val FILL_MAX_HEIGHT = Size(Dp.WRAP, Dp.FILL)
        val FILL_MAX_WIDTH = Size(Dp.FILL, Dp.WRAP)
    }
}