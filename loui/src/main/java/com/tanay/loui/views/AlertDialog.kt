package com.tanay.loui.views

import android.content.Context
import android.content.DialogInterface
import androidx.appcompat.app.AlertDialog

class AlertDialog: AlertDialog {
    constructor(context: Context) : super(context)
    constructor(context: Context, themeResId: Int) : super(context, themeResId)
    constructor(
        context: Context,
        cancelable: Boolean,
        cancelListener: DialogInterface.OnCancelListener?
    ) : super(context, cancelable, cancelListener)

    private val dismissListeners = mutableListOf<DialogInterface.OnCancelListener>()

    fun addOnDismissListener(cancelListener: DialogInterface.OnCancelListener) {
        dismissListeners.add(cancelListener)
        setOnDismissListener { dil ->
            dismissListeners.forEach {
                it.onCancel(dil)
            }
        }
    }
}