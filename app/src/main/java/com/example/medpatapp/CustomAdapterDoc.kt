package com.example.medpatapp

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.Button
import android.widget.TextView


class CustomAdapterDoc(var context: Context, var data:ArrayList<Doctor>): BaseAdapter() {
    private class ViewHolder(row: View?){
        var mTxtName: TextView
        var mTxtEmail: TextView
        var mTxtNumber: TextView
        var mTxtSpecialty: TextView
        var mTxtWork: TextView
        init {
            this.mTxtName = row?.findViewById(R.id.mTvName) as TextView
            this.mTxtEmail = row?.findViewById(R.id.mTvEmail) as TextView
            this.mTxtNumber = row?.findViewById(R.id.mTvContact) as TextView
            this.mTxtSpecialty = row?.findViewById(R.id.mTvSpecialty) as TextView
            this.mTxtWork = row?.findViewById(R.id.mTvWork) as TextView
        }
    }
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var view: View?
        var viewHolder:ViewHolder
        if (convertView == null){
            var layout = LayoutInflater.from(context)
            view = layout.inflate(R.layout.doc_item_layout,parent,false)
            viewHolder = ViewHolder(view)
            view.tag = viewHolder
        }else{
            view = convertView
            viewHolder = view.tag as ViewHolder
        }
        var item:Doctor = getItem(position) as Doctor
        viewHolder.mTxtName.text = item.name
        viewHolder.mTxtEmail.text = item.email
        viewHolder.mTxtNumber.text = item.number
        viewHolder.mTxtSpecialty.text = item.specialty
        viewHolder.mTxtWork.text = item.work
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

