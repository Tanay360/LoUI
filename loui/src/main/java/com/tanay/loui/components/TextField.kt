@file:Suppress("FunctionName")

package com.tanay.loui.components

import android.content.Context
import android.content.res.ColorStateList
import android.graphics.drawable.Drawable
import android.text.InputFilter
import android.text.InputFilter.LengthFilter
import android.text.InputType
import android.view.ViewGroup.LayoutParams.MATCH_PARENT
import android.view.ViewGroup.LayoutParams.WRAP_CONTENT
import android.widget.LinearLayout
import android.widget.RelativeLayout
import androidx.annotation.StyleRes
import androidx.appcompat.view.ContextThemeWrapper
import androidx.core.widget.doOnTextChanged
import com.google.android.material.textfield.TextInputLayout
import com.tanay.loui.Alignment
import com.tanay.loui.Corners
import com.tanay.loui.R
import com.tanay.loui.views.TextField

inline fun ConstraintLayoutScope.TextField(
    constraintThis: ConstraintLayoutScopeView.() -> Unit,
    @StyleRes style: Int? = null,
    layoutType: TextFieldType = TextFieldType.FILLED,
    backgroundColor: Int? = null,
    boxStrokeColor: Int? = null,
    boxStrokeColorList: ColorStateList? = null,
    boxStrokeErrorColor: ColorStateList? = null,
    prefixText: CharSequence? = null,
    prefixTextColor: ColorStateList? = null,
    suffixText: CharSequence? = null,
    suffixTextColor: ColorStateList? = null,
    counterEnabled: Boolean = false,
    counterMaxLength: Int? = null,
    counterTextColor: ColorStateList? = null,
    label: CharSequence? = null,
    errorText: CharSequence? = null,
    errorTextColor: ColorStateList? = null,
    helperText: CharSequence? = null,
    helperTextColor: ColorStateList? = null,
    textColor: Int? = null,
    selectionColor: Int? = null,
    textColorHint: ColorStateList? = null,
    hintTextColor: ColorStateList? = null,
    @StyleRes hintTextAppearance: Int? = null,
    hintAnimationEnabled: Boolean = true,
    expandedHintEnabled: Boolean = true,
    startIconDrawable: Drawable? = null,
    startIconDescription: CharSequence? = null,
    startIconTint: ColorStateList? = null,
    isStartIconCheckable: Boolean = false,
    textInputType: TextInputType? = null,
    endIconMode: EndIconModes = EndIconModes.NONE,
    endIconTint: ColorStateList? = null,
    endIconDrawable: Drawable? = null,
    endIconContentDescription: CharSequence? = null,
    endIconCheckable: Boolean = true,
    errorIconDrawable: Drawable? = null,
    errorIconTint: ColorStateList? = null,
    cornerRadius: Corners? = null,
    crossinline onTextChanged: (CharSequence?) -> Unit = {},
    value: String = "",
    bind: (TextField) -> Unit = { },
    setAttributes: (TextField) -> Unit = { }
): TextField {
    return constraintLayout.context.TextField(style, layoutType, backgroundColor, boxStrokeColor, boxStrokeColorList, boxStrokeErrorColor, prefixText, prefixTextColor, suffixText, suffixTextColor, counterEnabled, counterMaxLength, counterTextColor, label, errorText, errorTextColor, helperText, helperTextColor, textColor, selectionColor, textColorHint, hintTextColor, hintTextAppearance, hintAnimationEnabled, expandedHintEnabled, startIconDrawable, startIconDescription, startIconTint, isStartIconCheckable, textInputType, endIconMode, endIconTint, endIconDrawable, endIconContentDescription, endIconCheckable, errorIconDrawable, errorIconTint, cornerRadius, onTextChanged, value, bind, setAttributes).also {
        constraintLayout.addView(it)
        constraintThis(ConstraintLayoutScopeView(constraintLayout, it))
    }
}


