package com.example.dt.util.models

import com.example.dt.R

data class SimpleOnBoarding(
    val image: Int,
    val title: String,
    val desc: String
)

val onBoardingItem= listOf(
    SimpleOnBoarding(
        R.drawable.onboard1,
        "Care About Coding",
        "Tap And Forget :) "
    ),
    SimpleOnBoarding(
        R.drawable.onboard2,
        "Care About Coding",
        "Tap And Forget :) "
    ),
    SimpleOnBoarding(
        R.drawable.onboard3,
        "Care About Coding",
        "Tap And Forget :) "
    )
)