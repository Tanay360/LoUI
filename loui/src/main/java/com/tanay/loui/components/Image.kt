@file:Suppress("FunctionName")

package com.tanay.loui.components

import android.content.Context
import android.graphics.Bitmap
import android.graphics.drawable.Drawable
import android.net.Uri
import android.view.ViewGroup
import android.widget.RelativeLayout
import androidx.annotation.DrawableRes
import com.google.android.material.imageview.ShapeableImageView
import com.google.android.material.shape.CornerFamily
import com.tanay.loui.Alignment
import com.tanay.loui.Dp
import com.tanay.loui.dp

inline fun ConstraintLayoutScope.Image(
    uri: Uri,
    radius: Dp = 0.dp,
    id: Int? = null,
    constraintThis: ConstraintLayoutScopeView.() -> Unit,
    bind: (ShapeableImageView) -> Unit = {},
    setAttributes: ShapeableImageView.(ShapeableImageView) -> Unit = {}
): ShapeableImageView {
    return ShapeableImageView(constraintLayout.context).also {
        constraintLayout.addView(it)
        it.shapeAppearanceModel = it.shapeAppearanceModel
            .toBuilder()
            .setAllCorners(CornerFamily.ROUNDED, radius.pixels)
            .build()
        it.setImageURI(uri)
        id?.let { i -> it.id = i }
        val scope = ConstraintLayoutScopeView(constraintLayout, it)
        constraintThis(scope)
        bind(it)
        setAttributes(it, it)
    }
}

inline fun ConstraintLayoutScope.Image(
    drawable: Drawable,
    radius: Dp = 0.dp,
    id: Int? = null,
    constraintThis: ConstraintLayoutScopeView.() -> Unit,
    bind: (ShapeableImageView) -> Unit = {},
    setAttributes: ShapeableImageView.(ShapeableImageView) -> Unit = {}
): ShapeableImageView {
    return ShapeableImageView(constraintLayout.context).also {
        constraintLayout.addView(it)
        it.shapeAppearanceModel = it.shapeAppearanceModel
            .toBuilder()
            .setAllCorners(CornerFamily.ROUNDED, radius.pixels)
            .build()
        it.setImageDrawable(drawable)
        id?.let { i -> it.id = i }
        val scope = ConstraintLayoutScopeView(constraintLayout, it)
        constraintThis(scope)
        bind(it)
        setAttributes(it, it)
    }
}

inline fun ConstraintLayoutScope.Image(
    bitmap: Bitmap,
    radius: Dp = 0.dp,
    id: Int? = null,
    constraintThis: ConstraintLayoutScopeView.() -> Unit,
    bind: (ShapeableImageView) -> Unit = {},
    setAttributes: ShapeableImageView.(ShapeableImageView) -> Unit = {}
): ShapeableImageView {
    return ShapeableImageView(constraintLayout.context).also {
        constraintLayout.addView(it)
        it.shapeAppearanceModel = it.shapeAppearanceModel
            .toBuilder()
            .setAllCorners(CornerFamily.ROUNDED, radius.pixels)
            .build()
        it.setImageBitmap(bitmap)

        id?.let { i -> it.id = i }
        val scope = ConstraintLayoutScopeView(constraintLayout, it)
        constraintThis(scope)
        bind(it)
        setAttributes(it, it)
    }
}

inline fun ConstraintLayoutScope.Image(
    @DrawableRes source: Int,
    radius: Dp = 0.dp,
    id: Int? = null,
    constraintThis: ConstraintLayoutScopeView.() -> Unit,
    bind: (ShapeableImageView) -> Unit = {},
    setAttributes: ShapeableImageView.(ShapeableImageView) -> Unit = {}
): ShapeableImageView {
    return ShapeableImageView(constraintLayout.context).also {
        constraintLayout.addView(it)
        it.shapeAppearanceModel = it.shapeAppearanceModel
            .toBuilder()
            .setAllCorners(CornerFamily.ROUNDED, radius.pixels)
            .build()
        it.setImageResource(source)
        id?.let { i -> it.id = i }
        val scope = ConstraintLayoutScopeView(constraintLayout, it)
        constraintThis(scope)
        bind(it)
        setAttributes(it, it)
    }
}

inline fun BoxScope.Image(
    uri: Uri,
    alignment: Alignment? = null,
    radius: Dp = 0.dp,
    bind: (ShapeableImageView) -> Unit = {},
    setAttributes: ShapeableImageView.(ShapeableImageView) -> Unit = {}
): ShapeableImageView {
    return ShapeableImageView(view.context).also {
        view.addView(it)
        it.shapeAppearanceModel = it.shapeAppearanceModel
            .toBuilder()
            .setAllCorners(CornerFamily.ROUNDED, radius.pixels)
            .build()
        val params = RelativeLayout.LayoutParams(
            ViewGroup.LayoutParams.WRAP_CONTENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )
        it.layoutParams = params
        alignment?.run { align(params, this) }
        it.setImageURI(uri)
        bind(it)
        setAttributes(it, it)
    }
}