inline fun BoxScope.TextField(
    @StyleRes style: Int? = null,
    layoutType: TextFieldType = TextFieldType.FILLED,
    alignment: Alignment? = null,
    backgroundColor: Int? = null,
    boxStrokeColor: Int? = null,
    boxStrokeColorList: ColorStateList? = null,
    boxStrokeErrorColor: ColorStateList? = null,
    prefixText: CharSequence? = null,
    prefixTextColor: ColorStateList? = null,
    suffixText: CharSequence? = null,
    suffixTextColor: ColorStateList? = null,
    counterEnabled: Boolean = false,
    counterMaxLength: Int? = null,
    counterTextColor: ColorStateList? = null,
    label: CharSequence? = null,
    errorText: CharSequence? = null,
    errorTextColor: ColorStateList? = null,
    helperText: CharSequence? = null,
    helperTextColor: ColorStateList? = null,
    textColor: Int? = null,
    selectionColor: Int? = null,
    textColorHint: ColorStateList? = null,
    hintTextColor: ColorStateList? = null,
    @StyleRes hintTextAppearance: Int? = null,
    hintAnimationEnabled: Boolean = true,
    expandedHintEnabled: Boolean = true,
    startIconDrawable: Drawable? = null,
    startIconDescription: CharSequence? = null,
    startIconTint: ColorStateList? = null,
    isStartIconCheckable: Boolean = false,
    textInputType: TextInputType? = null,
    endIconMode: EndIconModes = EndIconModes.NONE,
    endIconTint: ColorStateList? = null,
    endIconDrawable: Drawable? = null,
    endIconContentDescription: CharSequence? = null,
    endIconCheckable: Boolean = true,
    errorIconDrawable: Drawable? = null,
    errorIconTint: ColorStateList? = null,
    cornerRadius: Corners? = null,
    crossinline onTextChanged: (CharSequence?) -> Unit = {},
    value: String = "",
    bind: (TextField) -> Unit = { },
    setAttributes: (TextField) -> Unit = { }
): TextField {
    return view.context.TextField(style, layoutType, backgroundColor, boxStrokeColor, boxStrokeColorList, boxStrokeErrorColor, prefixText, prefixTextColor, suffixText, suffixTextColor, counterEnabled, counterMaxLength, counterTextColor, label, errorText, errorTextColor, helperText, helperTextColor, textColor, selectionColor, textColorHint, hintTextColor, hintTextAppearance, hintAnimationEnabled, expandedHintEnabled, startIconDrawable, startIconDescription, startIconTint, isStartIconCheckable, textInputType, endIconMode, endIconTint, endIconDrawable, endIconContentDescription, endIconCheckable, errorIconDrawable, errorIconTint, cornerRadius, onTextChanged, value, bind, setAttributes).also {
        view.addView(it)
        val params = RelativeLayout.LayoutParams(
            MATCH_PARENT,
            WRAP_CONTENT
        )
        it.layoutParams = params
        alignment?.run { align(params, this) }
    }
}


inline fun ColumnScope.TextField(
    @StyleRes style: Int? = null,
    layoutType: TextFieldType = TextFieldType.FILLED,
    backgroundColor: Int? = null,
    boxStrokeColor: Int? = null,
    boxStrokeColorList: ColorStateList? = null,
    boxStrokeErrorColor: ColorStateList? = null,
    prefixText: CharSequence? = null,
    prefixTextColor: ColorStateList? = null,
    suffixText: CharSequence? = null,
    suffixTextColor: ColorStateList? = null,
    counterEnabled: Boolean = false,
    counterMaxLength: Int? = null,
    counterTextColor: ColorStateList? = null,
    label: CharSequence? = null,
    errorText: CharSequence? = null,
    errorTextColor: ColorStateList? = null,
    helperText: CharSequence? = null,
    helperTextColor: ColorStateList? = null,
    textColor: Int? = null,
    selectionColor: Int? = null,
    textColorHint: ColorStateList? = null,
    hintTextColor: ColorStateList? = null,
    @StyleRes hintTextAppearance: Int? = null,
    hintAnimationEnabled: Boolean = true,
    expandedHintEnabled: Boolean = true,
    startIconDrawable: Drawable? = null,
    startIconDescription: CharSequence? = null,
    startIconTint: ColorStateList? = null,
    isStartIconCheckable: Boolean = false,
    textInputType: TextInputType? = null,
    endIconMode: EndIconModes = EndIconModes.NONE,
    endIconTint: ColorStateList? = null,
    endIconDrawable: Drawable? = null,
    endIconContentDescription: CharSequence? = null,
    endIconCheckable: Boolean = true,
    errorIconDrawable: Drawable? = null,
    errorIconTint: ColorStateList? = null,
    cornerRadius: Corners? = null,
    crossinline onTextChanged: (CharSequence?) -> Unit = {},
    value: String = "",
    bind: (TextField) -> Unit = { },
    setAttributes: (TextField) -> Unit = { }
): TextField {
    return view.context.TextField(style, layoutType, backgroundColor, boxStrokeColor, boxStrokeColorList, boxStrokeErrorColor, prefixText, prefixTextColor, suffixText, suffixTextColor, counterEnabled, counterMaxLength, counterTextColor, label, errorText, errorTextColor, helperText, helperTextColor, textColor, selectionColor, textColorHint, hintTextColor, hintTextAppearance, hintAnimationEnabled, expandedHintEnabled, startIconDrawable, startIconDescription, startIconTint, isStartIconCheckable, textInputType, endIconMode, endIconTint, endIconDrawable, endIconContentDescription, endIconCheckable, errorIconDrawable, errorIconTint, cornerRadius, onTextChanged, value, bind, setAttributes).also {
        view.addView(it)
    }
}


