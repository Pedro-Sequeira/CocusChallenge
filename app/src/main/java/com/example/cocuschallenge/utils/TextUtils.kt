package com.example.cocuschallenge.utils

import android.util.Log
import java.text.SimpleDateFormat
import java.util.*

fun formatDate(fromDate: String?): String {
    var dateFormatted = ""

    try {
        var simpleDateFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.getDefault())
        val date = simpleDateFormat.parse(fromDate)

        simpleDateFormat = SimpleDateFormat("MMM dd, yyyy - HH:mm:ss", Locale.getDefault())
        dateFormatted = simpleDateFormat.format(date)
    } catch (e: Exception) {
        Log.e("dateFormat", "Date format exception")
    }

    return dateFormatted
}