@file:Suppress("FunctionName")

package com.tanay.loui.components

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.RelativeLayout
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.constraintlayout.widget.ConstraintSet
import com.tanay.loui.*

class ConstraintLayoutScope(
    val constraintLayout: ConstraintLayout
) {
    data class Size(val width: Dp, val height: Dp) {
        companion object {
            val MATCH_CONSTRAINT = Size(0.dp, 0.dp)
            val FILL_MAX_SIZE = Size(Dp.FILL, Dp.FILL)
            val FILL_MAX_HEIGHT = Size(Dp.WRAP, Dp.FILL)
            val FILL_MAX_WIDTH = Size(Dp.FILL, Dp.WRAP)
        }
        val size get() = com.tanay.loui.Size(width, height)
    }
}

class ConstraintLayoutScopeView(
    val constraintLayout: ConstraintLayout,
    val view: View
) {
    val parentId: Int get() {
        if (constraintLayout.id == View.NO_ID) {
            val (newId) = createRefs()
            constraintLayout.id = newId
        }
        return constraintLayout.id
    }
    val viewId: Int get() {
        if (view.id == View.NO_ID) {
            val (newId) = createRefs()
            view.id = newId
        }
        return view.id
    }

    private fun constraint(startId: Int, startSide: Int, endId: Int, endSide: Int, margin: Dp) {
        val constraintSet = ConstraintSet()
        constraintSet.clone(constraintLayout)
        constraintSet.connect(startId, startSide, endId, endSide, margin.pixelsInInt)
        constraintSet.applyTo(constraintLayout)
    }

    fun topToTopOf(id: Int, margin: Dp = Dp.ZERO) = constraint(viewId, TOP, id, TOP, margin)
    fun topToTopOfParent(margin: Dp = Dp.ZERO) = constraint(viewId, TOP, parentId, TOP, margin)
    fun topToBottomOf(id: Int, margin: Dp = Dp.ZERO) = constraint(viewId, TOP, id, BOTTOM, margin)
    fun topToBottomOfParent(margin: Dp = Dp.ZERO) = constraint(viewId, TOP, parentId, BOTTOM, margin)
    fun topToLeftOf(id: Int, margin: Dp = Dp.ZERO) = constraint(viewId, TOP, id, LEFT, margin)
    fun topToLeftOfParent(margin: Dp = Dp.ZERO) = constraint(viewId, TOP, parentId, LEFT, margin)
    fun topToRightOf(id: Int, margin: Dp = Dp.ZERO) = constraint(viewId, TOP, id, RIGHT, margin)
    fun topToRightOfParent(margin: Dp = Dp.ZERO) = constraint(viewId, TOP, parentId, RIGHT, margin)

    fun bottomToTopOf(id: Int, margin: Dp = Dp.ZERO) = constraint(viewId, BOTTOM, id, TOP, margin)
    fun bottomToTopOfParent(margin: Dp = Dp.ZERO) = constraint(viewId, BOTTOM, parentId, TOP, margin)
    fun bottomToBottomOf(id: Int, margin: Dp = Dp.ZERO) = constraint(viewId, BOTTOM, id, BOTTOM, margin)
    fun bottomToBottomOfParent(margin: Dp = Dp.ZERO) = constraint(viewId, BOTTOM, parentId, BOTTOM, margin)
    fun bottomToLeftOf(id: Int, margin: Dp = Dp.ZERO) = constraint(viewId, BOTTOM, id, LEFT, margin)
    fun bottomToLeftOfParent(margin: Dp = Dp.ZERO) = constraint(viewId, BOTTOM, parentId, LEFT, margin)
    fun bottomToRightOf(id: Int, margin: Dp = Dp.ZERO) = constraint(viewId, BOTTOM, id, RIGHT, margin)
    fun bottomToRightOfParent(margin: Dp = Dp.ZERO) = constraint(viewId, BOTTOM, parentId, RIGHT, margin)

    fun leftToTopOf(id: Int, margin: Dp = Dp.ZERO) = constraint(viewId, LEFT, id, TOP, margin)
    fun leftToTopOfParent(margin: Dp = Dp.ZERO) = constraint(viewId, LEFT, parentId, TOP, margin)
    fun leftToBottomOf(id: Int, margin: Dp = Dp.ZERO) = constraint(viewId, LEFT, id, BOTTOM, margin)
    fun leftToBottomOfParent(margin: Dp = Dp.ZERO) = constraint(viewId, LEFT, parentId, BOTTOM, margin)
    fun leftToLeftOf(id: Int, margin: Dp = Dp.ZERO) = constraint(viewId, LEFT, id, LEFT, margin)
    fun leftToLeftOfParent(margin: Dp = Dp.ZERO) = constraint(viewId, LEFT, parentId, LEFT, margin)
    fun leftToRightOf(id: Int, margin: Dp = Dp.ZERO) = constraint(viewId, LEFT, id, RIGHT, margin)
    fun leftToRightOfParent(margin: Dp = Dp.ZERO) = constraint(viewId, LEFT, parentId, RIGHT, margin)

    fun rightToTopOf(id: Int, margin: Dp = Dp.ZERO) = constraint(viewId, RIGHT, id, TOP, margin)
    fun rightToTopOfParent(margin: Dp = Dp.ZERO) = constraint(viewId, RIGHT, parentId, TOP, margin)
    fun rightToBottomOf(id: Int, margin: Dp = Dp.ZERO) = constraint(viewId, RIGHT, id, BOTTOM, margin)
    fun rightToBottomOfParent(margin: Dp = Dp.ZERO) = constraint(viewId, RIGHT, parentId, BOTTOM, margin)
    fun rightToLeftOf(id: Int, margin: Dp = Dp.ZERO) = constraint(viewId, RIGHT, id, LEFT, margin)
    fun rightToLeftOfParent(margin: Dp = Dp.ZERO) = constraint(viewId, RIGHT, parentId, LEFT, margin)
    fun rightToRightOf(id: Int, margin: Dp = Dp.ZERO) = constraint(viewId, RIGHT, id, RIGHT, margin)
    fun rightToRightOfParent(margin: Dp = Dp.ZERO) = constraint(viewId, RIGHT, parentId, RIGHT, margin)

    fun baselineToBaselineOf(id: Int, margin: Dp = Dp.ZERO) = constraint(viewId, BASELINE, parentId, BASELINE, margin)

    companion object {
        const val LEFT = ConstraintSet.LEFT
        const val TOP = ConstraintSet.TOP
        const val RIGHT = ConstraintSet.RIGHT
        const val BOTTOM = ConstraintSet.BOTTOM
        const val BASELINE = ConstraintSet.BASELINE
    }
}

