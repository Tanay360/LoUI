package com.tanay.loui

import android.os.Build
import android.view.View
import androidx.appcompat.widget.TooltipCompat

var View.toolTip: CharSequence?
    get() = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) tooltipText else ""
    set(value) = TooltipCompat.setTooltipText(this, value)