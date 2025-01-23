package com.example.ere2.Screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.ere2.Components.DisplayInfo
import com.example.ere2.R


@Preview(showBackground = true)
@Composable
fun ProfilePreview() {
    val navController = NavHostController(LocalContext.current)
    ProfileScreen(navController)
}


@Composable
fun ProfileScreen(x0: NavHostController) {
    val data = mapOf<String, String>(
        "Id" to "S201",
        "Name" to "John Doe",
        "Email" to "william.henry@example.com",
        "Class" to "10th",
        "Teacher Name" to "Mr. Smith"
    )



    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.cat),
            contentDescription = stringResource(id = R.string.app_name),
            modifier = Modifier
                .size(100.dp, 100.dp)
                .clip(RoundedCornerShape(100))
        )
        Spacer(modifier = Modifier.size(40.dp))
        DisplayInfo(data = data)
        Spacer(modifier = Modifier.size(40.dp))
        Row(
        ) {
            Button(
                onClick = { x0.navigate("home") }
            ) {
                Text(text = "Back")
            }
            Spacer(modifier = Modifier.size(40.dp))
            Button(
                onClick = {}
            ) {
                Text(text = "Logout")
            }
        }
    }

}