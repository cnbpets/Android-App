package com.bignerdranch.android.healthyhabittracker.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.platform.LocalContext
import androidx.room.Room
import com.bignerdranch.android.healthyhabittracker.data.Habit
import com.bignerdranch.android.healthyhabittracker.data.HabitDatabase
import kotlinx.coroutines.launch

@Composable
fun AddHabitScreen() {

    var title by remember { mutableStateOf("") }
    var frequency by remember { mutableStateOf("") }

    val context = LocalContext.current

    val database = Room.databaseBuilder(
        context,
        HabitDatabase::class.java,
        "habit_database"
    ).build()

    val scope = rememberCoroutineScope()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),

        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text("Add Habit")

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
            onClick = {

                scope.launch {

                    val habit = Habit(
                        title = title,
                        frequency = frequency
                    )

                    database.habitDao().insertHabit(habit)

                    title = ""
                    frequency = ""
                }
            }
        ) {
            Text("Save Habit")
        }
    }
}