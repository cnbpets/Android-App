package com.bignerdranch.android.healthyhabittracker

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.navigation.compose.*
import com.bignerdranch.android.healthyhabittracker.screens.AddHabitScreen
import com.bignerdranch.android.healthyhabittracker.screens.HomeScreen
import com.bignerdranch.android.healthyhabittracker.screens.ProfileScreen

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {

            Surface(color = MaterialTheme.colorScheme.background) {

                val navController = rememberNavController()

                NavHost(
                    navController = navController,
                    startDestination = "home"
                ) {

                    composable("home") {
                        HomeScreen(navController)
                    }

                    composable("addHabit") {
                        AddHabitScreen(navController)
                    }

                    composable("profile") {
                        ProfileScreen()
                    }
                }
            }
        }
    }
}