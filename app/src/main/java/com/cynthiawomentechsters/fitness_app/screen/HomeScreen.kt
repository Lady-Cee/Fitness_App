package com.cynthiawomentechsters.fitness_app.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.dp
import androidx.core.content.ContextCompat
import com.cynthiawomentechsters.fitness_app.R
import com.cynthiawomentechsters.fitness_app.component.AlignBodyRow
import com.cynthiawomentechsters.fitness_app.component.FavouriteCollectionsRow
import com.cynthiawomentechsters.fitness_app.component.FitnessSearchBar
import com.cynthiawomentechsters.fitness_app.component.HomePart

@Composable
fun FitnessHomeScreen(modifier: Modifier = Modifier) {

    Surface(
        modifier = modifier.fillMaxSize()
            .fillMaxHeight(),
        color = Color(ContextCompat.getColor(LocalContext.current, R.color.blue))
    ) {
        Column(
            modifier
                .verticalScroll(rememberScrollState())

        ) {
            Spacer(Modifier.height(16.dp))
            FitnessSearchBar(Modifier.padding(horizontal = 16.dp))
            HomePart(R.string.title) {
                AlignBodyRow()
            }
            HomePart(R.string.title_fav) {
                FavouriteCollectionsRow()
            }
            Spacer(Modifier.height(16.dp))

        }
    }
}