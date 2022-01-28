package com.example.medpatapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class item_layout : AppCompatActivity() {
    var mBtnMessage: Button?= null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.pat_item_layout)
        mBtnMessage = findViewById(R.id.mBtnMessage)
        mBtnMessage!!.setOnClickListener{
            startActivity(Intent(this, PatMessage::class.java))
        }

    }
}