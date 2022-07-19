package com.example.medpatapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class Practitioners : AppCompatActivity() {
    var buttonPrac: Button?=null
    var buttonPhar: Button?=null
    var buttonHos: Button?=null
    var buttonBack1: Button?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_practitioners)
        buttonPrac = findViewById(R.id.mBtnLicence)
        buttonPhar = findViewById(R.id.mBtnServ)
        buttonHos = findViewById(R.id.mBtnHos)
        buttonBack1 = findViewById(R.id.mBtnBack1)
        buttonPrac!!.setOnClickListener {
            //Moving from one page to another
            startActivity(Intent(this,DocLicence::class.java))
        }
        buttonPhar!!.setOnClickListener {
            //Moving from one page to another
            startActivity(Intent(this,MainActivity::class.java))
        }
        buttonBack1!!.setOnClickListener {
            //Moving from one page to another
            startActivity(Intent(this,MainActivity::class.java))
        }
    }
}