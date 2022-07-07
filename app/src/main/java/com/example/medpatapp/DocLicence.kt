package com.example.medpatapp

import android.app.ProgressDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class DocLicence : AppCompatActivity() {
    var mEdtTLicenceNumber: EditText?= null
    var mEdtPhoneNumber: EditText?= null
    var mBtnSend: Button?= null
    var mBtnBack: Button?= null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_doc_licence)
        mEdtTLicenceNumber = findViewById(R.id.mEdtLicenceNumber2)
        mEdtPhoneNumber = findViewById(R.id.mEdtPhoneNumber2)
        mBtnSend = findViewById(R.id.mBtnSend3)
        mBtnBack = findViewById(R.id.mBtnBack3)
        mBtnSend!!.setOnClickListener{
            //Receive data from the user for licence number
            var message = mEdtTLicenceNumber!!.text.toString()
            var time = System.currentTimeMillis()
            var progress = ProgressDialog(this)
            progress.setTitle("Sending")
            progress.setMessage("PLease wait...")

            if (message.isEmpty()  ){
                Toast.makeText(this,"Please fill all the inputs", Toast.LENGTH_LONG).show()
            }else{
                //Proceed to save data
                //Create a child(table) in the database
//                var my_child = FirebaseDatabase.getInstance().reference.child("Message/$time")
//                var data= Message(message)


                //To save data ,simply set the data to my child
//                progress.show()
//                my_child.setValue(data).addOnCompleteListener { task->
//                    progress.dismiss()
//                    if(task.isSuccessful){
//                        mEdtTLicenceNumber!!.setText(null)
//
//                        Toast.makeText(this,"Sending successful", Toast.LENGTH_LONG).show()
//                    }else{
//                        Toast.makeText(this,"Sending failed", Toast.LENGTH_LONG).show()
//                    }
//
//                }

            }
            //Receive data from the user for phone number
            var message1 = mEdtPhoneNumber!!.text.toString()
            var time1 = System.currentTimeMillis()
            var progress1 = ProgressDialog(this)
            progress.setTitle("Sending")
            progress.setMessage("PLease wait...")
            if (message1.isEmpty()  ){
                Toast.makeText(this,"Please fill all the inputs", Toast.LENGTH_LONG).show()
            }else{
                //Proceed to save data
                //Create a child(table) in the database
//                var my_child = FirebaseDatabase.getInstance().reference.child("Message/$time")
//                var data= Message(message)


                //To save data ,simply set the data to my child
//                progress.show()
//                my_child.setValue(data).addOnCompleteListener { task->
//                    progress.dismiss()
//                    if(task.isSuccessful){
//                        mEdtTLicenceNumber!!.setText(null)
//
//                        Toast.makeText(this,"Sending successful", Toast.LENGTH_LONG).show()
//                    }else{
//                        Toast.makeText(this,"Sending failed", Toast.LENGTH_LONG).show()
//                    }
//
//                }

            }


        }
        mBtnBack!!.setOnClickListener{
            startActivity(Intent(this, Practitioners::class.java))
        }
    }
}