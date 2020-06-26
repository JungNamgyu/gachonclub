package com.example.gachon_club.Club.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.gachon_club.Club.Adapter.RecyclerAdapter.ViewHolder
import com.example.gachon_club.Club.Model.Club
import com.example.gachon_club.R

class RecyclerAdapter(var clubList: ArrayList<Club>, var context: Context, var itemClick: (Club) -> Unit)
    : RecyclerView.Adapter<ViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(context)
                .inflate(R.layout.list_club_view,parent ,false), itemClick)
    }

    override fun getItemCount(): Int {
        return clubList.count()
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(clubList[position],context)
    }


    inner class ViewHolder (itemView: View?, itemClick: (Club) -> Unit) : RecyclerView.ViewHolder(itemView!!){

        val title = itemView?.findViewById<TextView>(R.id.text_Title)
        val info = itemView?.findViewById<TextView>(R.id.text_info)
        val logo = itemView?.findViewById<ImageView>(R.id.image_logo)

        fun bind(itemClub : Club? , context: Context){
            title?.text = itemClub?.name
            info?.text = itemClub?.info
            Glide.with(context)
                .load("http://ec2-3-34-40-173.ap-northeast-2.compute.amazonaws.com:8080/" + itemClub?.logo)
                .into(logo)
            itemView.setOnClickListener { itemClick(itemClub!!) }
        }

    }
}