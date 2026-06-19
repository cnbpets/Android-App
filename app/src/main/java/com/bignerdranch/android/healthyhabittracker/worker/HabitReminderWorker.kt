package com.bignerdranch.android.healthyhabittracker.worker

import android.content.Context
import androidx.work.Worker
import androidx.work.WorkerParameters

class HabitReminderWorker(
    appContext: Context,
    workerParams: WorkerParameters

) : Worker(appContext, workerParams) {


    override fun doWork(): Result {

        println("Reminder: Complete today's habits!")

        return Result.success()
    }
}