package com.example.gachon_club.Club

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.gachon_club.Club.Adapter.BoardRecyclerAdapter
import com.example.gachon_club.Club.Model.Board
import com.example.gachon_club.Network.ServiceControl
import com.example.gachon_club.R
import kotlinx.android.synthetic.main.activity_main_notice.*
import org.jetbrains.anko.startActivity
import retrofit2.Call
import retrofit2.Response
import retrofit2.Callback

class MainNotice : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_notice)

        loadData()
    }

    private fun setAdapter(boardList: ArrayList<Board>){
        val mAdapter = BoardRecyclerAdapter(boardList,this){
            startActivity<ClubNotice>(
                "id" to it._id
            )
        }
        recyler_view.adapter = mAdapter
        recyler_view.layoutManager = LinearLayoutManager(this)
    }

    private fun loadData() {
        val retrofitService = ServiceControl.getInstance()
        retrofitService?.getAllBoards("공지사항")?.enqueue(object: Callback<List<Board>> {
            override fun onResponse(call: Call<List<Board>>, response: Response<List<Board>>) {
                if (response.isSuccessful) {
                    val body = response.body()
                    body?.let {
                        setAdapter(it as ArrayList<Board>)
                    }
                }
            }
            override fun onFailure(call: Call<List<Board>>, t: Throwable) {
                Log.d("this is error",t.message)
            }
        })
    }
}