package com.sev4ikwasd.scannersummer.model

import androidx.databinding.BaseObservable
import androidx.databinding.ObservableArrayList
import androidx.databinding.ObservableList
import androidx.lifecycle.MutableLiveData
import java.lang.StringBuilder

class ProductList: BaseObservable() {
    val weightSum: MutableLiveData<String> = MutableLiveData()

    val products: ObservableList<Product>

    init {
        weightSum.value = "0.0"
        products = ObservableArrayList()
        products.addOnListChangedCallback(object: ObservableList.OnListChangedCallback<ObservableList<Product>>() {
            override fun onChanged(sender: ObservableList<Product>?) {
                changeCalculateWeightSum()
            }

            override fun onItemRangeChanged(
                sender: ObservableList<Product>?,
                positionStart: Int,
                itemCount: Int
            ) {
                changeCalculateWeightSum()
            }

            override fun onItemRangeInserted(
                sender: ObservableList<Product>?,
                positionStart: Int,
                itemCount: Int
            ) {
                changeCalculateWeightSum()
            }

            override fun onItemRangeMoved(
                sender: ObservableList<Product>?,
                fromPosition: Int,
                toPosition: Int,
                itemCount: Int
            ) {
            }

            override fun onItemRangeRemoved(
                sender: ObservableList<Product>?,
                positionStart: Int,
                itemCount: Int
            ) {
                changeCalculateWeightSum()
            }
        })
    }

    private fun changeCalculateWeightSum() {
        var rawWeight = products.sumOf { product -> product.weight }.toString()
        if (rawWeight == "0") weightSum.value = "0.0"
        else {
            while (rawWeight.length < 4) {
                rawWeight = "0$rawWeight"
            }
            weightSum.value = StringBuilder(rawWeight).apply { insert(this.length - 3, ".") }.toString()
        }
    }
}
