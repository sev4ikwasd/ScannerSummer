package com.sev4ikwasd.scannersummer.utils

import android.widget.EditText
import androidx.annotation.StringRes
import androidx.databinding.BindingAdapter

object BindingAdapters {
    @BindingAdapter("app:error")
    @JvmStatic
    fun setError(editText: EditText?, @StringRes resId: Int?) {
        if (editText != null) {
            editText.error = resId?.let { editText.context.getString(it) }
        }
    }
}