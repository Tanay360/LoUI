package com.tanay.loui.views

import android.content.Context
import android.os.Bundle
import android.os.Parcelable
import android.util.AttributeSet
import android.view.ViewGroup.LayoutParams.MATCH_PARENT
import android.view.ViewGroup.LayoutParams.WRAP_CONTENT
import android.view.inputmethod.EditorInfo
import android.widget.LinearLayout
import android.widget.Toast
import androidx.core.os.bundleOf
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import com.tanay.loui.textContent

class TextField: TextInputLayout {
    val textInputEditText: TextInputEditText = TextInputEditText(context).also {
        it.layoutParams = LayoutParams(MATCH_PARENT, WRAP_CONTENT)
        it.imeOptions = EditorInfo.IME_FLAG_NO_EXTRACT_UI
    }
    constructor(context: Context) : super(context)
    constructor(
        context: Context,
        attrs: AttributeSet?,
    ) : super(context, attrs)
    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    )
    init {
        addView(textInputEditText)
    }

    fun setText(text: String) = textInputEditText.setText(text)
}