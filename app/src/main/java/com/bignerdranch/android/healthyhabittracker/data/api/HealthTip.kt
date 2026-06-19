package com.bignerdranch.android.healthyhabittracker.data.api

data class HealthTip(
    val slip: Slip
)

data class Slip(
    val advice: String
)