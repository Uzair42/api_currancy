package com.mu42.vidcryptocurrancylist.ui.theme

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mu42.vidcryptocurrancylist.R
import com.mu42.vidcryptocurrancylist.databinding.RvItemBinding


class rvAdapter( var context:Context, var listData:ArrayList<model>) :
RecyclerView.Adapter<rvAdapter.myViewHolder>()
{



    inner class myViewHolder(val rbinding: RvItemBinding):RecyclerView.ViewHolder(rbinding.root){




    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): myViewHolder {

        val myView= RvItemBinding.inflate(LayoutInflater.from(context),parent,false)
            return myViewHolder(myView)

    }

    override fun getItemCount(): Int {
     return listData.size
    }

    override fun onBindViewHolder(holder: myViewHolder, position: Int) {

        holder.rbinding.cName.text=listData[position].cName
        holder.rbinding.cPrice.text=listData[position].cPrice
        holder.rbinding.cSymbol.text=listData[position].cSymbol
    }
}