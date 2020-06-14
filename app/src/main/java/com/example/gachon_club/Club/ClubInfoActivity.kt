package com.example.gachon_club.Club

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.bumptech.glide.Glide
import com.example.gachon_club.Club.Model.Club
import com.example.gachon_club.Network.ServiceControl
import com.example.gachon_club.R
import kotlinx.android.synthetic.main.activity_club_info.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ClubInfoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_club_info)

        val id = intent.getLongExtra("id", 0)

        loadData(id)
    }

    private fun setAdapter(club: Club){
        textViewClubInfo.text = club.data
        Glide.with(this)
            .load(club.data_url)
            .into(imageViewClubInfo)
    }

    private fun loadData(index : Long) {
        val retrofitService = ServiceControl.getInstance()

        retrofitService?.getClub(index)?.enqueue(object: Callback<Club> {
            override fun onResponse(call: Call<Club>, response: Response<Club>) {
                if (response.isSuccessful) {
                    val body = response.body()
                    body?.let {
                        setAdapter(it as Club)
                    }
                }
            }
            override fun onFailure(call: Call<Club>, t: Throwable) {
                Log.d("this is error",t.message)
            }
        })
    }
}
