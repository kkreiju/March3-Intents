package com.android.march3.customapp

import android.app.Application

class CustomApplication : Application() {
    private var fn: String = ""
    private var un: String = ""
    private var pw: String = ""
    private var em: String = ""
    private var ph: String = ""

    var fullname: String
        get() = fn
        set(value){
            fn = value
        }

    var username: String
        get() = un
        set(value){
            un = value
        }

    var password: String
        get() = pw
        set(value){
            pw = value
        }

    var email: String
        get() = em
        set(value){
            em = value
        }

    var phonenumber: String
        get() = ph
        set(value){
            ph = value
        }

    override fun onCreate() {
        super.onCreate()
    }
}