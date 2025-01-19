package com.example.ere2.ViewModels

import androidx.lifecycle.ViewModel
import com.example.ere2.Components.HeaderProp

class ThisMonthViewModel: ViewModel() {
    val columns = listOf(
        HeaderProp(label = "Name", fieldName = "name"),
        HeaderProp(label = "Age", fieldName = "age"),
        HeaderProp(label = "Email", fieldName = "email")
    )

    val data = listOf(
        mapOf(
            "name" to "John Doe",
            "age" to "28",
            "email" to "john.doe@"
        ),
        mapOf(
            "name" to "Jane Smith",
            "age" to "34",
            "email" to "jane.smith@"
        ),
        mapOf(
            "name" to "Alice Johnson",
            "age" to "22",
            "email" to "alice.johnson@"
        )
    )
}