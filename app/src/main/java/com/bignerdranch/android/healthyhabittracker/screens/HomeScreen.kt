package com.bignerdranch.android.healthyhabittracker.screens

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(navController: NavController) {

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Health Habit Tracker") }
            )
        }
    ) { padding ->

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Text("Welcome to your habit tracker!")

            Spacer(modifier = Modifier.height(20.dp))

            Button(onClick = {
                navController.navigate("addHabit")
            }) {
                Text("Add Habit")
            }

            Spacer(modifier = Modifier.height(10.dp))

            Button(onClick = {
                navController.navigate("profile")
            }) {
                Text("Profile")
            }
        }
    }
}