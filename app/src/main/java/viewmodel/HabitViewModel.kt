package com.bignerdranch.android.healthyhabittracker.viewmodel

import androidx.lifecycle.ViewModel
import com.bignerdranch.android.healthyhabittracker.data.HabitRepository

class HabitViewModel(
    private val repository: HabitRepository
) : ViewModel()