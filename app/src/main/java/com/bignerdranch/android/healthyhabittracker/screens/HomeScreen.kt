package com.bignerdranch.android.healthyhabittracker.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(navController: NavController) {
    val habits = listOf(
        "Drink Water - Daily",
        "Exercise - 3x Weekly",
        "Read Book - Nightly",
        "Meditation - Morning"
    )

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Healthy Habit Tracker") }
            )
        }
    ) { padding ->

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(16.dp),

            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Text(
                text = "Track your healthy habits daily!",
                style = MaterialTheme.typography.headlineSmall
            )

            Spacer(modifier = Modifier.height(20.dp))

            Text(
                text = "Today's Habits",
                style = MaterialTheme.typography.titleMedium
            )

            Spacer(modifier = Modifier.height(10.dp))

            LazyColumn(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(220.dp)
            ) {

                items(habits) { habit ->

                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 6.dp)
                    ) {

                        Text(
                            text = habit,
                            modifier = Modifier.padding(16.dp)
                        )
                    }
                }
            }
                Column(
                    modifier = Modifier.padding(16.dp)
                ) {

                    Text("• Drink Water - Daily")
                    Text("• Exercise - 3x Weekly")
                    Text("• Read Book - Nightly")
                }
            }

            Spacer(modifier = Modifier.height(30.dp))

            Button(
                modifier = Modifier.fillMaxWidth(),
                onClick = {
                    navController.navigate("addHabit")
                }
            ) {
                Text("Add Habit")
            }

            Spacer(modifier = Modifier.height(10.dp))

            Button(
                modifier = Modifier.fillMaxWidth(),
                onClick = {
                    navController.navigate("profile")
                }
            ) {
                Text("Profile")
            }
        }
    }