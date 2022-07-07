package com.example.medpatapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class Selector : AppCompatActivity() {
    var buttonDoctor: Button?=null
    var buttonPatient: Button?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_selector)
        buttonDoctor = findViewById(R.id.mBtnLicence)
        buttonPatient = findViewById(R.id.mBtnServ)
        buttonDoctor!!.setOnClickListener {
            //Moving from one page to another
            startActivity(Intent(this,DocLogIn::class.java))
        }
        buttonPatient!!.setOnClickListener {
            //Moving from one page to another
            startActivity(Intent(this,PatLogIn::class.java))
        }
    }
}

