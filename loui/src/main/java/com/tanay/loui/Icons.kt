@file:Suppress("PropertyName", "FunctionName")

package com.tanay.loui

import android.content.Context
import android.graphics.Color
import android.graphics.drawable.Drawable
import androidx.annotation.ColorInt
import androidx.core.content.ContextCompat

class Icons(val context: Context) {
    private val defaultColor = ContextCompat.getColor(context, R.color.iconColorPrimary)
    val Add: Drawable? get() {
        return Add()
    }

    fun Add(@ColorInt color: Int = defaultColor, width: Int = 24, height: Int = 24): Drawable? {
        val paths = listOf(
            VectorDrawableCreator.PathData("M0 0h24v24H0V0z", Color.TRANSPARENT),
            VectorDrawableCreator.PathData("M19 13h-6v6h-2v-6H5v-2h6V5h2v6h6v2z", color)
        )
        return VectorDrawableCreator.getVectorDrawable(context, width.dp.pixelsInInt, height.dp.pixelsInInt,
            24f, 24f, paths)
    }

    val Code: Drawable? get() {
        return Code()
    }

    fun Code(@ColorInt color: Int = defaultColor, width: Int = 24, height: Int = 24): Drawable? {
        val paths = listOf(
            VectorDrawableCreator.PathData("M0 0h24v24H0V0z", Color.TRANSPARENT),
            VectorDrawableCreator.PathData("M9.4 16.6L4.8 12l4.6-4.6L8 6l-6 6 6 6 1.4-1.4zm5.2 0l4.6-4.6-4.6-4.6L16 6l6 6-6 6-1.4-1.4z", color)
        )
        return VectorDrawableCreator.getVectorDrawable(context, width.dp.pixelsInInt, height.dp.pixelsInInt,
            24f, 24f, paths)
    }

    val Done: Drawable? get() {
        return Done()
    }

    fun Done(@ColorInt color: Int = defaultColor, width: Int = 24, height: Int = 24): Drawable? {
        val paths = listOf(
            VectorDrawableCreator.PathData("M0 0h24v24H0V0z", Color.TRANSPARENT),
            VectorDrawableCreator.PathData("M9 16.2L4.8 12l-1.4 1.4L9 19 21 7l-1.4-1.4L9 16.2z", color)
        )
        return VectorDrawableCreator.getVectorDrawable(context, width.dp.pixelsInInt, height.dp.pixelsInInt,
            24f, 24f, paths)
    }

    val Delete: Drawable? get() {
        return Delete()
    }

    fun Delete(@ColorInt color: Int = defaultColor, width: Int = 24, height: Int = 24): Drawable? {
        val paths = listOf(
            VectorDrawableCreator.PathData("M0 0h24v24H0z", Color.TRANSPARENT),
            VectorDrawableCreator.PathData("M6 19c0 1.1.9 2 2 2h8c1.1 0 2-.9 2-2V7H6v12zM19 4h-3.5l-1-1h-5l-1 1H5v2h14V4z", color)
        )
        return VectorDrawableCreator.getVectorDrawable(context, width.dp.pixelsInInt, height.dp.pixelsInInt,
            24f, 24f, paths)
    }

    val FileDownload: Drawable? get() {
        return FileDownload()
    }

    fun FileDownload(@ColorInt color: Int = defaultColor, width: Int = 24, height: Int = 24): Drawable? {
        val paths = listOf(
            VectorDrawableCreator.PathData("M18,15v3H6v-3H4v3c0,1.1 0.9,2 2,2h12c1.1,0 2,-0.9 2,-2v-3H18zM17,11l-1.41,-1.41L13,12.17V4h-2v8.17L8.41,9.59L7,11l5,5L17,11z", color)
        )
        return VectorDrawableCreator.getVectorDrawable(context, width.dp.pixelsInInt, height.dp.pixelsInInt,
            24f, 24f, paths)
    }

    val Edit: Drawable? get() {
        return Edit()
    }

