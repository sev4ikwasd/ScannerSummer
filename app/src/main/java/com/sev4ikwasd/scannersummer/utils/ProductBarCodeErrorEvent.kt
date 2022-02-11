package com.sev4ikwasd.scannersummer.utils

import androidx.annotation.StringRes
import com.sev4ikwasd.scannersummer.R

enum class ProductBarCodeErrorEvent(@StringRes private val resourceId: Int) : ErrorEvent {
    NONE(0),
    INVALID_LENGTH(R.string.invalid_bar_code_length),
    INVALID_WEIGHT(R.string.invalid_bar_code_weight);

    override fun getErrorResource() = resourceId
}