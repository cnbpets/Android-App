package com.bignerdranch.android.healthyhabittracker.data.api

import retrofit2.http.GET

interface HealthTipService {

    @GET("tip")
    suspend fun getTip(): HealthTip
}