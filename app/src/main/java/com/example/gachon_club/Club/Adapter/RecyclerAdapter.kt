package com.example.gachon_club.Club.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.gachon_club.Club.Model.Club
import com.example.gachon_club.R

class RecyclerAdapter(var clubList: ArrayList<Club>, var context: Context)
    : RecyclerView.Adapter<RecyclerAdapter.ViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return RecyclerAdapter.ViewHolder(
            LayoutInflater.from(context)
            .inflate(R.layout.list_club_view,parent ,false))
    }

    override fun getItemCount(): Int {
        return clubList.count()
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(clubList[position],context)
    }


    class ViewHolder (itemView: View? ) : RecyclerView.ViewHolder(itemView!!){

        val title = itemView?.findViewById<TextView>(R.id.text_Title)
        val info = itemView?.findViewById<TextView>(R.id.text_info)

        fun bind(itemClub : Club? , context: Context){
            title?.text = itemClub?.name
            info?.text = itemClub?.info
        }

    }
}