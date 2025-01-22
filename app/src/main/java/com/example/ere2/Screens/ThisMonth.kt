package com.example.ere2.Screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.ere2.Components.DataTable
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
fun ReportHeader() {
    Text(text = "Report of January", fontWeight = FontWeight.Bold, fontSize = 20.sp,
        modifier = Modifier.padding())
}

@Composable
fun ReportFooter(colLabel1: String, colLabel2: String, value1: String, value2: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Column {
            Text(text = colLabel1)
            Spacer(modifier = Modifier.size(height = 10.dp, width = 0.dp))
            Text(text = value1, fontWeight = FontWeight.Bold, fontSize = 20.sp)
        }
        Column {
            Text(text = colLabel2)
            Spacer(modifier = Modifier.size(height = 10.dp, width = 0.dp))
            Text(text = value2, fontWeight = FontWeight.Bold, fontSize = 20.sp)
        }
    }
}

@Composable
fun ThisMonthScreen(navController: NavController, viewModel: ThisMonthViewModel) {
    val navController = rememberNavController()
    val viewModel = ThisMonthViewModel()

    val feedback = rememberSaveable { mutableStateOf("") }
    val parentFeedback = rememberSaveable { mutableStateOf("") }
    val scrollState = rememberScrollState()

    Column(
        modifier = Modifier
            .padding(10.dp, 30.dp, 10.dp, 0.dp)
            .fillMaxSize()
    ) {
        ReportHeader()
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

        DisplayValue(label = "Total Score", value = 491)
        DisplayValue(label = "Absence", value = 4)
        DisplayValue(label = "Granted", value = 3)
        TextArea(
            label = "Feedback",
            value = feedback.value,
            onValueChange = { feedback.value = it }
        )
        TextArea(
            label = "Parent Feedback",
            value = feedback.value,
            onValueChange = { feedback.value = it }
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

@Composable
fun DisplayValue(label: String, value: Any) {
    Row(
        modifier = Modifier
            .padding(0.dp, 8.dp, 0.dp, 8.dp)
            .fillMaxWidth(),
    ) {
        Column {
            Text(text = "$label: ")
        }
        Column {
            Text(text = value.toString())
        }
    }
}

@Composable
fun TextArea(
    label: String,
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    TextField(
        value = value,
        onValueChange = onValueChange,
        label = { Text(label) },
        modifier = modifier
            .fillMaxWidth()
            .height(100.dp)
            .padding(0.dp, 10.dp, 0.dp, 10.dp)
            .border(width = 1.dp, color = Color.Black, shape = RoundedCornerShape(8.dp))
    )
}