    fun Edit(@ColorInt color: Int = defaultColor, width: Int = 24, height: Int = 24): Drawable? {
        val paths = listOf(
            VectorDrawableCreator.PathData("M0 0h24v24H0z", Color.TRANSPARENT),
            VectorDrawableCreator.PathData("M3 17.25V21h3.75L17.81 9.94l-3.75-3.75L3 17.25zM20.71 7.04c.39-.39.39-1.02 0-1.41l-2.34-2.34c-.39-.39-1.02-.39-1.41 0l-1.83 1.83 3.75 3.75 1.83-1.83zM3 17.25V21h3.75L17.81 9.94l-3.75-3.75L3 17.25zM20.71 7.04c.39-.39.39-1.02 0-1.41l-2.34-2.34c-.39-.39-1.02-.39-1.41 0l-1.83 1.83 3.75 3.75 1.83-1.83z", color)
        )
        return VectorDrawableCreator.getVectorDrawable(context, width.dp.pixelsInInt, height.dp.pixelsInInt,
            24f, 24f, paths)
    }

    val DirectionsCar: Drawable? get() {
        return DirectionsCar()
    }

    fun DirectionsCar(@ColorInt color: Int = defaultColor, width: Int = 24, height: Int = 24): Drawable? {
        val paths = listOf(
            VectorDrawableCreator.PathData("M0 0h24v24H0z", Color.TRANSPARENT),
            VectorDrawableCreator.PathData("M18.92 6.01C18.72 5.42 18.16 5 17.5 5h-11c-.66 0-1.21.42-1.42 1.01L3 12v8c0 .55.45 1 1 1h1c.55 0 1-.45 1-1v-1h12v1c0 .55.45 1 1 1h1c.55 0 1-.45 1-1v-8l-2.08-5.99zM6.5 16c-.83 0-1.5-.67-1.5-1.5S5.67 13 6.5 13s1.5.67 1.5 1.5S7.33 16 6.5 16zm11 0c-.83 0-1.5-.67-1.5-1.5s.67-1.5 1.5-1.5 1.5.67 1.5 1.5-.67 1.5-1.5 1.5zM5 11l1.5-4.5h11L19 11H5z", color)
        )
        return VectorDrawableCreator.getVectorDrawable(context, width.dp.pixelsInInt, height.dp.pixelsInInt,
            24f, 24f, paths)
    }

    val Settings: Drawable? get() {
        return Settings()
    }

    fun Settings(@ColorInt color: Int = defaultColor, width: Int = 24, height: Int = 24): Drawable? {
        val paths = listOf(
            VectorDrawableCreator.PathData("M0,0h24v24H0V0z", Color.TRANSPARENT),
            VectorDrawableCreator.PathData("M19.14,12.94c0.04-0.3,0.06-0.61,0.06-0.94c0-0.32-0.02-0.64-0.07-0.94l2.03-1.58c0.18-0.14,0.23-0.41,0.12-0.61 l-1.92-3.32c-0.12-0.22-0.37-0.29-0.59-0.22l-2.39,0.96c-0.5-0.38-1.03-0.7-1.62-0.94L14.4,2.81c-0.04-0.24-0.24-0.41-0.48-0.41 h-3.84c-0.24,0-0.43,0.17-0.47,0.41L9.25,5.35C8.66,5.59,8.12,5.92,7.63,6.29L5.24,5.33c-0.22-0.08-0.47,0-0.59,0.22L2.74,8.87 C2.62,9.08,2.66,9.34,2.86,9.48l2.03,1.58C4.84,11.36,4.8,11.69,4.8,12s0.02,0.64,0.07,0.94l-2.03,1.58 c-0.18,0.14-0.23,0.41-0.12,0.61l1.92,3.32c0.12,0.22,0.37,0.29,0.59,0.22l2.39-0.96c0.5,0.38,1.03,0.7,1.62,0.94l0.36,2.54 c0.05,0.24,0.24,0.41,0.48,0.41h3.84c0.24,0,0.44-0.17,0.47-0.41l0.36-2.54c0.59-0.24,1.13-0.56,1.62-0.94l2.39,0.96 c0.22,0.08,0.47,0,0.59-0.22l1.92-3.32c0.12-0.22,0.07-0.47-0.12-0.61L19.14,12.94z M12,15.6c-1.98,0-3.6-1.62-3.6-3.6 s1.62-3.6,3.6-3.6s3.6,1.62,3.6,3.6S13.98,15.6,12,15.6z", color)
        )
        return VectorDrawableCreator.getVectorDrawable(context, width.dp.pixelsInInt, height.dp.pixelsInInt,
            24f, 24f, paths)
    }

    val Notifications: Drawable? get() {
        return Notifications()
    }

