package com.android.march3

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.android.march3.customapp.CustomApplication

import com.android.march3.utils.blankToast
import com.android.march3.utils.createAccountToast
import com.android.march3.utils.find
import com.android.march3.utils.isNotValid
import com.android.march3.utils.onClick
import com.android.march3.utils.successfulLoginToast

class LoginActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        var fullname = ""
        val username: EditText = find(R.id.username)
        val password: EditText = find(R.id.password)

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
        loginButton.onClick {
            if(username.isNotValid() ||
                password.isNotValid()){
                blankToast()
                return@onClick
            }

            if(fullname.isNullOrEmpty()){
                createAccountToast()
                return@onClick
            }

            (application as CustomApplication).fullname = fullname
            (application as CustomApplication).username = username.text.toString()
            (application as CustomApplication).password = password.text.toString()

            val intent = Intent(this, LandingActivity::class.java)
            startActivity(intent)
            successfulLoginToast()
        }

        val registerButton: Button = findViewById(R.id.registerbutton)
        registerButton.setOnClickListener{
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }
    }
}