inline fun BoxScope.Image(
    drawable: Drawable,
    alignment: Alignment? = null,
    radius: Dp = 0.dp,
    bind: (ShapeableImageView) -> Unit = {},
    setAttributes: ShapeableImageView.(ShapeableImageView) -> Unit = {}
): ShapeableImageView {
    return ShapeableImageView(view.context).also {
        view.addView(it)
        it.shapeAppearanceModel = it.shapeAppearanceModel
            .toBuilder()
            .setAllCorners(CornerFamily.ROUNDED, radius.pixels)
            .build()
        val params = RelativeLayout.LayoutParams(
            ViewGroup.LayoutParams.WRAP_CONTENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )
        it.layoutParams = params
        alignment?.run { align(params, this) }
        it.setImageDrawable(drawable)
        bind(it)
        setAttributes(it, it)
    }
}

inline fun BoxScope.Image(
    bitmap: Bitmap,
    alignment: Alignment? = null,
    radius: Dp = 0.dp,
    bind: (ShapeableImageView) -> Unit = {},
    setAttributes: ShapeableImageView.(ShapeableImageView) -> Unit = {}
): ShapeableImageView {
    return ShapeableImageView(view.context).also {
        view.addView(it)
        it.shapeAppearanceModel = it.shapeAppearanceModel
            .toBuilder()
            .setAllCorners(CornerFamily.ROUNDED, radius.pixels)
            .build()
        val params = RelativeLayout.LayoutParams(
            ViewGroup.LayoutParams.WRAP_CONTENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )
        it.layoutParams = params
        alignment?.run { align(params, this) }
        it.setImageBitmap(bitmap)
        bind(it)
        setAttributes(it, it)
    }
}

inline fun BoxScope.Image(
    @DrawableRes source: Int,
    alignment: Alignment? = null,
    radius: Dp = 0.dp,
    bind: (ShapeableImageView) -> Unit = {},
    setAttributes: ShapeableImageView.(ShapeableImageView) -> Unit = {}
): ShapeableImageView {
    return ShapeableImageView(view.context).also {
        view.addView(it)
        it.shapeAppearanceModel = it.shapeAppearanceModel
            .toBuilder()
            .setAllCorners(CornerFamily.ROUNDED, radius.pixels)
            .build()
        val params = RelativeLayout.LayoutParams(
            ViewGroup.LayoutParams.WRAP_CONTENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )
        it.layoutParams = params
        alignment?.run { align(params, this) }
        it.setImageResource(source)
        bind(it)
        setAttributes(it, it)
    }
}


inline fun ColumnScope.Image(
    uri: Uri,
    radius: Dp = 0.dp,
    bind: (ShapeableImageView) -> Unit = {},
    setAttributes: ShapeableImageView.(ShapeableImageView) -> Unit = {}
): ShapeableImageView {
    return ShapeableImageView(view.context).also {
        view.addView(it)
        it.shapeAppearanceModel = it.shapeAppearanceModel
            .toBuilder()
            .setAllCorners(CornerFamily.ROUNDED, radius.pixels)
            .build()
        it.setImageURI(uri)
        bind(it)
        setAttributes(it, it)
    }
}

inline fun ColumnScope.Image(
    drawable: Drawable,
    radius: Dp = 0.dp, bind: (ShapeableImageView) -> Unit = {},
    setAttributes: ShapeableImageView.(ShapeableImageView) -> Unit = {}
): ShapeableImageView {
    return ShapeableImageView(view.context).also {
        view.addView(it)
        it.shapeAppearanceModel = it.shapeAppearanceModel
            .toBuilder()
            .setAllCorners(CornerFamily.ROUNDED, radius.pixels)
            .build()
        it.setImageDrawable(drawable)
        bind(it)
        setAttributes(it, it)
    }
}

inline fun ColumnScope.Image(
    bitmap: Bitmap,
    radius: Dp = 0.dp,
    bind: (ShapeableImageView) -> Unit = {},
    setAttributes: ShapeableImageView.(ShapeableImageView) -> Unit = {}
): ShapeableImageView {
    return ShapeableImageView(view.context).also {
        view.addView(it)
        it.shapeAppearanceModel = it.shapeAppearanceModel
            .toBuilder()
            .setAllCorners(CornerFamily.ROUNDED, radius.pixels)
            .build()
        it.setImageBitmap(bitmap)
        bind(it)
        setAttributes(it, it)
    }
}

inline fun ColumnScope.Image(
    @DrawableRes source: Int,
    radius: Dp = 0.dp,
    bind: (ShapeableImageView) -> Unit = {},
    setAttributes: ShapeableImageView.(ShapeableImageView) -> Unit = {}
): ShapeableImageView {
    return ShapeableImageView(view.context).also {
        view.addView(it)
        it.shapeAppearanceModel = it.shapeAppearanceModel
            .toBuilder()
            .setAllCorners(CornerFamily.ROUNDED, radius.pixels)
            .build()
        it.setImageResource(source)
        bind(it)
        setAttributes(it, it)
    }
}


