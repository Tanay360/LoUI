@file:Suppress("FunctionName")

package com.tanay.loui.components

import android.content.Context
import android.content.res.ColorStateList
import android.content.res.Configuration
import android.content.res.TypedArray
import android.graphics.Color
import android.util.TypedValue
import android.view.Menu
import android.view.View
import androidx.annotation.ColorInt
import androidx.annotation.MenuRes
import androidx.appcompat.widget.TooltipCompat
import androidx.core.content.ContextCompat
import androidx.core.view.MenuItemCompat
import androidx.core.view.ViewCompat
import androidx.core.view.iterator
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigationrail.NavigationRailView
import com.tanay.loui.*

fun Context.BottomNavigationBar(
    textColor: ColorStateList? = null,
    iconTextColor: ColorStateList? = null,
    itemIconSize: Dp? = null,
    @ColorInt backgroundColor: Int = fetchPrimaryColor(),
    @MenuRes menuId: Int? = null,
    menuItems: Array<MenuItem>? = null
): View {
    val orientation = resources.configuration.orientation
    return if (orientation == Configuration.ORIENTATION_LANDSCAPE) {
        NavigationRailView(this).also {
            it.size(Dp.FILL,Dp.WRAP)
//            it.itemRippleColor = ColorStateList.valueOf(Color.LTGRAY)
//            textColor?.let { tc -> it.itemTextColor = tc; it.itemIconTintList = tc }
//            iconTextColor?.let { tc -> it.itemIconTintList = tc }
            itemIconSize?.let { iis -> it.itemIconSize = iis.pixelsInInt }
//            if (iconTextColor != null && textColor == null) {
//                it.itemTextColor = iconTextColor
//            }
            if (menuId != null) {
                it.inflateMenu(menuId)
            } else {
                it.inflateMenu(R.menu.menu_empty)
                val menu = it.menu
                menuItems?.let { menuPairs ->
                    val menuTitles = mutableListOf<String>()
                    for (i in menuPairs.indices) {
                        val menuItem = menuPairs[i]
                        val id = menuItem.id
                        val title = menuItem.title
                        val icon = menuItem.icon
                        val onClick = menuItem.onClick
                        val item = if (id != null) {
                            menu.add(Menu.NONE, id, Menu.NONE, title)
                        } else {
                            menu.add(Menu.NONE, ViewCompat.generateViewId(), Menu.NONE, title)
                        }
                        icon?.let { ic -> item.icon = ic }
                        onClick?.let { oc ->
                            item.setOnMenuItemClickListener { mi ->
                                mi?.isChecked = true
                                oc(mi)
                                true
                            }
                        }
                        MenuItemCompat.setTooltipText(item, title)
                        menuTitles.add(title)
                    }
                    val menuIterator = it.menu
                    var count = 0
                    for (mi in menuIterator) {
                        it.findViewById<View>(mi.itemId)?.let { view ->
                            TooltipCompat.setTooltipText(view, menuTitles.getOrNull(count))
                        }
                        count++
                    }
                }
            }
        }
    } else {
        BottomNavigationView(this).also {
            it.size(60.dp, Dp.FILL)
            it.itemRippleColor = ColorStateList.valueOf(Color.WHITE)
            textColor?.let { tc -> it.itemTextColor = tc; it.itemIconTintList = tc }
            iconTextColor?.let { tc -> it.itemIconTintList = tc }
            if (iconTextColor != null && textColor == null) {
                it.itemTextColor = iconTextColor
            }
            itemIconSize?.let { iis -> it.itemIconSize = iis.pixelsInInt }
            it.setBackgroundColor(backgroundColor)
            menuId?.let { mi ->
                it.inflateMenu(mi)
            } ?: run {
                it.inflateMenu(R.menu.menu_empty)
                val menu = it.menu
                menuItems?.let { menuPairs ->
                    val menuTitles = mutableListOf<String>()
                    for (i in menuPairs.indices) {
                        val menuItem = menuPairs[i]
                        val id = menuItem.id
                        val title = menuItem.title
                        val icon = menuItem.icon
                        val onClick = menuItem.onClick
                        val item = if (id != null) {
                            menu.add(Menu.NONE, id, Menu.NONE, title)
                        } else {
                            menu.add(Menu.NONE, ViewCompat.generateViewId(), Menu.NONE, title)
                        }
                        icon?.let { ic -> item.icon = ic }
                        onClick?.let { oc ->
                            item.setOnMenuItemClickListener { mi ->
                                mi?.isChecked = true
                                oc(mi)
                                true
                            }
                        }
                        MenuItemCompat.setTooltipText(item, title)
                        menuTitles.add(title)
                    }
                    val menuIterator = it.menu
                    var count = 0
                    for (mi in menuIterator) {
                        it.findViewById<View>(mi.itemId)?.let { view ->
                            TooltipCompat.setTooltipText(view, menuTitles.getOrNull(count))
                        }
                        count++
                    }
                }
            }

        }
    }

}

fun Context.fetchPrimaryColor(): Int {
    val typedValue = TypedValue()
    val a: TypedArray =
        obtainStyledAttributes(typedValue.data, intArrayOf(android.R.attr.colorPrimary))
    val color = a.getColor(0, 0)
    a.recycle()
    return color
}