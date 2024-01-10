package com.example.lingle.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.lingle.R
import com.example.lingle.composables.HomePageCard
import com.example.lingle.composables.SubHeadingText
import com.example.lingle.ui.theme.DarkTurquoise
import com.example.lingle.ui.theme.LightTurquoise
import com.example.lingle.ui.theme.LingleTheme
import com.example.lingle.ui.theme.categoriesColorList
import com.example.lingle.utils.Category
import com.example.lingle.utils.categories

@Composable
fun HomePage(categories: List<Category>?, navController: NavHostController, modifier: Modifier) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(
                Brush.verticalGradient(
                    listOf(
                        LightTurquoise,
                        DarkTurquoise
                    ),
                )
            )
            .padding(horizontal = 10.dp, vertical = 48.dp)
    ) {
        Box(
            modifier = modifier
                .align(Alignment.CenterHorizontally)
        ) {
            SubHeadingText(
                text = stringResource(id = R.string.choose_category),
            )
        }
        Spacer(modifier = modifier.height(10.dp))
        if (categories != null) {
//            Autogenerate columns and rows for HomePageCards
            LazyVerticalGrid(
                columns = GridCells.Adaptive(minSize = 158.dp),
                content = {
                items(categories.size) {index ->
//                    Generate a HomePageCard for each category to be used in Grid
                    HomePageCard (
                        category = categories[index].name,
                        color = categoriesColorList[index % categoriesColorList.size].second,
                        picture = categories[index].picture,
                        navController = navController,
                        modifier = modifier
                            .weight(0.5f)
                        )
                    }
                }
            )
        }
        Spacer(modifier = modifier
            .height(50.dp))
    }
}


@Preview(showBackground = true)

@Composable
fun GreetingPreview() {
    val navController = rememberNavController()
    LingleTheme {
        HomePage(categories = categories, navController = navController, modifier = Modifier)
    }
}