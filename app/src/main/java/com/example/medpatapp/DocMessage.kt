package com.example.medpatapp

import android.app.ProgressDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.database.FirebaseDatabase

class DocMessage : AppCompatActivity() {
    var mEdtText: EditText?= null
    var mBtnSend: Button?= null
    var mBtnBack: Button?= null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_doc_message)
        mEdtText = findViewById(R.id.mEdtMulti)
        mBtnSend = findViewById(R.id.mBtnSend)
        mBtnBack = findViewById(R.id.mBtnBack)

        mBtnSend!!.setOnClickListener{
            //Receive data from the user
            var message = mEdtText!!.text.toString()
            var time = System.currentTimeMillis()
            var progress = ProgressDialog(this)
            progress.setTitle("Sending")
            progress.setMessage("PLease wait...")


            if (message.isEmpty()  ){
                Toast.makeText(this,"Please fill all the inputs", Toast.LENGTH_LONG).show()
            }else{
                //Proceed to save data
                //Create a child(table) in the database
                var my_child = FirebaseDatabase.getInstance().reference.child("Messages/$time")
                var data= Message(message)


                //To save data ,simply set the data to my child
                progress.show()
                my_child.setValue(data).addOnCompleteListener { task->
                    progress.dismiss()
                    if(task.isSuccessful){
                        mEdtText!!.setText(null)

                        Toast.makeText(this,"Sending successful", Toast.LENGTH_LONG).show()
                    }else{
                        Toast.makeText(this,"Sending failed", Toast.LENGTH_LONG).show()
                    }

                }

            }


        }
        mBtnBack!!.setOnClickListener{
            startActivity(Intent(this, DocMessage::class.java))
        }

    }
}