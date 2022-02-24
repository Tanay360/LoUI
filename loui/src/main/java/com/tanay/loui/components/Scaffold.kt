@file:Suppress("FunctionName")

package com.tanay.loui.components

import android.content.Context
import android.content.res.Configuration
import android.graphics.Color
import android.graphics.drawable.Drawable
import android.view.Gravity
import android.view.Menu
import android.view.View
import android.widget.LinearLayout
import androidx.appcompat.widget.Toolbar
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import com.google.android.material.navigation.NavigationView
import com.tanay.loui.*

fun Fragment.Scaffold(
    navigationIcon: Drawable? = null,
    onNavigationIconClicked: ((View?) -> Unit)? = null,
    menuOptions: Array<MenuItem>? = null,
    topBar: (Context.() -> Toolbar)? = null,
    floatingActionButton: (Context.() -> View)? = null,
    bottomNavigationBar: (Context.() -> View)? = null,
    drawerContent: (Context.() -> View)? = null,
    content: ColumnScope.() -> Unit
): View {
    return requireContext().Scaffold(navigationIcon, onNavigationIconClicked, menuOptions, topBar, floatingActionButton, bottomNavigationBar, drawerContent, content)
}

fun Context.Scaffold(
    navigationIcon: Drawable? = null,
    onNavigationIconClicked: ((View?) -> Unit)? = null,
    menuOptions: Array<MenuItem>? = null,
    topBar: (Context.() -> Toolbar)? = null,
    floatingActionButton: (Context.() -> View)? = null,
    bottomNavigationBar: (Context.() -> View)? = null,
    drawerContent: (Context.() -> View)? = null,
    content: ColumnScope.() -> Unit
): View {
    val drawer = if (drawerContent != null) {
        DrawerLayout(this).also {
            it.size(Dp.FILL, Dp.FILL)
            val dc = drawerContent(this@Scaffold)
            val navigationView = NavigationView(this)
            navigationView.layoutParams = DrawerLayout.LayoutParams(
                DrawerLayout.LayoutParams.WRAP_CONTENT,
                DrawerLayout.LayoutParams.MATCH_PARENT
            ).apply {
                gravity = Gravity.LEFT
            }
            navigationView.addView(dc)
            it.addView(navigationView)
        }
    } else null
    val constraintLayout = ConstraintLayout(
        size = Size.FILL_MAX_SIZE
    ) {
        var topBarId: Int? = ViewCompat.generateViewId()
        if (topBar != null) {
            val toolbar = topBar(this@Scaffold)
            toolbar.id = topBarId!!
            toolbar.inflateMenu(R.menu.menu_empty)
            val menu = toolbar.menu
            menuOptions?.let { menuList ->
                for (i in menuList.indices) {
                    val menuPair = menuList[i]
                    val (id, title, icon, priority, actionView, onClick) = menuPair
                    val item = if (id != null) {
                        menu.add(Menu.NONE, id, Menu.NONE, title)
                    } else {
                        menu.add(title)
                    }
                    icon?.let { item.icon = it }
                    priority?.let { item.setShowAsAction(it.value) }
                    actionView?.let { item.setActionView(it) }
                    onClick?.let { oc ->
                        item.setOnMenuItemClickListener {
                            oc(it)
                            true
                        }
                    }
                }
            }
            navigationIcon?.let {
                toolbar.navigationIcon = it
            } ?: run {
                if (drawer != null) {
                    toolbar.navigationIcon = drawableResource(R.drawable.ic_baseline_menu_24)
                }
            }
            onNavigationIconClicked?.let { clicked ->
                toolbar.setNavigationOnClickListener {
                    if (drawer != null) {
                        if (drawer.isOpen) {
                            drawer.closeDrawer(Gravity.LEFT)
                        } else {
                            drawer.openDrawer(Gravity.LEFT)
                        }
                    } else {
                        clicked(it)
                    }
                }
            } ?: run {
                if (drawer != null) {
                    toolbar.setNavigationOnClickListener {
                        if (drawer.isOpen) {
                            drawer.closeDrawer(Gravity.LEFT)
                        } else {
                            drawer.openDrawer(Gravity.LEFT)
                        }
                    }
                }
            }
            Component(
                view = toolbar,
                constraintThis = {
                    topToTopOfParent()
                    leftToLeftOfParent()
                    rightToRightOfParent()
                }
            )
        } else {
            topBarId = null
        }

        val bottomNavigationViewId =
            if (bottomNavigationBar != null) createRefs().component1() else null

        val bottomNavigationBarLeft = bottomNavigationBar?.let {
            val bnv = it(this@Scaffold)
            if (resources.configuration.orientation == Configuration.ORIENTATION_LANDSCAPE) {
                val (sampleId) = createRefs()
                Component(
                    view = bnv,
                    constraintThis =  {
                        leftToLeftOfParent()
                        topBarId?.let { topToBottomOf(it) } ?: run {
                            topToTopOfParent()
                        }
                        bottomToBottomOfParent()
                    }
                ) {
                    layoutParams = androidx.constraintlayout.widget.ConstraintLayout.LayoutParams(-2, 0)
                    id = sampleId
                }
                Component(
                    view = View(this@Scaffold),
                    constraintThis = {
                        leftToRightOf(sampleId)
                        topBarId?.let { topToBottomOf(it) } ?: run {
                            topToTopOfParent()
                        }
                        bottomToBottomOfParent()
                    }
                ) {
                    id = bottomNavigationViewId!!
                    layoutParams = androidx.constraintlayout.widget.ConstraintLayout.LayoutParams(1, 0)
                    setBackgroundColor(Color.LTGRAY)
                }
                return@let true
            } else {
                Component(
                    view = bnv,
                    constraintThis = {
                        bottomToBottomOfParent()
                        leftToLeftOfParent()
                        rightToRightOfParent()
                    }
                ) {
                    id = bottomNavigationViewId!!
                }
                return@let false
            }
        }

        if (floatingActionButton != null) {
            val fab = floatingActionButton(this@Scaffold)
            Component(
                view = fab,
                constraintThis = {
                    if (bottomNavigationViewId == null) {
                        bottomToBottomOfParent(16.dp)
                    } else {
                        if (bottomNavigationBarLeft == true) {
                            bottomToBottomOfParent()
                        } else {
                            bottomToTopOf(bottomNavigationViewId, 16.dp)
                        }
                    }
                    rightToRightOfParent(16.dp)
                }
            )
        }

        val contentScope = ColumnWithScope(
            size = ConstraintLayoutScope.Size.MATCH_CONSTRAINT,
            constraintThis = {
                if (topBarId != null) {
                    topToBottomOf(topBarId)
                } else {
                    topToTopOfParent()
                }
                if (bottomNavigationBarLeft == true) {
                    leftToLeftOf(bottomNavigationViewId!!)
                } else {
                    leftToLeftOfParent()
                }
                rightToRightOfParent()
                bottomNavigationViewId?.let {
                    if (bottomNavigationBarLeft == true) {
                        bottomToBottomOfParent()
                    } else {
                        bottomToTopOf(it)
                    }
                } ?: bottomToBottomOfParent()
            }
        )
        content(contentScope)
    }
    val mainView = drawer?.also {
        it.addView(constraintLayout, 0)
    } ?: constraintLayout

    return mainView
}

private fun ConstraintLayoutScope.ColumnWithScope(
    size: ConstraintLayoutScope.Size? = null,
    constraintThis: ConstraintLayoutScopeView.() -> Unit
): ColumnScope {
    val ll = LinearLayout(constraintLayout.context).also {
        it.orientation = LinearLayout.VERTICAL
    }
    return ColumnScope(ll.also {
        constraintLayout.addView(it)
        val scope = ConstraintLayoutScopeView(constraintLayout, it)
        constraintThis(scope)
        size?.let { s ->
            it.size(s.height, s.width)
        }
    })
}