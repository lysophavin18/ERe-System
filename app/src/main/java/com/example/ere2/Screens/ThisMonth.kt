package com.example.ere2.Screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.ere2.Components.DataTable
import com.example.ere2.Components.DisplayValue
import com.example.ere2.Components.ReportFooter
import com.example.ere2.Components.ReportHeader
import com.example.ere2.Components.TextArea
import com.example.ere2.R
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

    val feedback = rememberSaveable { mutableStateOf("") }
    val parentFeedback = rememberSaveable { mutableStateOf("") }
    val scrollState = rememberScrollState()
    val screenScrollState = rememberScrollState()


    Column(
        modifier = Modifier
            .padding(16.dp, 30.dp, 16.dp, 0.dp)
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
        Spacer(modifier = Modifier.size(height = 20.dp, width = 0.dp))
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .height(300.dp)
                .verticalScroll(scrollState), // Enable scrolling
            verticalArrangement = Arrangement.Center,
        )
        {
            DataTable(columns = viewModel.columns, data = viewModel.data)
        }
        Spacer(modifier = Modifier.size(height = 20.dp, width = 0.dp))

        Row(
            modifier = Modifier
                .wrapContentSize()
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            DisplayValue(label = "Total Score", value = 491)
            DisplayValue(label = "Absence", value = 4)
        }
        Row(
            modifier = Modifier
                .wrapContentSize()
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            DisplayValue(label = "Overall Grade", value = "B+")
            DisplayValue(label = "Granted permission", value = 3)
        }

        Spacer(modifier = Modifier.size(height = 12.dp, width = 0.dp))

        TextArea(
            label = "Feedback",
            value = feedback.value,
            onValueChange = { feedback.value = it }
        )
        Spacer(modifier = Modifier.size(height = 12.dp, width = 0.dp))
        TextArea(
            label = "Parent Feedback",
            value = parentFeedback.value,
            onValueChange = { parentFeedback.value = it }
        )
        Image(
            painter = painterResource(id = R.drawable.sample_signature),
            contentDescription = stringResource(id = R.string.app_name),
            modifier = Modifier
                .size(100.dp, 100.dp)
        )
        ReportFooter(colLabel1 = "School Director", colLabel2 = "Issued Date", value1 = "ChayChomrong", value2 = "12/01/2025")
    }

}

