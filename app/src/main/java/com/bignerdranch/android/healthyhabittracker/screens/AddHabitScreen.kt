package com.bignerdranch.android.healthyhabittracker.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.bignerdranch.android.healthyhabittracker.data.SharedHabitData

@Composable
fun AddHabitScreen(navController: NavController) {

    var title by remember { mutableStateOf("") }
    var frequency by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),

        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(
            text = "Add New Habit",
            style = MaterialTheme.typography.headlineSmall
        )

        Spacer(modifier = Modifier.height(20.dp))

        OutlinedTextField(
            value = title,
            onValueChange = { title = it },
            label = { Text("Habit Name") }
        )

        Spacer(modifier = Modifier.height(10.dp))

        OutlinedTextField(
            value = frequency,
            onValueChange = { frequency = it },
            label = { Text("Frequency") }
        )

        Spacer(modifier = Modifier.height(20.dp))

        Button(
            modifier = Modifier.fillMaxWidth(),
            onClick = {

                if (title.isNotBlank() && frequency.isNotBlank()) {

                    SharedHabitData.habits.add(
                        "$title - $frequency"
                    )

                    navController.navigate("home")
                }
            }
        ) {
            Text("Save Habit")
        }
    }
}