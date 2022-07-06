package com.ahmed.week6task3

import android.content.Context
import android.text.Editable
import android.widget.Toast

fun shortToast(context: Context, message: String) {
    Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
}

fun convertStringToEditable(str: String): Editable {
    return Editable.Factory.getInstance().newEditable(str)
}