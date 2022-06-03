package com.example.dt

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.getValue
import androidx.core.content.ContextCompat
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.compose.rememberNavController
import com.example.dt.navigation.SetupNavGraph
import com.example.dt.ui.theme.DtTheme
import com.example.dt.viewmodel.SplashViewModel

import com.google.accompanist.pager.ExperimentalPagerApi
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
@OptIn(ExperimentalPagerApi::class)
class MainActivity : ComponentActivity() {
    @Inject
    lateinit var splashViewModel: SplashViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        installSplashScreen().setKeepOnScreenCondition {
            !splashViewModel.isLoading.value
        }
        window.statusBarColor = ContextCompat.getColor(this, R.color.Gray)

        setContent {
            DtTheme {
                // A surface container using the 'background' color from the theme
                val screen by splashViewModel.startDestination
                val navController = rememberNavController()
                SetupNavGraph(navHostController = navController, startDestination = screen)
            }
        }
    }
}


