package com.example.ere2.Screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.ere2.Components.ReportHeader


@Preview(showBackground = true)
@Composable
fun LastMonthsScreenPreview() {
    val navController = NavController(LocalContext.current)
    LastMonthsScreen(navController)
}

@Composable
fun LastMonthsScreen(navController: NavController) {

    val monthes = listOf(
        "January",
        "February",
        "March",
        "April",
        "May",
        "June",
        "July",
        "August",
        "September",
        "October",
        "November",
        "December"
    );

    Column(
        modifier = Modifier
            .verticalScroll(rememberScrollState())
            .padding(16.dp, 40.dp, 16.dp, 0.dp)
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Row(
            Modifier
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            TextButton(
                onClick = { navController.navigate("home") },
            ) {
                Text("Back")
            }
            Spacer(modifier = Modifier.size(width = 40.dp, height = 0.dp))
            ReportHeader()
        }
        monthes.forEach { item ->
            Spacer(modifier = Modifier.size(height = 10.dp, width = 0.dp))
            Button(
                onClick = { navController.navigate("thisMonth") },
                modifier = Modifier
                    .height(40.dp)
                    .fillMaxWidth()
            ) {
                Text(text = item)
            }
        }
        Spacer(modifier = Modifier.size(height = 10.dp, width = 0.dp))
    }
}