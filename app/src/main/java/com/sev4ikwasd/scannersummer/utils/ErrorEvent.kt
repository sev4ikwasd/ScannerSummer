package com.sev4ikwasd.scannersummer.utils

import androidx.annotation.StringRes

interface ErrorEvent {

    @StringRes
    fun getErrorResource(): Int
}