package com.example.medpatapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    var buttonDoctor: Button?=null
    var buttonPatient: Button?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        buttonDoctor = findViewById(R.id.mBtnDoc)
        buttonPatient = findViewById(R.id.mBtnPat)
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