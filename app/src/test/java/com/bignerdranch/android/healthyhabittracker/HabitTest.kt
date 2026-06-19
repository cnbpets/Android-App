package com.bignerdranch.android.healthyhabittracker

import com.bignerdranch.android.healthyhabittracker.data.Habit
import org.junit.Assert.assertEquals
import org.junit.Test


class HabitTest {


    @Test
    fun habit_creation_test() {

        val habit = Habit(
            title = "Drink Water",
            frequency = "Daily"
        )


        assertEquals(
            "Drink Water",
            habit.title
        )


        assertEquals(
            "Daily",
            habit.frequency
        )


        assertEquals(
            false,
            habit.completed
        )
    }
}