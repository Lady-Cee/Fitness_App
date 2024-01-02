

package com.cynthiawomentechsters.fitness_app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.material3.windowsizeclass.calculateWindowSizeClass
import com.cynthiawomentechsters.fitness_app.component.FitnessApp



class MainActivity: ComponentActivity(){
    @OptIn(ExperimentalMaterial3WindowSizeClassApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent{
            val windowSizeClass = calculateWindowSizeClass(this)

            FitnessApp(windowSizeClass)
        }
    }
}


//class MainActivity : ComponentActivity() {
//    @OptIn(ExperimentalMaterial3WindowSizeClassApi::class)
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContent {
//            val windowSizeClass = calculateWindowSizeClass(this)
//            FitnessApp(windowSizeClass)
//            Fitness_AppTheme {
//
//                Surface(
//                    modifier = Modifier.fillMaxSize(),
//                    color = MaterialTheme.colorScheme.background
//                ) {
//                    Column {
//
//                        FitnessPortrait()
//
//                        FitnessLandscape()
////                        FitnessNavigationRail()
//
//
//                    }
//
////                    Column {
////
////                        FitnessSearchBar()
////                        HomePart(R.string.title) {
////                            AlignBodyRow()
////                        }
////                            FavouriteCollectionsRow()
////                        FitnessHomeScreen()
////
////
////                        }
//                    }
//                }
//            }
//        }
//    }












