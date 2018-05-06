package com.dicoding.kotlinacademy.util

import android.annotation.SuppressLint
import android.view.View
import java.text.SimpleDateFormat
import java.util.*
import java.util.logging.SimpleFormatter

fun View.visible() {
    visibility = View.VISIBLE
}

fun View.invisible() {
    visibility = View.INVISIBLE
}

@SuppressLint("SimpleDateFormat")
fun toSimpleDate(date:Date?):String? = with(date ?: Date()){
    SimpleDateFormat("EEE, dd MMM yyyy").format(this)
}