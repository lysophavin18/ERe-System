package com.example.ere2.Screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.ere2.Components.DataTable
import com.example.ere2.Components.HeaderProp
import com.example.ere2.ViewModels.HomeNavigationViewModel
import com.example.ere2.ViewModels.ThisMonthViewModel

@Preview(showBackground = true)
@Composable
fun ThisMonthPreview() {
    val navController = rememberNavController()
    val viewModel = ThisMonthViewModel() // Create a viewModel instance here
    ThisMonthScreen(navController = navController, viewModel = viewModel)
}


@Composable
fun ThisMonthScreen(navController: NavController, viewModel: ThisMonthViewModel) {
    val navController = rememberNavController()
    val viewModel = ThisMonthViewModel()
    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp),
        verticalArrangement = Arrangement.Center,
    ) {
        Text(text = "Report of January", fontWeight = FontWeight.Bold)
        Spacer(modifier = Modifier.size(height = 30.dp, width = 0.dp))
        DataTable(columns = viewModel.columns, data = viewModel.data)
    }
}
