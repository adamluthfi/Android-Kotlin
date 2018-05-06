package com.dicoding.kotlinacademy.util

import org.junit.Test

import org.junit.Assert.*
import java.text.SimpleDateFormat

class UtilsKtTest {

    @Test
    fun toSimpleDate() {
        val format = SimpleDateFormat("MM/dd/yyyy")
        val date = format.parse("02/28/2018")
        assertEquals("Wed, 28 Feb 2018",toSimpleDate(date))
    }
}