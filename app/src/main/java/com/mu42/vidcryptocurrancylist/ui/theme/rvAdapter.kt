package com.mu42.vidcryptocurrancylist.ui.theme

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mu42.vidcryptocurrancylist.R


class rvAdapter(context:Context, val listData:ArrayList<model>) :
RecyclerView.Adapter<rvAdapter.myViewHolder>()
{



    inner class myViewHolder(view:View):RecyclerView.ViewHolder(view){



    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): myViewHolder {

        val myView= LayoutInflater.from(parent.context).inflate(R.layout.rv_item,parent,false)
        return myViewHolder(myView)

    }

    override fun getItemCount(): Int {
     return listData.size
    }

    override fun onBindViewHolder(holder: myViewHolder, position: Int) {

    }
}