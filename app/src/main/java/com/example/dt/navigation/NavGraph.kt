package com.example.dt.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.dt.screens.HomeScreen
import com.example.dt.screens.SiteContests

import com.example.dt.screens.WelcomeScreen

@Composable
fun SetupNavGraph(
    navHostController: NavHostController,
    startDestination:String
){
    NavHost(
        navController = navHostController,
        startDestination = startDestination
    ){
        composable(route = Screen.Welcome.route){
            WelcomeScreen(navController=navHostController)
        }
        composable(route = Screen.Home.route){
          HomeScreen(navHostController = navHostController)
        }
        composable(route = Screen.SiteContestes.route){
                  SiteContests(navHostController = navHostController)
        }
    }
}