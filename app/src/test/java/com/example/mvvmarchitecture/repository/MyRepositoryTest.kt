package com.example.mvvmarchitecture.repository

import com.example.mvvmarchitecture.api.MyApi
import com.example.mvvmarchitecture.model.MyData
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.MockitoAnnotations

class MyRepositoryTest {

    @Mock
    private lateinit var api: MyApi
    private lateinit var repository: MyRepository

    @Before
    fun setup() {
        MockitoAnnotations.openMocks(this)
        repository = MyRepository(api)
    }

    @Test
    fun `getData returns data from API successfully`() = runTest {
        // Given
        val mockData = listOf(
            MyData(1, 1, "Test Task 1", false),
            MyData(1, 2, "Test Task 2", true)
        )
        `when`(api.getData()).thenReturn(mockData)

        // When
        val result = repository.getData()

        // Then
        assertEquals(mockData, result)
    }
} 