inline fun RowScope.TextField(
    @StyleRes style: Int? = null,
    layoutType: TextFieldType = TextFieldType.FILLED,
    backgroundColor: Int? = null,
    boxStrokeColor: Int? = null,
    boxStrokeColorList: ColorStateList? = null,
    boxStrokeErrorColor: ColorStateList? = null,
    prefixText: CharSequence? = null,
    prefixTextColor: ColorStateList? = null,
    suffixText: CharSequence? = null,
    suffixTextColor: ColorStateList? = null,
    counterEnabled: Boolean = false,
    counterMaxLength: Int? = null,
    counterTextColor: ColorStateList? = null,
    label: CharSequence? = null,
    errorText: CharSequence? = null,
    errorTextColor: ColorStateList? = null,
    helperText: CharSequence? = null,
    helperTextColor: ColorStateList? = null,
    textColor: Int? = null,
    selectionColor: Int? = null,
    textColorHint: ColorStateList? = null,
    hintTextColor: ColorStateList? = null,
    @StyleRes hintTextAppearance: Int? = null,
    hintAnimationEnabled: Boolean = true,
    expandedHintEnabled: Boolean = true,
    startIconDrawable: Drawable? = null,
    startIconDescription: CharSequence? = null,
    startIconTint: ColorStateList? = null,
    isStartIconCheckable: Boolean = false,
    textInputType: TextInputType? = null,
    endIconMode: EndIconModes = EndIconModes.NONE,
    endIconTint: ColorStateList? = null,
    endIconDrawable: Drawable? = null,
    endIconContentDescription: CharSequence? = null,
    endIconCheckable: Boolean = true,
    errorIconDrawable: Drawable? = null,
    errorIconTint: ColorStateList? = null,
    cornerRadius: Corners? = null,
    crossinline onTextChanged: (CharSequence?) -> Unit = {},
    value: String = "",
    bind: (TextField) -> Unit = { },
    setAttributes: (TextField) -> Unit = { }
): TextField {
    return view.context.TextField(style, layoutType, backgroundColor, boxStrokeColor, boxStrokeColorList, boxStrokeErrorColor, prefixText, prefixTextColor, suffixText, suffixTextColor, counterEnabled, counterMaxLength, counterTextColor, label, errorText, errorTextColor, helperText, helperTextColor, textColor, selectionColor, textColorHint, hintTextColor, hintTextAppearance, hintAnimationEnabled, expandedHintEnabled, startIconDrawable, startIconDescription, startIconTint, isStartIconCheckable, textInputType, endIconMode, endIconTint, endIconDrawable, endIconContentDescription, endIconCheckable, errorIconDrawable, errorIconTint, cornerRadius, onTextChanged, value, bind, setAttributes).also {
        view.addView(it)
    }
}


