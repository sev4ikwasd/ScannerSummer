package com.sev4ikwasd.scannersummer

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.sev4ikwasd.scannersummer.model.Product
import com.sev4ikwasd.scannersummer.model.ProductList
import com.sev4ikwasd.scannersummer.utils.ProductBarCodeException


class MainViewModel: ViewModel() {
    val productList: ProductList = ProductList()
    val barCode: MutableLiveData<String> = MutableLiveData()
    val barCodeError: MutableLiveData<Int> = MutableLiveData()

    fun onBarCodeEnterPressed() {
        try {
            barCodeError.value = null
            val product = Product()
            product.barCode = barCode.value!!.trim()
            productList.products.add(product)
            barCode.value = ""
        } catch (e: ProductBarCodeException) {
            if(barCode.value != "")
                barCodeError.value = e.errorEvent.getErrorResource()
            barCode.value = ""
        }
    }

    fun onResetClicked() {
        productList.products.clear()
        barCode.value = ""
        barCodeError.value = null
    }
}