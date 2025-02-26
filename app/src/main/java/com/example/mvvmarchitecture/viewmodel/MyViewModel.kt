package com.example.mvvmarchitecture.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mvvmarchitecture.model.MyData
import com.example.mvvmarchitecture.repository.MyRepository
import kotlinx.coroutines.launch

class MyViewModel(
    private val repository: MyRepository = MyRepository()
) : ViewModel() {

    val data = mutableStateOf<List<MyData>>(emptyList())
    val errorMessage = mutableStateOf<String?>(null)
    val isLoading = mutableStateOf(false)

    init {
        fetchData()
    }

    fun fetchData() {
        viewModelScope.launch {
            isLoading.value = true
            try {
                val result = repository.getData()
                data.value = result
                errorMessage.value = null
            } catch (e: Exception) {
                data.value = emptyList()
                errorMessage.value = "Error fetching data: ${e.message}"
            } finally {
                isLoading.value = false
            }
        }
    }
}