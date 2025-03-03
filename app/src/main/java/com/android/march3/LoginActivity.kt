package com.android.march3

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class LoginActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        var fullname = ""
        val username: EditText = findViewById(R.id.username)
        val password: EditText = findViewById(R.id.password)

        intent?.let{
            it.getStringExtra("fullname")?.let { f ->
                fullname = f
            }

            it.getStringExtra("username")?.let { u ->
                username.setText(u)
            }

            it.getStringExtra("password")?.let { p ->
                password.setText(p)
            }
        }

        val loginButton: Button = findViewById(R.id.loginbutton)
        loginButton.setOnClickListener {
            if(username.text.toString().isNullOrEmpty() ||
                password.text.toString().isNullOrEmpty()){
                Toast.makeText(this, "Dont leave fields blank!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            if(fullname.isNullOrEmpty()){
                Toast.makeText(this, "Please Create Account!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val intent = Intent(this, LandingActivity::class.java).apply {
                putExtra("fullname", fullname)
                putExtra("username", username.text.toString())
                putExtra("password", password.text.toString())
            }
            startActivity(intent)
        }

        val registerButton: Button = findViewById(R.id.registerbutton)
        registerButton.setOnClickListener{
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }
    }
}