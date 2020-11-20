package com.example.retrofittest

import com.example.retrofittest.models.urlImageModel
import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {
    @GET("meow")
    fun getFile(): Call<urlImageModel>
}