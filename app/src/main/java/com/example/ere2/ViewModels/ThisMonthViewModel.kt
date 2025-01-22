package com.example.ere2.ViewModels

import androidx.lifecycle.ViewModel
import com.example.ere2.Components.HeaderProp

class ThisMonthViewModel: ViewModel() {
    val columns = listOf(
        HeaderProp(label = "Subject", fieldName = "subject"),
        HeaderProp(label = "Score", fieldName = "score"),
        HeaderProp(label = "Grade", fieldName = "grade")
    )

    val data = listOf(
        mapOf(
            "subject" to "Mathematics",
            "score" to "85",
            "grade" to "A"
        ),
        mapOf(
            "subject" to "Khmer Literature",
            "score" to "90",
            "grade" to "A"
        ),
        mapOf(
            "subject" to "Physics",
            "score" to "78",
            "grade" to "B+"
        ),
        mapOf(
            "subject" to "Chemistry",
            "score" to "82",
            "grade" to "A-"
        ),
        mapOf(
            "subject" to "Biology",
            "score" to "88",
            "grade" to "A"
        ),
        mapOf(
            "subject" to "History",
            "score" to "75",
            "grade" to "B"
        ),
        mapOf(
            "subject" to "Chemistry",
            "score" to "82",
            "grade" to "A-"
        ),
        mapOf(
            "subject" to "Biology",
            "score" to "88",
            "grade" to "A"
        ),
        mapOf(
            "subject" to "History",
            "score" to "75",
            "grade" to "B"
        ),
        mapOf(
            "subject" to "Chemistry",
            "score" to "82",
            "grade" to "A-"
        ),
        mapOf(
            "subject" to "Biology",
            "score" to "88",
            "grade" to "A"
        ),
        mapOf(
            "subject" to "History",
            "score" to "75",
            "grade" to "B"
        ),
        mapOf(
            "subject" to "Chemistry",
            "score" to "82",
            "grade" to "A-"
        ),
        mapOf(
            "subject" to "Biology",
            "score" to "88",
            "grade" to "A"
        ),

    )

}