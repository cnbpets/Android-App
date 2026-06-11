package com.bignerdranch.android.healthyhabittracker.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bignerdranch.android.healthyhabittracker.data.Habit
import com.bignerdranch.android.healthyhabittracker.data.HabitRepository
import kotlinx.coroutines.launch
import kotlinx.coroutines.flow.Flow

class HabitViewModel(
    private val repository: HabitRepository
) : ViewModel() {

    val habits: Flow<List<Habit>> = repository.getAllHabits()

    fun insertHabit(
        title: String,
        frequency: String
    ) {

        viewModelScope.launch {

            repository.insertHabit(
                Habit(
                    title = title,
                    frequency = frequency
                )
            )
        }
    }

    fun deleteHabit(habit: Habit) {

        viewModelScope.launch {
            repository.deleteHabit(habit)
        }
    }
}