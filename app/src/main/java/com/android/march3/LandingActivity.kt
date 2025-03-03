package com.android.march3

import android.app.Activity
import android.os.Bundle
import android.widget.TextView

class LandingActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_landing)

        val fullname: TextView = findViewById(R.id.textview)

        intent?.let{
            it.getStringExtra("fullname")?.let { f ->
                fullname.setText("Welcome, " + f + "!")
            }
        }
    }
}