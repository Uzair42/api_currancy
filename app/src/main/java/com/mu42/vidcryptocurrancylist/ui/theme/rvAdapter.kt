package com.mu42.vidcryptocurrancylist.ui.theme

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AlphaAnimation
import androidx.recyclerview.widget.RecyclerView
import com.mu42.vidcryptocurrancylist.R
import com.mu42.vidcryptocurrancylist.databinding.RvItemBinding


class rvAdapter( var context:Context, var listData:ArrayList<model>) :
RecyclerView.Adapter<rvAdapter.myViewHolder>()
{



    fun ChangedData(list:ArrayList<model>)
    {
        listData=list
        notifyDataSetChanged()
    }
    inner class myViewHolder(val rbinding: RvItemBinding):RecyclerView.ViewHolder(rbinding.root){




    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): myViewHolder {

        val myitemView=RvItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return myViewHolder(myitemView)

    }

    override fun getItemCount(): Int {
     return listData.size
    }

    override fun onBindViewHolder(holder: myViewHolder, position: Int) {

        setAnimatation(holder.itemView)
        holder.rbinding.cName.text=listData[position].cName
        holder.rbinding.cPrice.text=listData[position].cPrice
        holder.rbinding.cSymbol.text=listData[position].cSymbol
//        notifyDataSetChanged()
    }

    fun setAnimatation(view : View)
    {
        val anim = AlphaAnimation(0.0f,0.1f)
        anim.duration=100
        view.startAnimation(anim)

    }



}