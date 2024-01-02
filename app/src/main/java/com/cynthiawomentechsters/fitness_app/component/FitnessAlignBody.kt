package com.cynthiawomentechsters.fitness_app.component

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.cynthiawomentechsters.fitness_app.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AlignBodyFit(

    item: DrawableRow,
    modifier: Modifier = Modifier
) {


    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .padding(top = 20.dp)
            .padding(horizontal = 4.dp)


    ) {
        Image(
            painter = painterResource(item.drawable),
            contentDescription = null,
            contentScale = ContentScale.FillBounds,
            modifier = modifier
                .size(100.dp)
                .clip(CircleShape)

        )
        Text(
            text = stringResource(item.text),
            modifier = Modifier
                .paddingFromBaseline(top = 24.dp, bottom = 8.dp),
            style = MaterialTheme.typography.bodyLarge
        )
    }
}

private val alignBodyFitData = listOf(
    R.drawable.fit1 to R.string.first_pix,
    R.drawable.fit2 to R.string.second_pix,
    R.drawable.fit3 to R.string.third_pix,
    R.drawable.fit4 to R.string.fourth_pix,
    R.drawable.fit5 to R.string.fifth_pix,
    R.drawable.fit6 to R.string.sixth_pix,
    R.drawable.fit7 to R.string.seventh_pix,
    R.drawable.fit8 to R.string.eight_pix,
).map { DrawableRow(it.first, it.second) }

data class DrawableRow(
    @DrawableRes val drawable: Int,
    @StringRes val text: Int
)

@Composable
fun AlignBodyRow(
    modifier: Modifier = Modifier
) {
    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(4.dp),
        contentPadding = PaddingValues(horizontal = 8.dp),
        modifier = modifier
    ) {
        items(alignBodyFitData) { item ->
            AlignBodyFit(item)
        }
    }
}