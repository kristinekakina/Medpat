package com.example.medpatapp

import android.app.ProgressDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.ListView
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class PatientsActivity : AppCompatActivity() {
    var mListPerson : ListView?= null
    var mAuth:FirebaseAuth? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_patients)

        mListPerson = findViewById(R.id.mListView)
        mAuth = FirebaseAuth.getInstance();

        var users:ArrayList<Doctor> = ArrayList()
        var myAdapter = CustomAdapterPat(this,users!!)
        var progress = ProgressDialog(this)
        progress.setTitle("Loading")
        progress.setMessage("PLease wait...")
        //access the table in the database
        var my_db = FirebaseDatabase.getInstance().reference.child("Doctors")

        //Start fetching/retrieving data
        progress.show()
        my_db.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                //get the data and put it on the arraylist users
                users.clear()
                for (snap in snapshot.children){
                    var person = snap.getValue(Doctor::class.java)
                    users.add(person!!)
                }
                //Notify the adapter that the data has changed
                myAdapter.notifyDataSetChanged()
                progress.dismiss()
            }

            override fun onCancelled(error: DatabaseError) {
                progress.dismiss()
                Toast.makeText(applicationContext,"DB Locked", Toast.LENGTH_LONG).show()
            }
        })

        mListPerson!!.adapter = myAdapter


    }


    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_see_messages -> {
                Toast.makeText(this,"Messages clicked",Toast.LENGTH_LONG).show()
                true
            }

            R.id.action_logout -> {

                mAuth!!.signOut()
                startActivity(Intent(this,PatLogIn::class.java))
                finish()
                true
            }

            else -> super.onOptionsItemSelected(item)
        }
    }


}
