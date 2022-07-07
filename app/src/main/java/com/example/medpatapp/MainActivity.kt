package com.example.medpatapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    var buttonLicence: Button?=null
    var buttonServices: Button?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        buttonLicence = findViewById(R.id.mBtnLicence)
        buttonServices = findViewById(R.id.mBtnServ)
        buttonLicence!!.setOnClickListener {
            //Moving from one page to another
            startActivity(Intent(this,Practitioners::class.java))
        }
        buttonServices!!.setOnClickListener {
            //Moving from one page to another
            startActivity(Intent(this,Selector::class.java))
        }
    }
}