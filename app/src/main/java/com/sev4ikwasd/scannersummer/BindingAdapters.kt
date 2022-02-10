package com.sev4ikwasd.scannersummer

import android.widget.EditText
import androidx.databinding.BindingAdapter

object BindingAdapters {
    @BindingAdapter("app:error")
    @JvmStatic
    fun setError(editText: EditText?, resId: Int?) {
        if (editText != null) {
            editText.error = resId?.let { editText.context.getString(it) }
        }
    }
}