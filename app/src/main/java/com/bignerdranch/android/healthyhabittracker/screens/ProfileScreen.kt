package com.bignerdranch.android.healthyhabittracker.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun ProfileScreen() {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),

        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Text(
            text = "Profile",
            style = MaterialTheme.typography.headlineMedium
        )

        Spacer(modifier = Modifier.height(20.dp))

        Card(
            modifier = Modifier.fillMaxWidth()
        ) {

            Column(
                modifier = Modifier.padding(16.dp)
            ) {

                Text(
                    text = "Healthy Habit Tracker",
                    style = MaterialTheme.typography.titleLarge
                )

                Spacer(modifier = Modifier.height(10.dp))

                Text("Habits Tracked: 4")
                Text("Current Streak: 5 Days")
                Text("Weekly Goal: Stay Consistent")

                Text(
                    text = "Database Status: Room database integration in progress."
                )
            }
        }

        Spacer(modifier = Modifier.height(30.dp))

        Text(
            text = "Built using Kotlin and Jetpack Compose",
            style = MaterialTheme.typography.bodyMedium
        )
    }
}