inline fun RowScope.Image(
    uri: Uri,
    radius: Dp = 0.dp,
    bind: (ShapeableImageView) -> Unit = {},
    setAttributes: ShapeableImageView.(ShapeableImageView) -> Unit = {}
): ShapeableImageView {
    return ShapeableImageView(view.context).also {
        view.addView(it)
        it.shapeAppearanceModel = it.shapeAppearanceModel
            .toBuilder()
            .setAllCorners(CornerFamily.ROUNDED, radius.pixels)
            .build()
        it.setImageURI(uri)
        bind(it)
        setAttributes(it, it)
    }
}

inline fun RowScope.Image(
    drawable: Drawable,
    radius: Dp = 0.dp,
    bind: (ShapeableImageView) -> Unit = {},
    setAttributes: ShapeableImageView.(ShapeableImageView) -> Unit = {}
): ShapeableImageView {
    return ShapeableImageView(view.context).also {
        view.addView(it)
        it.shapeAppearanceModel = it.shapeAppearanceModel
            .toBuilder()
            .setAllCorners(CornerFamily.ROUNDED, radius.pixels)
            .build()
        it.setImageDrawable(drawable)
        bind(it)
        setAttributes(it, it)
    }
}

inline fun RowScope.Image(
    bitmap: Bitmap,
    radius: Dp = 0.dp,
    bind: (ShapeableImageView) -> Unit = {},
    setAttributes: ShapeableImageView.(ShapeableImageView) -> Unit = {}
): ShapeableImageView {
    return ShapeableImageView(view.context).also {
        view.addView(it)
        it.shapeAppearanceModel = it.shapeAppearanceModel
            .toBuilder()
            .setAllCorners(CornerFamily.ROUNDED, radius.pixels)
            .build()
        it.setImageBitmap(bitmap)
        bind(it)
        setAttributes(it, it)
    }
}

inline fun RowScope.Image(
    @DrawableRes source: Int,
    radius: Dp = 0.dp,
    bind: (ShapeableImageView) -> Unit = {},
    setAttributes: ShapeableImageView.(ShapeableImageView) -> Unit = {}
): ShapeableImageView {
    return ShapeableImageView(view.context).also {
        view.addView(it)
        it.shapeAppearanceModel = it.shapeAppearanceModel
            .toBuilder()
            .setAllCorners(CornerFamily.ROUNDED, radius.pixels)
            .build()
        it.setImageResource(source)
        bind(it)
        setAttributes(it, it)
    }
}

inline fun Context.Image(
    uri: Uri,
    radius: Dp = 0.dp,
    bind: (ShapeableImageView) -> Unit = {},
    setAttributes: ShapeableImageView.(ShapeableImageView) -> Unit = {}
): ShapeableImageView {
    return ShapeableImageView(this).also {
        it.shapeAppearanceModel = it.shapeAppearanceModel
            .toBuilder()
            .setAllCorners(CornerFamily.ROUNDED, radius.pixels)
            .build()
        it.setImageURI(uri)
        bind(it)
        setAttributes(it, it)
    }
}

inline fun Context.Image(
    drawable: Drawable,
    radius: Dp = 0.dp,
    bind: (ShapeableImageView) -> Unit = {},
    setAttributes: ShapeableImageView.(ShapeableImageView) -> Unit = {}
): ShapeableImageView {
    return ShapeableImageView(this).also {
        it.shapeAppearanceModel = it.shapeAppearanceModel
            .toBuilder()
            .setAllCorners(CornerFamily.ROUNDED, radius.pixels)
            .build()
        it.setImageDrawable(drawable)
        bind(it)
        setAttributes(it, it)
    }
}

inline fun Context.Image(
    bitmap: Bitmap,
    radius: Dp = 0.dp,
    bind: (ShapeableImageView) -> Unit = {},
    setAttributes: ShapeableImageView.(ShapeableImageView) -> Unit = {}
): ShapeableImageView {
    return ShapeableImageView(this).also {
        it.shapeAppearanceModel = it.shapeAppearanceModel
            .toBuilder()
            .setAllCorners(CornerFamily.ROUNDED, radius.pixels)
            .build()
        it.setImageBitmap(bitmap)
        bind(it)
        setAttributes(it, it)
    }
}

inline fun Context.Image(
    @DrawableRes source: Int,
    radius: Dp = 0.dp,
    bind: (ShapeableImageView) -> Unit = {},
    setAttributes: ShapeableImageView.(ShapeableImageView) -> Unit = {}
): ShapeableImageView {
    return ShapeableImageView(this).also {
        it.shapeAppearanceModel = it.shapeAppearanceModel
            .toBuilder()
            .setAllCorners(CornerFamily.ROUNDED, radius.pixels)
            .build()
        it.setImageResource(source)
        bind(it)
        setAttributes(it, it)
    }
}