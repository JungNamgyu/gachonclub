package com.example.gachon_club.Club

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.gachon_club.Club.Model.Board
import com.example.gachon_club.Network.ServiceControl
import com.example.gachon_club.R
import kotlinx.android.synthetic.main.activity_notice.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ClubNotice : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_notice)
        val id = intent.getLongExtra("id", 0)

        loadData(id)

    }
    private fun loadData(id:Long) {
        val retrofitService = ServiceControl.getInstance()
        retrofitService?.getBoard(id)?.enqueue(object: Callback<Board> {
            override fun onResponse(call: Call<Board>, response: Response<Board>) {
                if (response.isSuccessful) {
                    val body = response.body()
                    body?.let {
                        text_Boardcontent.text = body.content
                    }
                }
            }
            override fun onFailure(call: Call<Board>, t: Throwable) {
                Log.d("this is error",t.message)
            }
        })
    }
}
