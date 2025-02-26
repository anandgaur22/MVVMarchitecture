package com.example.mvvmarchitecture.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.mvvmarchitecture.model.MyData
import com.example.mvvmarchitecture.repository.MyRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.kotlin.mock
import org.mockito.kotlin.whenever

@ExperimentalCoroutinesApi
class MyViewModelTest {

    @get:Rule
    val instantExecutorRule = InstantTaskExecutorRule()

    private val testDispatcher = StandardTestDispatcher()
    private val repository: MyRepository = mock()
    private lateinit var viewModel: MyViewModel

    @Before
    fun setup() {
        Dispatchers.setMain(testDispatcher)
        viewModel = MyViewModel(repository)
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }

    @Test
    fun `fetchData success updates state correctly`() = runTest {
        // Given
        val mockData = listOf(
            MyData(1, 1, "Test Task 1", false),
            MyData(1, 2, "Test Task 2", true)
        )
        whenever(repository.getData()).thenReturn(mockData)

        // When
        viewModel.fetchData()
        testDispatcher.scheduler.advanceUntilIdle()

        // Then
        assertEquals(mockData, viewModel.data.value)
        assertEquals(null, viewModel.errorMessage.value)
        assertEquals(false, viewModel.isLoading.value)
    }

    @Test
    fun `fetchData error updates error state`() = runTest {
        // Given
        val errorMessage = "Network error"
        whenever(repository.getData()).thenThrow(RuntimeException(errorMessage))

        // When
        viewModel.fetchData()
        testDispatcher.scheduler.advanceUntilIdle()

        // Then
        assertEquals(emptyList<MyData>(), viewModel.data.value)
        assertEquals("Error fetching data: $errorMessage", viewModel.errorMessage.value)
        assertEquals(false, viewModel.isLoading.value)
    }
} 