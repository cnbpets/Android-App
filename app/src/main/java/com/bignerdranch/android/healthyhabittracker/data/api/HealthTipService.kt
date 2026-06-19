package com.bignerdranch.android.healthyhabittracker.data.api

import retrofit2.http.GET

interface HealthTipService {

    @GET("advice")
    suspend fun getHealthTip(): HealthTip

}