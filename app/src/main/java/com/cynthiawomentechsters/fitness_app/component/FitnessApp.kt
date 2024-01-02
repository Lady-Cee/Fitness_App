package com.cynthiawomentechsters.fitness_app.component

import androidx.compose.material3.windowsizeclass.WindowSizeClass
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable

@Composable
fun FitnessApp(windowSize: WindowSizeClass){
    when(windowSize.widthSizeClass){
        WindowWidthSizeClass.Compact -> {
            FitnessPortrait()
        }
        WindowWidthSizeClass.Medium -> {
            FitnessLandscape()
        }
    }
}