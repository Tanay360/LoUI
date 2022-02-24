@file:Suppress("FunctionName")

package com.tanay.loui

import android.content.Context
import android.graphics.drawable.Drawable
import android.view.MenuItem
import android.view.View
import androidx.annotation.DrawableRes

data class MenuItem(
    val id: Int? = null,
    val title: String,
    val icon: Drawable? = null,
    val priority: MenuPriority? = null,
    val actionView: View? = null,
    val onClick: ((MenuItem?) -> Unit)? = null
) {
    private constructor(
        context: Context,
        id: Int? = null,
        title: String,
        @DrawableRes icon: Int? = null,
        priority: MenuPriority? = null,
        actionView: View? = null,
        onClick: ((MenuItem?) -> Unit)? = null
    ): this(id, title, icon?.let { context.drawableResource(it) }, priority, actionView, onClick)

    companion object {
        fun Context.MenuItem(
            id: Int? = null,
            title: String,
            @DrawableRes icon: Int? = null,
            priority: MenuPriority? = null,
            actionView: View? = null,
            onClick: ((MenuItem?) -> Unit)? = null
        ) = MenuItem(this, id, title, icon, priority, actionView, onClick)
    }
}

enum class MenuPriority(val value: Int) {
    IF_ROOM(MenuItem.SHOW_AS_ACTION_IF_ROOM),
    ALWAYS(MenuItem.SHOW_AS_ACTION_ALWAYS),
    COLLAPSE_ACTION_VIEW(MenuItem.SHOW_AS_ACTION_COLLAPSE_ACTION_VIEW),
    WITH_TEXT(MenuItem.SHOW_AS_ACTION_WITH_TEXT),
    NEVER(MenuItem.SHOW_AS_ACTION_NEVER)
}