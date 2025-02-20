package com.example.mvvmarchitecture.repository

import com.example.mvvmarchitecture.api.RetrofitInstance
import com.example.mvvmarchitecture.model.MyData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class MyRepository {

    suspend fun getData(): List<MyData> {
        return withContext(Dispatchers.IO) {
            RetrofitInstance.api.getData()
        }
    }
}