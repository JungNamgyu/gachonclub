package com.example.gachon_club.Club.Network

import com.example.gachon_club.Club.Model.Club
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path


interface WebServerService {
    // Club
    @GET("club/getAll")
    fun getAllClubs(): Call<List<Club>>

    // ClubInfo
    @GET("club/get/{id}")
    fun getClub(@Path("id") id: Long): Call<Club>
}