inline fun Context.TextField(
    @StyleRes style: Int? = null,
    layoutType: TextFieldType = TextFieldType.FILLED,
    backgroundColor: Int? = null,
    boxStrokeColor: Int? = null,
    boxStrokeColorList: ColorStateList? = null,
    boxStrokeErrorColor: ColorStateList? = null,
    prefixText: CharSequence? = null,
    prefixTextColor: ColorStateList? = null,
    suffixText: CharSequence? = null,
    suffixTextColor: ColorStateList? = null,
    counterEnabled: Boolean = false,
    counterMaxLength: Int? = null,
    counterTextColor: ColorStateList? = null,
    label: CharSequence? = null,
    errorText: CharSequence? = null,
    errorTextColor: ColorStateList? = null,
    helperText: CharSequence? = null,
    helperTextColor: ColorStateList? = null,
    textColor: Int? = null,
    selectionColor: Int? = null,
    textColorHint: ColorStateList? = null,
    hintTextColor: ColorStateList? = null,
    @StyleRes hintTextAppearance: Int? = null,
    hintAnimationEnabled: Boolean = true,
    expandedHintEnabled: Boolean = true,
    startIconDrawable: Drawable? = null,
    startIconDescription: CharSequence? = null,
    startIconTint: ColorStateList? = null,
    isStartIconCheckable: Boolean = false,
    textInputType: TextInputType? = null,
    endIconMode: EndIconModes = EndIconModes.NONE,
    endIconTint: ColorStateList? = null,
    endIconDrawable: Drawable? = null,
    endIconContentDescription: CharSequence? = null,
    endIconCheckable: Boolean = true,
    errorIconDrawable: Drawable? = null,
    errorIconTint: ColorStateList? = null,
    cornerRadius: Corners? = null,
    crossinline onTextChanged: (CharSequence?) -> Unit = {},
    value: String = "",
    bind: (TextField) -> Unit = { },
    setAttributes: (TextField) -> Unit = { }
): TextField {
    val textLayout = (if (style != null && layoutType == TextFieldType.FILLED) {
        TextField(ContextThemeWrapper(this, style))
    } else if (layoutType == TextFieldType.OUTLINED) {
        TextField(ContextThemeWrapper(this, R.style.OutlinedTextField))
    } else {
        TextField(ContextThemeWrapper(this, R.style.FilledTextField))
    }).also {
        it.layoutParams = LinearLayout.LayoutParams(MATCH_PARENT, WRAP_CONTENT)
    }
    return textLayout.also { til ->
        cornerRadius?.let {
            til.setBoxCornerRadii(
                it.topStart?.pixels ?: til.boxCornerRadiusTopStart,
                it.topEnd?.pixels ?: til.boxCornerRadiusTopEnd,
                it.bottomStart?.pixels ?: til.boxCornerRadiusBottomStart,
                it.bottomEnd?.pixels ?: til.boxCornerRadiusBottomEnd
            )
        }
        prefixText?.let { til.prefixText = it }
        prefixTextColor?.let { til.setPrefixTextColor(it) }
        suffixText?.let { til.suffixText = it }
        suffixTextColor?.let { til.setSuffixTextColor(it) }
        til.isCounterEnabled = counterEnabled
        counterTextColor?.let { til.counterTextColor = it }
        boxStrokeColor?.let { til.boxStrokeColor = it }
        boxStrokeErrorColor?.let { til.boxStrokeErrorColor = it }
        boxStrokeColorList?.let { til.setBoxStrokeColorStateList(it) }
        endIconTint?.let { til.setEndIconTintList(it) }
        endIconDrawable?.let { til.endIconDrawable = it }
        endIconContentDescription?.let { til.endIconContentDescription = it }
        til.isEndIconCheckable = endIconCheckable
        errorIconDrawable?.let { til.errorIconDrawable = it }
        errorIconTint?.let { til.setErrorIconTintList(it) }
        backgroundColor?.let { til.boxBackgroundColor = it }
        hintTextAppearance?.let { til.setHintTextAppearance(it) }
        startIconDescription?.let { til.startIconContentDescription = it }
        til.isHintAnimationEnabled = hintAnimationEnabled
        til.isExpandedHintEnabled = expandedHintEnabled
        startIconTint?.let { til.setStartIconTintList(it) }
        til.isStartIconCheckable = isStartIconCheckable
        errorText?.let {
            til.error = errorText
            til.isErrorEnabled = true
        }
        errorTextColor?.let { til.setErrorTextColor(it) }
        helperText?.let {
            til.helperText = it
            til.isHelperTextEnabled = true
        }
        helperTextColor?.let { til.setHelperTextColor(it) }
        label?.let {
            til.hint = it
            til.isHintEnabled = true
        }
        til.endIconMode = endIconMode.value
        textColorHint?.let { til.defaultHintTextColor = it }
        hintTextColor?.let { til.hintTextColor = it }
        startIconDrawable?.let { til.startIconDrawable = it }
        val textInputEditText = til.textInputEditText
        counterMaxLength?.let {
            til.counterMaxLength = it
            textInputEditText.filters = textInputEditText.filters.toMutableList()
                .also { l -> l.addAll(arrayOf<InputFilter>(LengthFilter(it))) }.toTypedArray()
        }
        textInputEditText.doOnTextChanged { text, _, _, _ -> onTextChanged(text) }
        textInputEditText.setText(value)
        textInputType?.let { textInputEditText.inputType = it.value }
        selectionColor?.let { textInputEditText.highlightColor = it }
        textColor?.let { textInputEditText.setTextColor(it) }
        bind(til)
        setAttributes(til)
    }
}

