package com.example.gachon_club.Network

import com.example.gachon_club.Account.Model.User
import com.example.gachon_club.Club.Model.Club
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path


interface WebServerService {

    ///////////////////////////////////////////////////////////////////
    // All User
    @GET("user/getAll")
    fun getAllUsers(): Call<List<User>>

    // User
    @GET("user/get/{id}")
    fun getUser(@Path("id")id: String): Call<User>

    // User Signup
    @POST("user/add")
    fun addUser(@Body body:User): Call<User>

    ///////////////////////////////////////////////////////////////////
    // All Club
    @GET("club/getAll")
    fun getAllClubs(): Call<List<Club>>

    // Club
    @GET("club/get/{id}")
    fun getClub(@Path("id") id: Long): Call<Club>
}