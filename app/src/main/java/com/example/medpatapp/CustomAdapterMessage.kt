package com.example.medpatapp

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.Button
import android.widget.TextView

class CustomAdapterMessage(var context: Context, var data:ArrayList<Message>): BaseAdapter() {
    private class ViewHolder(row: View?){
        var mTxtMessage: TextView
        var messageButton: Button

        init {
            this.mTxtMessage = row?.findViewById(R.id.mTvPatMessage) as TextView
            this.messageButton = row?.findViewById(R.id.mBtnReply) as Button
        }
    }
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var view: View?
        var viewHolder: ViewHolder
        if (convertView == null) {
            var layout = LayoutInflater.from(context)
            view = layout.inflate(R.layout.activity_doc_message_layout, parent, false)
            viewHolder = ViewHolder(view)
            view.tag = viewHolder
        } else {
            view = convertView
            viewHolder = view.tag as ViewHolder
        }
        var item: Message = getItem(position) as Message
        viewHolder.mTxtMessage.text = item.message
        viewHolder.messageButton.setOnClickListener {
            context.startActivity(Intent(context, DocMessage::class.java))
        }
        return view as View
    }


    override fun getItem(position: Int): Any {
        return  data.get(position)
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getCount(): Int {
        return data.count()
    }
}
