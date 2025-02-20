package com.example.mvvmarchitecture.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Done
import androidx.compose.material3.*
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.mvvmarchitecture.model.MyData
import com.example.mvvmarchitecture.viewmodel.MyViewModel
import androidx.compose.foundation.clickable
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material.icons.filled.Info


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyScreen() {
    val viewModel: MyViewModel = viewModel()
    val dataList by viewModel.data
    val errorMessage by viewModel.errorMessage
    val isLoading by viewModel.isLoading

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("My Tasks") },
                colors = TopAppBarDefaults.smallTopAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primary,  // Changed to primary
                    titleContentColor = MaterialTheme.colorScheme.onPrimary, // Text color on primary
                )
            )
        },
        containerColor = MaterialTheme.colorScheme.background
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {

            if (isLoading) {
                // Show loading indicator
                Column(
                    modifier = Modifier.fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    CircularProgressIndicator()
                }
            } else if (errorMessage != null) {
                // Show error message
                Text(text = "Error: $errorMessage")
            } else {
                // Show the data
                LazyColumn(
                    contentPadding = PaddingValues(16.dp)
                ) {
                    items(dataList) { item ->
                        MyItemCard(item = item)
                        Spacer(modifier = Modifier.height(8.dp))
                    }
                }
            }
        }
    }
}

@Composable
fun MyItemCard(item: MyData) {
    Card(
        modifier = Modifier
            .padding(horizontal = 8.dp, vertical = 4.dp)
            .fillMaxWidth()
            .clickable {
                // Optional: Handle card click
            },
        elevation = CardDefaults.cardElevation(
            defaultElevation = 3.dp // Slight elevation
        ),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surfaceVariant, // Softer card color
        ),
        shape = RoundedCornerShape(12.dp)
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = item.title,
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.SemiBold,
                    color = MaterialTheme.colorScheme.onSurface,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis,
                    modifier = Modifier.weight(1f),
                    textAlign = TextAlign.Start
                )

                Spacer(modifier = Modifier.width(8.dp))

                // Use an Info icon instead of a checkmark
                val icon: ImageVector = if (item.completed) Icons.Filled.Done else Icons.Filled.Info
                val tint = if (item.completed) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.secondary

                Icon(
                    imageVector = icon,
                    contentDescription = if (item.completed) "Completed" else "Information",
                    tint = tint,
                    modifier = Modifier.size(24.dp)
                )
            }

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = "User ID: ${item.userId} - Task ID: ${item.id}",  // Combined info
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.7f)
            )
        }
    }
}


@Preview(showBackground = true)
@Composable
fun MyItemCardPreview3() {
    MaterialTheme {
        Surface {
            MyItemCard(
                item = MyData(
                    userId = 23,
                    id = 156,
                    title = "Refactor codebase for better maintainability",
                    completed = false
                )
            )
        }
    }
}