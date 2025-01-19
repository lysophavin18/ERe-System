package com.example.ere2.Screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.ere2.Components.HomeButton
import com.example.ere2.Components.HomeButtonGroup
import com.example.ere2.ViewModels.HomeNavigationViewModel

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    val navController = rememberNavController()
    val viewModel = HomeNavigationViewModel() // Create a viewModel instance here
    HomeScreen(navController = navController, viewModel = viewModel)
}

@Composable
fun HomeScreen(navController: NavController, viewModel: HomeNavigationViewModel) {

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center
    ) {
        HomeButtonGroup(navController, viewModel)

    }
}
