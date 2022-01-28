package com.example.medpatapp.ui.main

import android.app.ProgressDialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListView
import android.widget.Toast
import com.example.medpatapp.CustomAdapterMessage
import com.example.medpatapp.Message
import com.example.medpatapp.R
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener


/**
 * A simple [Fragment] subclass.
 */
class MessagesFragment : Fragment() {
    var mListPerson : ListView?= null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        var root = inflater.inflate(R.layout.fragment_messages  , container, false)
        mListPerson = root.findViewById(R.id.mListView)
        var users:ArrayList<Message> = ArrayList()
        var myAdapter = context?.let { CustomAdapterMessage(it, users!!) }
        var progress = ProgressDialog(context)
        progress.setTitle("Loading")
        progress.setMessage("PLease wait...")
        //access the table in the database
        var my_db = FirebaseDatabase.getInstance().reference.child("Message")

        //Start fetching/retrieving data
        progress.show()
        my_db.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                //get the data and put it on the arraylist users
                users.clear()
                for (snap in snapshot.children){
                    var person = snap.getValue(Message::class.java)
                    users.add(person!!)
                }
                //Notify the adapter that the data has changed
                myAdapter!!.notifyDataSetChanged()
                progress.dismiss()
            }

            override fun onCancelled(error: DatabaseError) {
                progress.dismiss()
                Toast.makeText(context,"DB Locked", Toast.LENGTH_LONG).show()
            }
        })

        mListPerson!!.adapter = myAdapter
        return root
    }


}