inline fun ConstraintLayoutScope.ConstraintLayout(
    size: ConstraintLayoutScope.Size? = null,
    constraintThis: ConstraintLayoutScopeView.() -> Unit,
    block: ConstraintLayoutScope.() -> Unit
) {
    constraintLayout.context.ConstraintLayout(size?.size, block).also {
        constraintLayout.addView(it)
        constraintThis(ConstraintLayoutScopeView(constraintLayout, it))
    }
}

inline fun BoxScope.ConstraintLayout(
    size: Size? = null,
    alignment: Alignment? = null,
    block: ConstraintLayoutScope.() -> Unit
): ConstraintLayout {
    return view.context.ConstraintLayout(size,block).also {
        view.addView(it)
        val params = RelativeLayout.LayoutParams(
            ViewGroup.LayoutParams.WRAP_CONTENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )
        it.layoutParams = params
        alignment?.run { align(params, this) }
        size?.let { s -> it.size(s.height, s.width) }
    }
}

inline fun ColumnScope.ConstraintLayout(
    size: Size? = null,
    block: ConstraintLayoutScope.() -> Unit
): ConstraintLayout {
    return view.context.ConstraintLayout(size,block).also {
        view.addView(it)
    }
}

inline fun RowScope.ConstraintLayout(
    size: Size? = null,
    block: ConstraintLayoutScope.() -> Unit
): ConstraintLayout {
    return view.context.ConstraintLayout(size,block).also {
        view.addView(it)
    }
}

inline fun Context.ConstraintLayout(
    size: Size? = null,
    block: ConstraintLayoutScope.() -> Unit
): ConstraintLayout {
    return ConstraintLayout(this).also {
        size?.let { s -> it.size(s.height, s.width) }
        val scope = ConstraintLayoutScope(it)
        block(scope)
    }
}