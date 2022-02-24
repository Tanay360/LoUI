package com.tanay.loui.components

import android.content.Context
import android.content.DialogInterface
import android.view.Gravity
import android.view.View
import android.widget.LinearLayout
import com.tanay.loui.*
import com.tanay.loui.views.AlertDialog

fun Context.AlertDialog(
    title: Context.() -> View,
    content: AlertDialogColumnScope.() -> Unit,
    buttons: AlertDialogRowScope.() -> Unit,
    cancelable: Boolean = true
): AlertDialog {
    return AlertDialog(this).also {
        val view = Card(
            borderRadius = 16.dp
        ) { _ ->
            Column(
                size = Size.FILL_MAX_SIZE
            ) {
                padding = Padding.all(8.dp)
                it.setCancelable(cancelable)
                Component(view = title()) {
                    size(Dp.WRAP, Dp.FILL)
                }
                Component(view = View(this@AlertDialog)) {
                    size(8.dp, Dp.FILL)
                }
                Column(size = Size.FILL_MAX_WIDTH){}.also { ll ->
                    content(AlertDialogColumnScope(dialog = it, view = ll))
                }

                Row(size = Size.FILL_MAX_WIDTH){}.also { ll ->
                    buttons(AlertDialogRowScope(dialog = it, view = ll))
                    ll.gravity = Gravity.END
                }
            }
        }
        it.setView(view)
    }
}


class AlertDialogColumnScope(
    private val dialog: AlertDialog,
    override val view: LinearLayout
): ColumnScope(view) {
    fun dismissDialog() = dialog.dismiss()
    fun onDismissed(onDismiss: (DialogInterface) -> Unit) = dialog.addOnDismissListener(onDismiss)
}

class AlertDialogRowScope(
    private val dialog: AlertDialog,
    override val view: LinearLayout
): RowScope(view) {
    fun dismissDialog() = dialog.dismiss()
    fun onDismissed(onDismiss: (DialogInterface) -> Unit) = dialog.addOnDismissListener(onDismiss)
}