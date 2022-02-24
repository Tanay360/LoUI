package com.tanay.loui

import android.widget.TextView


var TextView.textContent: CharSequence
    get() =  text
    set(value) {
        text = value
    }