package com.example.ere2.ViewModels

import android.R.attr.name
import androidx.lifecycle.ViewModel
import androidx.navigation.compose.rememberNavController
import com.example.ere2.dataClass.Util_DataClass.CardItem

class HomeNavigationViewModel : ViewModel() {
    // List of CardItems to display in UI
    val cardItems: List<CardItem> = listOf(
        CardItem(name = "This month", icon =  android.R.drawable.ic_menu_my_calendar, destination = "thisMonth"),
        CardItem(name = "Profile", icon =  android.R.drawable.ic_menu_myplaces, destination = "profile"),
        CardItem(name = "Last months", icon =  android.R.drawable.ic_menu_edit, destination = "lastMonths"),
        CardItem(name = "Supports", icon =  android.R.drawable.ic_menu_call, destination = "supports"),
    )
}
