package com.example.cocusChallenge.utils

import android.util.Log
import java.text.SimpleDateFormat
import java.util.*

fun formatDate(fromDate: String?): String {
    var dateFormatted = ""

    try {
        var simpleDateFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.getDefault())
        var date: Date? = null
        fromDate?.let {
            date = simpleDateFormat.parse(it)
        }

        simpleDateFormat = SimpleDateFormat("MMM dd, yyyy - HH:mm:ss", Locale.getDefault())
        date?.let {
            dateFormatted = simpleDateFormat.format(it)
        }
    } catch (e: Exception) {
        Log.e("dateFormat", "Date format exception")
    }

    return dateFormatted
}