    fun Notifications(@ColorInt color: Int = defaultColor, width: Int = 24, height: Int = 24): Drawable? {
        val paths = listOf(
            VectorDrawableCreator.PathData("M12 22c1.1 0 2-.9 2-2h-4c0 1.1.89 2 2 2zm6-6v-5c0-3.07-1.64-5.64-4.5-6.32V4c0-.83-.67-1.5-1.5-1.5s-1.5.67-1.5 1.5v.68C7.63 5.36 6 7.92 6 11v5l-2 2v1h16v-1l-2-2z", color)
        )
        return VectorDrawableCreator.getVectorDrawable(context, width.dp.pixelsInInt, height.dp.pixelsInInt,
            24f, 24f, paths)
    }

    val LocalCafe: Drawable? get() {
        return LocalCafe()
    }

    fun LocalCafe(@ColorInt color: Int = defaultColor, width: Int = 24, height: Int = 24): Drawable? {
        val paths = listOf(
            VectorDrawableCreator.PathData("M0 0h24v24H0V0z", Color.TRANSPARENT),
            VectorDrawableCreator.PathData("M20 3H4v10c0 2.21 1.79 4 4 4h6c2.21 0 4-1.79 4-4v-3h2c1.11 0 2-.9 2-2V5c0-1.11-.89-2-2-2zm0 5h-2V5h2v3zM4 19h16v2H4z", color)
        )
        return VectorDrawableCreator.getVectorDrawable(context, width.dp.pixelsInInt, height.dp.pixelsInInt,
            24f, 24f, paths)
    }

    val ArrowBack: Drawable? get() {
        return ArrowBack()
    }

    fun ArrowBack(@ColorInt color: Int = defaultColor, width: Int = 24, height: Int = 24): Drawable? {
        val paths = listOf(
            VectorDrawableCreator.PathData("M0 0h24v24H0z", Color.TRANSPARENT),
            VectorDrawableCreator.PathData("M20 11H7.83l5.59-5.59L12 4l-8 8 8 8 1.41-1.41L7.83 13H20v-2z", color)
        )
        return VectorDrawableCreator.getVectorDrawable(context, width.dp.pixelsInInt, height.dp.pixelsInInt,
            24f, 24f, paths)
    }

    val ChangeHistory: Drawable? get() {
        return ChangeHistory()
    }

    fun ChangeHistory(@ColorInt color: Int = defaultColor, width: Int = 24, height: Int = 24): Drawable? {
        val paths = listOf(
            VectorDrawableCreator.PathData("M0 0h24v24H0V0z", Color.TRANSPARENT),
            VectorDrawableCreator.PathData("M12 7.77L18.39 18H5.61L12 7.77M12 4L2 20h20L12 4z", color)
        )
        return VectorDrawableCreator.getVectorDrawable(context, width.dp.pixelsInInt, height.dp.pixelsInInt,
            24f, 24f, paths)
    }

    val DoneAll: Drawable? get() {
        return DoneAll()
    }

    fun DoneAll(@ColorInt color: Int = defaultColor, width: Int = 24, height: Int = 24): Drawable? {
        val paths = listOf(
            VectorDrawableCreator.PathData("M0 0h24v24H0z", Color.TRANSPARENT),
            VectorDrawableCreator.PathData("M18 7l-1.41-1.41-6.34 6.34 1.41 1.41L18 7zm4.24-1.41L11.66 16.17 7.48 12l-1.41 1.41L11.66 19l12-12-1.42-1.41zM.41 13.41L6 19l1.41-1.41L1.83 12 .41 13.41z", color)
        )
        return VectorDrawableCreator.getVectorDrawable(context, width.dp.pixelsInInt, height.dp.pixelsInInt,
            24f, 24f, paths)
    }

    val Share: Drawable? get() {
        return Share()
    }

    fun Share(@ColorInt color: Int = defaultColor, width: Int = 24, height: Int = 24): Drawable? {
        val paths = listOf(
            VectorDrawableCreator.PathData("M0 0h24v24H0z", Color.TRANSPARENT),
            VectorDrawableCreator.PathData("M18 16.08c-.76 0-1.44.3-1.96.77L8.91 12.7c.05-.23.09-.46.09-.7s-.04-.47-.09-.7l7.05-4.11c.54.5 1.25.81 2.04.81 1.66 0 3-1.34 3-3s-1.34-3-3-3-3 1.34-3 3c0 .24.04.47.09.7L8.04 9.81C7.5 9.31 6.79 9 6 9c-1.66 0-3 1.34-3 3s1.34 3 3 3c.79 0 1.5-.31 2.04-.81l7.12 4.16c-.05.21-.08.43-.08.65 0 1.61 1.31 2.92 2.92 2.92 1.61 0 2.92-1.31 2.92-2.92s-1.31-2.92-2.92-2.92z", color)
        )
        return VectorDrawableCreator.getVectorDrawable(context, width.dp.pixelsInInt, height.dp.pixelsInInt,
            24f, 24f, paths)
    }