enum class EndIconModes(val value: Int) {
    CLEAR_TEXT(TextInputLayout.END_ICON_CLEAR_TEXT),
    DROP_DOWN_MENU(TextInputLayout.END_ICON_DROPDOWN_MENU),
    NONE(TextInputLayout.END_ICON_NONE),
    PASSWORD_TOGGLE(TextInputLayout.END_ICON_PASSWORD_TOGGLE),
    CUSTOM(TextInputLayout.END_ICON_CUSTOM)
}

enum class TextFieldType {
    FILLED,
    OUTLINED
}

enum class TextInputType(val value: Int) {
    TEXT(InputType.TYPE_CLASS_TEXT),
    TEXT_CAP_CHARACTERS(InputType.TYPE_TEXT_FLAG_CAP_CHARACTERS),
    TEXT_CAP_WORDS(InputType.TYPE_TEXT_FLAG_CAP_WORDS),
    TEXT_CAP_SENTENCES(InputType.TYPE_TEXT_FLAG_CAP_SENTENCES),
    TEXT_AUTOCORRECT(InputType.TYPE_TEXT_FLAG_AUTO_CORRECT),
    TEXT_AUTOCOMPLETE(InputType.TYPE_TEXT_FLAG_AUTO_COMPLETE),
    TEXT_MULTILINE(InputType.TYPE_TEXT_FLAG_MULTI_LINE),
    TEXT_IME_MULTILINE(InputType.TYPE_TEXT_FLAG_IME_MULTI_LINE),
    TEXT_NO_SUGGESTIONS(InputType.TYPE_TEXT_FLAG_NO_SUGGESTIONS),
    TEXT_URI(InputType.TYPE_TEXT_VARIATION_URI),
    TEXT_EMAIL_ADDRESS(InputType.TYPE_TEXT_VARIATION_EMAIL_ADDRESS),
    TEXT_EMAIL_SUBJECT(InputType.TYPE_TEXT_VARIATION_EMAIL_SUBJECT),
    TEXT_SHORT_MESSAGE(InputType.TYPE_TEXT_VARIATION_SHORT_MESSAGE),
    TEXT_LONG_MESSAGE(InputType.TYPE_TEXT_VARIATION_LONG_MESSAGE),
    TEXT_PERSON_NAME(InputType.TYPE_TEXT_VARIATION_PERSON_NAME),
    TEXT_POSTAL_ADDRESS(InputType.TYPE_TEXT_VARIATION_POSTAL_ADDRESS),
    TEXT_PASSWORD(InputType.TYPE_TEXT_VARIATION_PASSWORD),
    TEXT_VISIBLE_PASSWORD(InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD),
    TEXT_WEB_EDIT_TEXT(InputType.TYPE_TEXT_VARIATION_WEB_EDIT_TEXT),
    TEXT_FILTER(InputType.TYPE_TEXT_VARIATION_FILTER),
    TEXT_PHONETIC(InputType.TYPE_TEXT_VARIATION_PHONETIC),
    TEXT_WEB_EMAIL_ADDRESS(InputType.TYPE_TEXT_VARIATION_WEB_EMAIL_ADDRESS),
    TEXT_WEB_PASSWORD(InputType.TYPE_TEXT_VARIATION_WEB_PASSWORD),
    NUMBER(InputType.TYPE_CLASS_NUMBER),
    NUMBER_SIGNED(InputType.TYPE_NUMBER_FLAG_SIGNED),
    NUMBER_DECIMAL(InputType.TYPE_NUMBER_FLAG_DECIMAL),
    NUMBER_PASSWORD(InputType.TYPE_NUMBER_VARIATION_PASSWORD),
    PHONE(InputType.TYPE_CLASS_PHONE),
    DATE_TIME(InputType.TYPE_CLASS_DATETIME),
    DATE(InputType.TYPE_DATETIME_VARIATION_DATE),
    TIME(InputType.TYPE_DATETIME_VARIATION_TIME)
}