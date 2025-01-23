package com.example.ere2.Screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.ere2.Components.DisplayInfo

@Preview(showBackground = true)
@Composable
fun SupportPreview() {
    val navController = NavHostController(LocalContext.current)
    SupportScreen(navController)
}

@Composable
fun SupportScreen(x0: NavHostController) {
    val data = mapOf<String, String>(
        "Director" to "Chay Chamrong",
        "Class holder" to "John Doe",
        "IT support" to "it.support@sala.com",
        "Moderator" to "Chea Sokha",
        "Front desk" to "023909121"
    )

    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = "Hotlines", textAlign = TextAlign.Start, fontSize = 17.sp, fontWeight = androidx.compose.ui.text.font.FontWeight.Bold)
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Spacer(modifier = Modifier.size(40.dp))
            DisplayInfo(data = data)
            Spacer(modifier = Modifier.size(60.dp))
            Column (
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(text = "More Information", fontSize = 17.sp, fontWeight = androidx.compose.ui.text.font.FontWeight.Bold)
                Spacer(modifier = Modifier.size(10.dp))
                Text(text = "support@sala.com")
            }
        }
    }

}