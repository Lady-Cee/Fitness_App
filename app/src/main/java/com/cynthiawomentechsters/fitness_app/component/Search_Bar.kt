package com.cynthiawomentechsters.fitness_app.component

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.cynthiawomentechsters.fitness_app.R
import com.cynthiawomentechsters.fitness_app.screen.FitnessHomeScreen
import com.cynthiawomentechsters.fitness_app.ui.theme.Fitness_AppTheme

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
