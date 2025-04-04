package com.example.assignment1

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId" , "SuspiciousIndentation" , "SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // get the button using the id we set on the user Interface
        val timeInput = findViewById<EditText>(R.id.timeInput)
        val submitButton = findViewById<Button>(R.id.submitButton)
        val resetButton = findViewById<Button>(R.id.resetButton)
        val suggestionText = findViewById<TextView>(R.id.suggestionText)

        submitButton.setOnClickListener {
            val timeOfDay = timeInput.text.toString().trim().lowercase()
            val mealSuggestion = getMealSuggestion(timeOfDay)
            suggestionText.text = mealSuggestion
        }

        resetButton.setOnClickListener {
            timeInput.text.clear()
            suggestionText.text = ("Meal suggestion will appear here")
        }
    }


    private fun getMealSuggestion(timeOfDay: String): String {
        return when (timeOfDay) {
            "morning" -> ("Breakfast: Bacon, Eggs and Bread with Coffee")
            "mid-morning" -> "Snack: Fruit Salad with Yogurt and Juice,"
            "afternoon" -> "Lunch: Chicken and Mayo Sandwich,"
            "mid-afternoon" -> "Snack: Slice of cake and Tea"
            "dinner" -> "Dinner: Macaroni and Cheese with Mince "
            "after-dinner" -> "Dessert: Black forest chocolate cake served with custard"
            else -> "Invalid time of day. Please enter Morning, Mid-morning, Afternoon, Mid-afternoon, Dinner or After-dinner."
        }
    }
}




