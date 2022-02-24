package com.tanay.loui

import android.view.View
import android.widget.CompoundButton
import androidx.annotation.IdRes
import com.google.android.material.chip.Chip
import com.google.android.material.chip.ChipGroup

fun Chip.onClose(onClose: (View) -> Unit) {
    setOnCloseIconClickListener(onClose)
}

fun Chip.onCheckChanged(onCheckChanged: (buttonView: CompoundButton, isChecked: Boolean) -> Unit) {
    setOnCheckedChangeListener(onCheckChanged)
}

fun ChipGroup.onCheckChanged(onCheckChanged: (group: ChipGroup, checkedId: Int) -> Unit){
    setOnCheckedChangeListener(onCheckChanged)
}