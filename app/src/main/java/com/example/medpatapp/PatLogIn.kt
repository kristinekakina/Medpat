package com.example.medpatapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class PatLogIn : AppCompatActivity() {
    var buttonLogin: Button?=null
    var buttonSignup: Button?=null
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pat_log_in)
        buttonLogin = findViewById(R.id.mBtnLogin)
        buttonSignup = findViewById(R.id.mBtnSignup)
        buttonLogin!!.setOnClickListener {
            //Moving from one page to another
            startActivity(Intent(this, PatientsActivity::class.java))


        }
        buttonSignup!!.setOnClickListener {
            //Moving from one page to another
            startActivity(Intent(this, PatSignup::class.java))


        }
    }
}