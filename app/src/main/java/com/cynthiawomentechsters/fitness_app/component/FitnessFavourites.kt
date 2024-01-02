package com.cynthiawomentechsters.fitness_app.component

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.cynthiawomentechsters.fitness_app.R


@Composable
fun FavouriteCollections(
    item: FavouriteRow,
    modifier: Modifier = Modifier

) {

    Surface(
        shape = MaterialTheme.shapes.medium,
        color = MaterialTheme.colorScheme.surfaceVariant,
        modifier = modifier
            .padding(8.dp)

    )
    {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .width(255.dp)

        ) {
            Image(
                painter = painterResource(item.drawable),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(80.dp)
                    .padding(start = 8.dp)

            )
            Text(
                text = stringResource(item.text),
                style = MaterialTheme.typography.titleMedium,
                modifier = Modifier.padding(horizontal = 16.dp)
            )
        }
    }
}


private val favouriteCollectionsData = listOf(
    R.drawable.theme1 to R.string.first_theme,
    R.drawable.theme2 to R.string.second_theme,
    R.drawable.theme3 to R.string.third_theme,
    R.drawable.theme4 to R.string.fourth_theme,
    R.drawable.theme5 to R.string.fifth_theme,
    R.drawable.theme6 to R.string.sixth_theme,
).map { FavouriteRow(it.first, it.second) }

data class FavouriteRow(
    @DrawableRes val drawable: Int,
    @StringRes val text: Int
)

@Composable
fun FavouriteCollectionsRow(
    modifier: Modifier = Modifier
) {
    LazyHorizontalGrid(
        rows = GridCells.Fixed(2),
        contentPadding = PaddingValues(horizontal = 4.dp),
        horizontalArrangement = Arrangement.spacedBy(4.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        modifier = modifier
            .height(250.dp)

    ) {
        items(favouriteCollectionsData) { item ->
            FavouriteCollections(item, Modifier.height(120.dp))

        }
    }
}
