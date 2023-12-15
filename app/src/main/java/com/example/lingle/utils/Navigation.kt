package com.example.lingle.utils

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.lingle.screens.FakeScreen
import com.example.lingle.screens.FinalScreenLayout
import com.example.lingle.screens.HomePage
import com.example.lingle.ui.theme.darkOrange
import com.example.lingle.ui.theme.lightOrange

@Composable
fun AppNavigation(navController: NavHostController) {
    val randomItems = randomItems()
    NavHost(navController = navController, startDestination = "homepage") {
        composable("homepage") {
            HomePage(navController, randomItems)
        }
        composable("fakeScreenFruits") {
            FakeScreen(navController, value = "Fake Screen")
        }
        composable("fakeScreenVegetables") {
            FakeScreen(navController, value = "Fake Screen")
        }
        composable("fakeScreenAnimals") {
            FakeScreen(navController, value = "Fake Screen")
        }
        composable("fakeScreenColours") {
            FakeScreen(navController, value = "Fake Screen")
        }
        composable("finalScreen") {
            FinalScreenLayout(navController, startColour = lightOrange, endColour = darkOrange)
        }
    }
}