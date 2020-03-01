package com.example.gachon_club.Club.Network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ServiceControl {

    private val BASE_URL = "http://ec2-52-78-73-194.ap-northeast-2.compute.amazonaws.com:8080/"

    private var instance: WebServerService? = null

    fun getInstance(): WebServerService? {
        if (instance != null)
            return instance
        val builder = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        instance = builder.create(WebServerService::class.java)
        return instance
    }
}