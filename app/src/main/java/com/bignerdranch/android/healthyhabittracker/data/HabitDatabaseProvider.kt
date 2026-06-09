package com.bignerdranch.android.healthyhabittracker.data

import android.content.Context
import androidx.room.Room

object HabitDatabaseProvider {

    private var INSTANCE: HabitDatabase? = null

    fun getDatabase(context: Context): HabitDatabase {

        return INSTANCE ?: synchronized(this) {

            val instance = Room.databaseBuilder(
                context.applicationContext,
                HabitDatabase::class.java,
                "habit_database"
            )
                .fallbackToDestructiveMigration()
                .build()

            INSTANCE = instance

            instance
        }
    }
}