    val Close: Drawable? get() {
        return Close()
    }

    fun Close(@ColorInt color: Int = defaultColor, width: Int = 24, height: Int = 24): Drawable? {
        val paths = listOf(
            VectorDrawableCreator.PathData("M0 0h24v24H0z", Color.TRANSPARENT),
            VectorDrawableCreator.PathData("M19 6.41L17.59 5 12 10.59 6.41 5 5 6.41 10.59 12 5 17.59 6.41 19 12 13.41 17.59 19 19 17.59 13.41 12z", color)
        )
        return VectorDrawableCreator.getVectorDrawable(context, width.dp.pixelsInInt, height.dp.pixelsInInt,
            24f, 24f, paths)
    }

    val MoreVert: Drawable? get() {
        return MoreVert()
    }

    fun MoreVert(@ColorInt color: Int = defaultColor, width: Int = 24, height: Int = 24): Drawable? {
        val paths = listOf(
            VectorDrawableCreator.PathData("M0 0h24v24H0z", Color.TRANSPARENT),
            VectorDrawableCreator.PathData("M12 8c1.1 0 2-.9 2-2s-.9-2-2-2-2 .9-2 2 .9 2 2 2zm0 2c-1.1 0-2 .9-2 2s.9 2 2 2 2-.9 2-2-.9-2-2-2zm0 6c-1.1 0-2 .9-2 2s.9 2 2 2 2-.9 2-2-.9-2-2-2z", color)
        )
        return VectorDrawableCreator.getVectorDrawable(context, width.dp.pixelsInInt, height.dp.pixelsInInt,
            24f, 24f, paths)
    }

    val Menu: Drawable? get() {
        return Menu()
    }

    fun Menu(@ColorInt color: Int = defaultColor, width: Int = 24, height: Int = 24): Drawable? {
        val paths = listOf(
            VectorDrawableCreator.PathData("M0 0h24v24H0z", Color.TRANSPARENT),
            VectorDrawableCreator.PathData("M3 18h18v-2H3v2zm0-5h18v-2H3v2zm0-7v2h18V6H3z", color)
        )
        return VectorDrawableCreator.getVectorDrawable(context, width.dp.pixelsInInt, height.dp.pixelsInInt,
            24f, 24f, paths)
    }

    val Send: Drawable? get() {
        return Send()
    }

    fun Send(@ColorInt color: Int = defaultColor, width: Int = 24, height: Int = 24): Drawable? {
        val paths = listOf(
            VectorDrawableCreator.PathData("M0 0h24v24H0z", Color.TRANSPARENT),
            VectorDrawableCreator.PathData("M2.01 21L23 12 2.01 3 2 10l15 2-15 2z", color)
        )
        return VectorDrawableCreator.getVectorDrawable(context, width.dp.pixelsInInt, height.dp.pixelsInInt,
            24f, 24f, paths)
    }

    val Search: Drawable? get() {
        return Search()
    }

    fun Search(@ColorInt color: Int = defaultColor, width: Int = 24, height: Int = 24): Drawable? {
        val paths = listOf(
            VectorDrawableCreator.PathData("M0 0h24v24H0z", Color.TRANSPARENT),
            VectorDrawableCreator.PathData("M15.5 14h-.79l-.28-.27C15.41 12.59 16 11.11 16 9.5 16 5.91 13.09 3 9.5 3S3 5.91 3 9.5 5.91 16 9.5 16c1.61 0 3.09-.59 4.23-1.57l.27.28v.79l5 4.99L20.49 19l-4.99-5zm-6 0C7.01 14 5 11.99 5 9.5S7.01 5 9.5 5 14 7.01 14 9.5 11.99 14 9.5 14z", color)
        )
        return VectorDrawableCreator.getVectorDrawable(context, width.dp.pixelsInInt, height.dp.pixelsInInt,
            24f, 24f, paths)
    }

    val Language: Drawable? get() {
        return Language()
    }

