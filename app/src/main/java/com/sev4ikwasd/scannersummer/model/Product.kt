package com.sev4ikwasd.scannersummer.model

import com.sev4ikwasd.scannersummer.utils.ProductBarCodeErrorEvent
import com.sev4ikwasd.scannersummer.utils.ProductBarCodeException

class Product {
    var vendorCode: String = ""
        private set
    var weight: Int = 0
        private set

    var barCode: String = ""
        set(value) {
            try {
                val barCodeType =
                    BarCodeTypesProvider.barCodeTypes.first { barCodeType -> barCodeType.length == value.length }
                val vendorCodeString = value.take(barCodeType.vendorCodeLength)
                val weightString =
                    value.drop(barCodeType.vendorCodeLength).take(barCodeType.weightLength)
                weight = Integer.parseInt(weightString)
                vendorCode = vendorCodeString
                field = value
            } catch (e: NoSuchElementException) {
                throw ProductBarCodeException(ProductBarCodeErrorEvent.INVALID_LENGTH)
            } catch (e: NumberFormatException) {
                throw ProductBarCodeException(ProductBarCodeErrorEvent.INVALID_WEIGHT)
            }
        }
}
