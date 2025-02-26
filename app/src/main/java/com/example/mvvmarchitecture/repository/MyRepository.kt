package com.example.mvvmarchitecture.repository

import com.example.mvvmarchitecture.api.MyApi
import com.example.mvvmarchitecture.api.RetrofitInstance
import com.example.mvvmarchitecture.model.MyData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

open class MyRepository(
    private val api: MyApi = RetrofitInstance.api
) {

    open suspend fun getData(): List<MyData> {
        return withContext(Dispatchers.IO) {
            api.getData()
        }
    }
}