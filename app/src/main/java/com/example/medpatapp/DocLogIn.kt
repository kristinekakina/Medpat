package com.example.medpatapp

import android.app.ProgressDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class DocLogIn : AppCompatActivity() {
    var buttonLogin: Button?=null
    var buttonSignup: Button?=null
    var mEdtEmail:EditText?=null
    var mEdtPassword:EditText?=null
    var mAuth:FirebaseAuth? = null
    var dialog:ProgressDialog?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_doc_login)

        buttonLogin = findViewById(R.id.mBtnLogin)
        buttonSignup = findViewById(R.id.mBtnSignup)
        mEdtEmail = findViewById(R.id.mEdtEmail)
        mEdtPassword = findViewById(R.id.editTextNumberPassword)
        mAuth = FirebaseAuth.getInstance()
        dialog = ProgressDialog(this)
        dialog!!.setTitle("Loading")
        dialog!!.setMessage("Please wait...")

        buttonLogin!!.setOnClickListener {
           // Moving from one page to another
            startActivity(Intent(this, DoctorActivity::class.java))
//            var email = mEdtEmail!!.text.toString().trim()
//            var password = mEdtPassword!!.text.toString().trim()
//            if (email.isEmpty() || password.isEmpty()){
//                Toast.makeText(this,"Please fill all inputs",Toast.LENGTH_LONG).show()
//            }else{
//                dialog!!.show()
//                mAuth!!.signInWithEmailAndPassword(email,password).addOnCompleteListener { task->
//                    dialog!!.dismiss()
//                    if (task.isSuccessful){
//                        Toast.makeText(this,"login successful",Toast.LENGTH_LONG).show()
//
//                        startActivity(Intent(this,DoctorActivity::class.java))
//                        finish()
//                    }else{
//                        Toast.makeText(this,"login failed",Toast.LENGTH_LONG).show()
//
//                    }
//                }
//            }


        }
        buttonSignup!!.setOnClickListener {
            //Moving from one page to another
            startActivity(Intent(this, DocSignup::class.java))


        }
    }
}