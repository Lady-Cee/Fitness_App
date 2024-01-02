package com.cynthiawomentechsters.fitness_app.component

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.cynthiawomentechsters.fitness_app.FitnessBottomNav
import com.cynthiawomentechsters.fitness_app.FitnessNavigationRail

import com.cynthiawomentechsters.fitness_app.screen.FitnessHomeScreen
import com.cynthiawomentechsters.fitness_app.ui.theme.Fitness_AppTheme

@Composable
fun FitnessPortrait(){
    Fitness_AppTheme{
        Scaffold(
            bottomBar = { FitnessBottomNav() },
        ) { padding ->
            FitnessHomeScreen(Modifier.padding(padding))
        }
    }
}

@Composable
fun FitnessLandscape(){
    Fitness_AppTheme {
        Surface (color = MaterialTheme.colorScheme.background){
            Row{
                FitnessNavigationRail()
                FitnessHomeScreen()
            }
        }

    }
}