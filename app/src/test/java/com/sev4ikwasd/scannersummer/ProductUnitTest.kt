package com.sev4ikwasd.scannersummer

import com.sev4ikwasd.scannersummer.model.Product
import org.junit.Assert.assertEquals
import org.junit.Test

class ProductUnitTest {
    @Test
    fun testProductFromBarCode() {
        val product = Product()

        product.barCode = "2791112018103"
        assertEquals("2791112", product.vendorCode)
        assertEquals(1810, product.weight)

        product.barCode = "2791112117656"
        assertEquals("2791112", product.vendorCode)
        assertEquals(11765, product.weight)

        product.barCode = "00000156707"
        assertEquals("00000", product.vendorCode)
        assertEquals(15670, product.weight)

        product.barCode = "1032210007421131121999"
        assertEquals("1032210", product.vendorCode)
        assertEquals(742, product.weight)

        product.barCode = "24309690004320202202070000796365"
        assertEquals("243096900", product.vendorCode)
        assertEquals(4320, product.weight)

        product.barCode = "24311310001130202202050001074652"
        assertEquals("243113100", product.vendorCode)
        assertEquals(1130, product.weight)

        product.barCode = "2131131001914020220205161852"
        assertEquals("213113100", product.vendorCode)
        assertEquals(19140, product.weight)
    }
}