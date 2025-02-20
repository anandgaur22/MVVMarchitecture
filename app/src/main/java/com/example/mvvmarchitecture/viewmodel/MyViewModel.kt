package com.example.mvvmarchitecture.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mvvmarchitecture.model.MyData
import com.example.mvvmarchitecture.repository.MyRepository
import kotlinx.coroutines.launch

class MyViewModel : ViewModel() {

    private val repository = MyRepository()
    val data = mutableStateOf<List<MyData>>(emptyList())
    val errorMessage = mutableStateOf<String?>(null)
    val isLoading = mutableStateOf(false)

    init {
        fetchData()
    }

    private fun fetchData() {
        viewModelScope.launch {
            isLoading.value = true
            try {
                val result = repository.getData()
                data.value = result
                errorMessage.value = null
            } catch (e: Exception) {
                errorMessage.value = "Error fetching data: ${e.message}"
            } finally {
                isLoading.value = false
            }
        }
    }
}