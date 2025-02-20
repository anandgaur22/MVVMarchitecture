package com.example.mvvmarchitecture.api

import com.example.mvvmarchitecture.model.MyData
import retrofit2.http.GET

interface MyApi {
    @GET("todos")  // Replace with your API endpoint
    suspend fun getData(): List<MyData>
}