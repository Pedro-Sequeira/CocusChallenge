package com.example.cocusChallenge.utils

import android.widget.TextView
import androidx.databinding.BindingAdapter

@BindingAdapter("dateFormatted")
fun TextView.setDateFormatted(date: String?) {
    date.let {
        text = formatDate(date)
    }
}