package com.example.medpatapp

import android.app.ProgressDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase

class DocSignup : AppCompatActivity() {
    var editTextName: EditText?= null
    var editTextEmail: EditText?= null
    var editTextPassword: EditText?= null
    var editTextId: EditText?= null
    var editTextNumber: EditText?= null
    var editTextSpecialty: EditText?= null
    var editTextWork: EditText?= null
    var buttonSubmit: Button?=null
    var buttonLogin: Button?=null
    var mAuth:FirebaseAuth? = null



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_doc_signup)

        editTextName = findViewById(R.id.mEdtName)
        editTextEmail = findViewById(R.id.mEdtEmail)
        editTextPassword = findViewById(R.id.mEdtPassword)
        editTextId = findViewById(R.id.mEdtId)
        editTextNumber = findViewById(R.id.mEdtContact)
        editTextSpecialty = findViewById(R.id.mEdtSpecialty)
        editTextWork = findViewById(R.id.mEditInfo)
        buttonSubmit = findViewById(R.id.mBtnSubmit)
        buttonSubmit = findViewById(R.id.mBtnSubmit)
        buttonLogin = findViewById(R.id.mBtnLogin)
        mAuth = FirebaseAuth.getInstance()



        buttonSubmit!!.setOnClickListener {
            //Receive data from the user
            var name = editTextName!!.text.toString()
            var email = editTextEmail!!.text.toString()
            var password =editTextPassword!!.text.toString()
            var id =editTextId!!.text.toString()
            var number =editTextNumber!!.text.toString()
            var specialty =editTextSpecialty!!.text.toString()
            var work=editTextWork!!.text.toString()
            var time = System.currentTimeMillis()
            var progress = ProgressDialog(this)
            progress.setTitle("Saving")
            progress.setMessage("PLease wait...")


            if (name.isEmpty() or email.isEmpty() or password.isEmpty() or id.isEmpty()
                or number.isEmpty() or specialty.isEmpty() or work.isEmpty() ){
                Toast.makeText(this,"Please fill all the inputs", Toast.LENGTH_LONG).show()
            }else{
                //Proceed to save data
                //Create a child(table) in the database
                var my_child = FirebaseDatabase.getInstance().reference.child("Doctors/$time")
                var data= Doctor(name, email, password,id,number,specialty,work)


                //To save data ,simply set the data to my child
                progress.show()
                my_child.setValue(data).addOnCompleteListener { task->
                    progress.dismiss()
                    if(task.isSuccessful){
                        mAuth!!.createUserWithEmailAndPassword(email,password).addOnCompleteListener {
                            task->
                            if (task.isSuccessful){
                                editTextName!!.setText(null)
                                editTextEmail!!.setText(null)
                                editTextPassword!!.setText(null)
                                editTextId!!.setText(null)
                                editTextNumber!!.setText(null)
                                editTextSpecialty!!.setText(null)
                                editTextWork!!.setText(null)
                                Toast.makeText(this,"Saving successful", Toast.LENGTH_LONG).show()
                                startActivity(Intent(applicationContext,DoctorActivity::class.java))
                                finish()
                            }
                        }

                    }else{
                        Toast.makeText(this,"Saving failed", Toast.LENGTH_LONG).show()
                    }

                }

            }


        }
        buttonLogin!!.setOnClickListener{
            startActivity(Intent(this, DocLogIn::class.java))
        }


        }



}