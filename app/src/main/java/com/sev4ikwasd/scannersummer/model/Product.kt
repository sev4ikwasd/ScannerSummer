package com.sev4ikwasd.scannersummer.model

import kotlin.NumberFormatException

class Product {
    var id: String = ""
        private set
    var weight: Int = 0
        private set

    var barCode: String = ""
        set(value) {
            val weightNumbers: Int
            val trimNumbers: Int
            when(value.length) {
                11, 13 -> {
                    trimNumbers = 1
                    weightNumbers = 5
                }
                22 -> {
                    trimNumbers = 10
                    weightNumbers = 5
                }
                28 -> {
                    trimNumbers = 14
                    weightNumbers = 5
                }
                32 -> {
                    trimNumbers = 18
                    weightNumbers = 5
                }
                else -> throw IllegalArgumentException("Given bar code length not supported")
            }

            val trimmedCode = value.dropLast(trimNumbers)
            val idString = trimmedCode.dropLast(weightNumbers)
            val weightString = trimmedCode.drop(trimmedCode.length - weightNumbers)

            try {
                weight = Integer.parseInt(weightString)
                id = idString
                field = value
            } catch (e: NumberFormatException) {
                throw IllegalArgumentException("Given bar code has non-number symbols")
            }
        }
}