    fun Language(@ColorInt color: Int = defaultColor, width: Int = 24, height: Int = 24): Drawable? {
        val paths = listOf(
            VectorDrawableCreator.PathData("M0 0h24v24H0z", Color.TRANSPARENT),
            VectorDrawableCreator.PathData("M11.99 2C6.47 2 2 6.48 2 12s4.47 10 9.99 10C17.52 22 22 17.52 22 12S17.52 2 11.99 2zm6.93 6h-2.95c-.32-1.25-.78-2.45-1.38-3.56 1.84.63 3.37 1.91 4.33 3.56zM12 4.04c.83 1.2 1.48 2.53 1.91 3.96h-3.82c.43-1.43 1.08-2.76 1.91-3.96zM4.26 14C4.1 13.36 4 12.69 4 12s.1-1.36.26-2h3.38c-.08.66-.14 1.32-.14 2 0 .68.06 1.34.14 2H4.26zm.82 2h2.95c.32 1.25.78 2.45 1.38 3.56-1.84-.63-3.37-1.9-4.33-3.56zm2.95-8H5.08c.96-1.66 2.49-2.93 4.33-3.56C8.81 5.55 8.35 6.75 8.03 8zM12 19.96c-.83-1.2-1.48-2.53-1.91-3.96h3.82c-.43 1.43-1.08 2.76-1.91 3.96zM14.34 14H9.66c-.09-.66-.16-1.32-.16-2 0-.68.07-1.35.16-2h4.68c.09.65.16 1.32.16 2 0 .68-.07 1.34-.16 2zm.25 5.56c.6-1.11 1.06-2.31 1.38-3.56h2.95c-.96 1.65-2.49 2.93-4.33 3.56zM16.36 14c.08-.66.14-1.32.14-2 0-.68-.06-1.34-.14-2h3.38c.16.64.26 1.31.26 2s-.1 1.36-.26 2h-3.38z", color)
        )
        return VectorDrawableCreator.getVectorDrawable(context, width.dp.pixelsInInt, height.dp.pixelsInInt,
            24f, 24f, paths)
    }

    val Mic: Drawable? get() {
        return Mic()
    }

    fun Mic(@ColorInt color: Int = defaultColor, width: Int = 24, height: Int = 24): Drawable? {
        val paths = listOf(
            VectorDrawableCreator.PathData("M0 0h24v24H0z", Color.TRANSPARENT),
            VectorDrawableCreator.PathData("M12 14c1.66 0 2.99-1.34 2.99-3L15 5c0-1.66-1.34-3-3-3S9 3.34 9 5v6c0 1.66 1.34 3 3 3zm5.3-3c0 3-2.54 5.1-5.3 5.1S6.7 14 6.7 11H5c0 3.41 2.72 6.23 6 6.72V21h2v-3.28c3.28-.48 6-3.3 6-6.72h-1.7z", color)
        )
        return VectorDrawableCreator.getVectorDrawable(context, width.dp.pixelsInInt, height.dp.pixelsInInt,
            24f, 24f, paths)
    }

    val FlashOn: Drawable? get() {
        return FlashOn()
    }

    fun FlashOn(@ColorInt color: Int = defaultColor, width: Int = 24, height: Int = 24): Drawable? {
        val paths = listOf(
            VectorDrawableCreator.PathData("M0 0h24v24H0z", Color.TRANSPARENT),
            VectorDrawableCreator.PathData("M7 2v11h3v9l7-12h-4l4-8z", color)
        )
        return VectorDrawableCreator.getVectorDrawable(context, width.dp.pixelsInInt, height.dp.pixelsInInt,
            24f, 24f, paths)
    }

    val Flight: Drawable? get() {
        return Flight()
    }

    fun Flight(@ColorInt color: Int = defaultColor, width: Int = 24, height: Int = 24): Drawable? {
        val paths = listOf(
            VectorDrawableCreator.PathData("M0 0h24v24H0z", Color.TRANSPARENT),
            VectorDrawableCreator.PathData("M21 16v-2l-8-5V3.5c0-.83-.67-1.5-1.5-1.5S10 2.67 10 3.5V9l-8 5v2l8-2.5V19l-2 1.5V22l3.5-1 3.5 1v-1.5L13 19v-5.5l8 2.5z", color)
        )
        return VectorDrawableCreator.getVectorDrawable(context, width.dp.pixelsInInt, height.dp.pixelsInInt,
            24f, 24f, paths)
    }

}

val Context.Icons get() = Icons(this)