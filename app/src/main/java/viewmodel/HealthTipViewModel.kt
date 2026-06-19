package com.bignerdranch.android.healthyhabittracker.viewmodel

import androidx.lifecycle.ViewModel
import com.bignerdranch.android.healthyhabittracker.data.tips.HealthTips
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow


class HealthTipViewModel : ViewModel() {


    private val _tip = MutableStateFlow(
        HealthTips.tips.random()
    )

    val tip = _tip.asStateFlow()

}