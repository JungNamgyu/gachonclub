package com.example.gachon_club.Club.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.gachon_club.Club.Model.Board
import com.example.gachon_club.R

class NoticeRecyclerAdapter (private var boardList: ArrayList<Board>, var context: Context, var itemClick: (Board) -> Unit)
    : RecyclerView.Adapter<NoticeRecyclerAdapter.ViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(context)
                .inflate(R.layout.list_calendar_view,parent, false), itemClick)
    }

    override fun getItemCount(): Int {
        return boardList.count()
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(boardList[position], context)

    }

    inner class ViewHolder (itemView: View?, itemClick: (Board) -> Unit) : RecyclerView.ViewHolder(itemView!!){

        val title = itemView?.findViewById<TextView>(R.id.text_BoardTitle)
        val calendar = itemView?.findViewById<TextView>(R.id.text_BoardCalendar)

        fun bind(itemBoard: Board?, context: Context){
            title?.text = itemBoard?.title
            calendar?.text = itemBoard?.calendar
            itemView.setOnClickListener { itemClick(itemBoard!!) }
        }

    }
}