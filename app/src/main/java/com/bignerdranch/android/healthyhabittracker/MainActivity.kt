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
import androidx.lifecycle.viewmodel.compose.viewModel
import com.bignerdranch.android.healthyhabittracker.data.HabitDatabaseProvider
import com.bignerdranch.android.healthyhabittracker.data.HabitRepository
import com.bignerdranch.android.healthyhabittracker.viewmodel.HabitViewModel
import com.bignerdranch.android.healthyhabittracker.viewmodel.HabitViewModelFactory
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {

            Surface(color = MaterialTheme.colorScheme.background) {

                val navController = rememberNavController()

                val database =
                    HabitDatabaseProvider.getDatabase(applicationContext)

                val repository =
                    HabitRepository(database.habitDao())

                val habitViewModel: HabitViewModel = viewModel(
                    factory = HabitViewModelFactory(repository)
                )

                NavHost(
                    navController = navController,
                    startDestination = "home"
                ) {

                    composable("home") {
                        HomeScreen(
                            navController = navController,
                            viewModel = habitViewModel
                        )
                    }

                    composable("addHabit") {
                        AddHabitScreen(
                            navController = navController,
                            viewModel = habitViewModel
                        )
                    }

                    composable("profile") {
                        ProfileScreen()
                    }
                }
            }
        }
    }
}