package com.example.ere2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.ere2.Screens.HomeScreen
import com.example.ere2.Screens.ProfileScreen
import com.example.ere2.Screens.SupportScreen
import com.example.ere2.Screens.ThisMonthScreen
import com.example.ere2.ViewModels.HomeNavigationViewModel
import com.example.ere2.ViewModels.ThisMonthViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val navController = rememberNavController()
            AppNavGraph(navController = navController)
        }
    }
}

@Composable
private fun MainActivity.AppNavGraph(navController: NavHostController) {
    val homeViewModel = HomeNavigationViewModel() // Create a viewModel instance here
    val thisMonthViewModel = ThisMonthViewModel() // Create a viewModel instance here
    NavHost(navController = navController, startDestination = "home") {
        composable("home") { HomeScreen(navController, homeViewModel) }
        composable("thisMonth") { ThisMonthScreen(navController, thisMonthViewModel) }
        composable("profile") { ProfileScreen(navController) }
        composable("supports") { SupportScreen(navController) }
    }
}

