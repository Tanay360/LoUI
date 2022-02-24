package com.tanay.loui

import android.content.Context
import android.content.res.ColorStateList
import android.graphics.ColorFilter
import android.graphics.drawable.Drawable
import android.graphics.drawable.VectorDrawable
import androidx.annotation.ColorRes
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.appcompat.content.res.AppCompatResources
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import org.xmlpull.v1.XmlPullParser
import org.xmlpull.v1.XmlPullParserFactory

fun Fragment.stringResource(@StringRes id: Int) = requireContext().resources.getString(id)
fun Context.stringResource(@StringRes id: Int) = resources.getString(id)

fun Context.drawableResource(@DrawableRes id: Int): Drawable? = AppCompatResources.getDrawable(this, id)
fun Fragment.drawableResource(@DrawableRes id: Int): Drawable? = AppCompatResources.getDrawable(requireContext(), id)

fun Context.colorResource(@ColorRes id: Int) = ContextCompat.getColor(this, id)
fun Fragment.colorResource(@ColorRes id: Int) = ContextCompat.getColor(requireContext(), id)

fun Context.colorStateListResource(@ColorRes id: Int): ColorStateList? = ContextCompat.getColorStateList(this, id)
fun Fragment.colorStateListResource(@ColorRes id: Int): ColorStateList? = ContextCompat.getColorStateList(requireContext(), id)