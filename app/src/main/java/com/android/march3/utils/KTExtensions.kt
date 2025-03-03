package com.android.march3.utils

import android.app.Activity
import android.widget.Toast
import android.widget.EditText
import android.content.Intent
import android.view.View
import androidx.annotation.IdRes
import com.android.march3.R

fun Activity.blankToast(){
    Toast.makeText(this, "Dont leave fields blank!", Toast.LENGTH_SHORT).show()
}

fun Activity.createAccountToast(){
    Toast.makeText(this, "Please Create Account!", Toast.LENGTH_SHORT).show()
}

fun Activity.successfulLoginToast(){
    Toast.makeText(this, "Successfully Logged In!", Toast.LENGTH_SHORT).show()
}

fun EditText.isNotValid(): Boolean{
    return this.text.toString().isNullOrEmpty()
}

inline fun <reified T : View> Activity.find(@IdRes id: Int): T {
    return findViewById(id)
}

fun View.onClick(action: (View) -> Unit) {
    setOnClickListener { action(it) }
}
