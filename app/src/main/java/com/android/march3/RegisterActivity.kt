package com.android.march3

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class RegisterActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        val registerButton: Button = findViewById(R.id.button)
        registerButton.setOnClickListener {
            val fullname: EditText = findViewById(R.id.fullname)
            val username: EditText = findViewById(R.id.username)
            val password: EditText = findViewById(R.id.password)

            if(!fullname.text.toString().isNullOrEmpty() ||
                !username.text.toString().isNullOrEmpty() ||
                !password.text.toString().isNullOrEmpty()){
                val intent = Intent(this, LoginActivity::class.java).apply {
                    putExtra("fullname", fullname.text.toString())
                    putExtra("username", username.text.toString())
                    putExtra("password", password.text.toString())
                }
                startActivity(intent)
            }
            else{
                Toast.makeText(this, "Dont leave fields blank!", Toast.LENGTH_SHORT).show()
            }
        }
    }
}