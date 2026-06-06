package com.bignerdranch.android.healthyhabittracker.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface HabitDao {

    @Insert
    suspend fun insertHabit(habit: Habit)

    @Query("SELECT * FROM habits")
    suspend fun getAllHabits(): List<Habit>

    @Delete
    suspend fun deleteHabit(habit: Habit)
}