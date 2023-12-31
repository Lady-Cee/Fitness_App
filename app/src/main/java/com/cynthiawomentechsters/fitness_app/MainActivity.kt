

package com.cynthiawomentechsters.fitness_app

import android.graphics.drawable.Drawable
import android.graphics.drawable.Icon
import android.graphics.drawable.shapes.OvalShape
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.graphics.Color
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationRail
import androidx.compose.material3.NavigationRailItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.material3.windowsizeclass.WindowSizeClass
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.material3.windowsizeclass.calculateWindowSizeClass

import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import com.cynthiawomentechsters.fitness_app.ui.theme.Fitness_AppTheme
import androidx.compose.ui.platform.LocalContext
import androidx.core.content.ContextCompat

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3WindowSizeClassApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val windowSizeClass = calculateWindowSizeClass(this)
            FitnessApp(windowSizeClass)
            Fitness_AppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Column {

                        FitnessPortrait()
                        FitnessNavigationRail()
                        FitnessLandscape()


                    }

//                    Column {
//
//                        FitnessSearchBar()
//                        HomePart(R.string.title) {
//                            AlignBodyRow()
//                        }
//                            FavouriteCollectionsRow()
//                        FitnessHomeScreen()
//
//
//                        }
                    }
                }
            }
        }
    }


    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun FitnessSearchBar(
        modifier: Modifier = Modifier
            .padding(horizontal = 16.dp)
            .padding(top = 12.dp)
    ) {

        TextField(
            value = "",
            onValueChange = {},
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Search,
                    contentDescription = null
                )
            },
            colors = TextFieldDefaults.textFieldColors(
                unfocusedIndicatorColor = MaterialTheme.colorScheme.surface,
                focusedIndicatorColor = MaterialTheme.colorScheme.surface
            ),
            placeholder = {
                Text(stringResource(R.string.placeholder))
            },
            modifier = modifier
                .fillMaxWidth()
                .heightIn(min = 56.dp)
        )
    }

    @Preview(showBackground = true)
    @Composable
    fun FitnessSearchBarPreview() {
        Fitness_AppTheme {
            FitnessSearchBar()
        }
        HomePart(R.string.title) {
            AlignBodyRow()
        }
        FavouriteCollectionsRow()
        FitnessHomeScreen()

    }

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
            verticalArrangement = Arrangement.spacedBy(4.dp),
            modifier = modifier
                .height(25gi0.dp)

        ) {
            items(favouriteCollectionsData) { item ->
                FavouriteCollections(item)

            }
        }
    }

    @Composable
    fun HomePart(
        @StringRes title: Int,
        modifier: Modifier = Modifier,
        content: @Composable () -> Unit
    ) {
        Column(modifier) {
            Text(
                text = stringResource(title),
                style = MaterialTheme.typography.titleMedium,
                modifier = Modifier
                    .paddingFromBaseline(top = 50.dp, bottom = 16.dp)
                    .padding(horizontal = 16.dp)
            )
            content()
        }

    }
@Composable
fun FitnessHomeScreen(modifier: Modifier = Modifier) {
    Surface(
        modifier = modifier.fillMaxSize(),
        color = Color(ContextCompat.getColor(LocalContext.current, R.color.blue))
    ) {
        Column(
            modifier
                .verticalScroll(rememberScrollState())
        ) {
            Spacer(Modifier.height(16.dp))
            FitnessSearchBar(Modifier.padding(horizontal = 16.dp))
            HomePart(title = R.string.title) {
                AlignBodyRow()
            }
            HomePart(title = R.string.title_fav) {
                FavouriteCollectionsRow()
            }
            Spacer(Modifier.height(16.dp))
        }
    }
}
@Composable
fun FitnessBottomNav(modifier: Modifier = Modifier){
    NavigationBar(
        containerColor = MaterialTheme.colorScheme.surfaceVariant,
        modifier = modifier
    ) {
        NavigationBarItem(
            icon = {
                Icon(
                    imageVector = Icons.Default.Home,
                    contentDescription = null,
                )
            },
            label = {
                Text(
                    text = stringResource(R.string.bottom_nav_home)
                )
            },
            selected = true,
            onClick = {}
                )
        NavigationBarItem(
            icon = {
                Icon(
                    imageVector = Icons.Default.AccountCircle,
                    contentDescription = null
                )
            },
            label ={
                Text(
                    text = stringResource(R.string.bottom_nav_profile)
                )
            },
            selected = false,
            onClick = {},
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FitnessPortrait(){
    Fitness_AppTheme{
        Scaffold(
            bottomBar = { FitnessBottomNav()},
        ) {padding ->
            FitnessHomeScreen(Modifier.padding(padding))

        }
    }
}

@Composable
private fun FitnessNavigationRail(modifier: Modifier = Modifier){
    NavigationRail(
        modifier = modifier.padding(start = 8.dp, end = 8.dp),
        containerColor = MaterialTheme.colorScheme.background,
    ) {
    Column (
        modifier = modifier.fillMaxHeight(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        NavigationRailItem(
            icon = {
             Icon(
                 imageVector = Icons.Default.Home,
                 contentDescription = null,
                 tint = Color.White
             )
            },
            label = {
                Text(stringResource(R.string.bottom_nav_home))
            },
            selected = true,
            onClick = {}
        )
        Spacer(modifier = Modifier.height(4.dp))
        NavigationRailItem(
            icon = {
                Icon(
                    imageVector = Icons.Default.AccountCircle,
                    contentDescription = null,
                    tint = Color.White
                )
            },
            label = {
                Text(stringResource(R.string.bottom_nav_profile))
            },
            selected = false,
            onClick = {}
        )
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

@Composable
fun FitnessApp(windowSize: WindowSizeClass){
    when(windowSize.widthSizeClass){
        WindowWidthSizeClass.Compact -> {
            FitnessPortrait()
        }
        WindowWidthSizeClass.Expanded -> {
            FitnessLandscape()
        }
    }
}