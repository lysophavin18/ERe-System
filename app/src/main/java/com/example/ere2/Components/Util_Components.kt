package com.example.ere2.Components

import android.R.attr.name
import android.R.attr.text
import android.provider.ContactsContract
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.text.BasicText
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.ere2.ViewModels.HomeNavigationViewModel
import com.example.ere2.ViewModels.ThisMonthViewModel
import java.util.Objects

@Composable
fun HomeButton(navController: NavController, name: String, icon:Int, destination: String) {
    ElevatedCard(
        onClick = { navController.navigate(destination) },
        modifier = Modifier.size(100.dp),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 6.dp
        ),
    ) {
        Box(
            modifier = Modifier.fillMaxSize(), // Ensures the Box fills the card
            contentAlignment = Alignment.Center // Centers the content inside the Box
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally, // Centers content horizontally
                verticalArrangement = Arrangement.Center // Centers content vertically
            ) {
                Icon(
                    painter = painterResource(id = icon), // Load the icon using painterResource
                    contentDescription = null, // You can provide a content description for accessibility
                    modifier = Modifier.size(24.dp) // Set the size of the icon
                )
                Spacer(modifier = Modifier.height(8.dp)) // Adds space between the icon and text
                Text(
                    text = name,
                    textAlign = TextAlign.Center // Centers the text horizontally within its bounds
                )
            }
        }
    }
}

@Composable
fun HomeButtonGroup(navController: NavController, viewModel: HomeNavigationViewModel) {
    val cardItems = viewModel.cardItems
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        modifier = Modifier.padding(16.dp)
    ) {
        items(cardItems.size) { index ->
            val item = cardItems[index]
            HomeButton(
                navController = navController,
                name = item.name,
                icon = item.icon,
                destination = item.destination
            )
        }
    }
}

@Composable
fun DataTable(columns: List<HeaderProp>, data: List<Map<String, String>>) {
    // Header row
    Column(modifier = Modifier
        .padding(16.dp)
        .fillMaxWidth())
    {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            // Iterate over the columns to create the header
            columns.forEach { column ->
                Text(
                    text = column.label,
                    fontWeight = androidx.compose.ui.text.font.FontWeight.Bold,
                    modifier = Modifier
                        .padding(8.dp)
                        .weight(1f) // Ensure each column takes equal space
                )
            }
        }

        // Data rows
        LazyColumn(modifier = Modifier.fillMaxWidth()) {
            itemsIndexed(data) { _, row ->
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    // Iterate over columns to align each data cell with its respective column header
                    columns.forEach { column ->
                        val fieldName = column.fieldName
                        val value = row[fieldName].orEmpty() // orEmpty() handles null values
                        Text(
                            text = value,
                            modifier = Modifier
                                .padding(8.dp)
                                .weight(1f) // Ensure each column in the data row matches the header
                        )
                    }
                }
            }
        }
    }
}

data class HeaderProp(val label: String, val fieldName: String)



