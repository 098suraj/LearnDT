package com.example.dt.navigation

sealed class Screen(val route:String){
    object Welcome:Screen(route = "welcome_screen")
    object Home:Screen(route = "home_screen")
    object SiteContestes:Screen(route = "site_contests")
}