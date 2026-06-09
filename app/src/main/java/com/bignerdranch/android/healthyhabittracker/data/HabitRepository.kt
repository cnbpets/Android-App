package com.bignerdranch.android.healthyhabittracker.data

class HabitRepository(
    private val habitDao: HabitDao
) {

    fun getAllHabits() = habitDao.getAllHabits()

    suspend fun insertHabit(habit: Habit) {
        habitDao.insertHabit(habit)
    }

    suspend fun deleteHabit(habit: Habit) {
        habitDao.deleteHabit(habit)
    }

    suspend fun updateHabit(habit: Habit) {
        habitDao.updateHabit(habit)
    }
}