package com.example.lingle

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.absoluteOffset
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.lingle.composables.Navbar
import com.example.lingle.screens.FinalScreenLayout
import com.example.lingle.screens.HomePage
import com.example.lingle.screens.ItemScreen
import com.example.lingle.ui.theme.LingleTheme
import com.example.lingle.ui.theme.darkOrange
import com.example.lingle.ui.theme.lightOrange
import com.example.lingle.utils.Item
import com.example.lingle.utils.randomItems


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            LingleTheme {
                val navController = rememberNavController()
                val offsetY = (-50).dp
                val randomItems: ArrayList<Item>;
                Column(modifier = Modifier.fillMaxSize()) {
                    Box(modifier = Modifier.zIndex(2f)) {
                        Navbar(navController = navController)
                    }
                    Box(
                        modifier = Modifier
                            .absoluteOffset(x = 0.dp, y = offsetY)
                            .weight(1f)
                            .zIndex(1f)
                    ) {
                        NavHost(
                            navController = navController,
                            startDestination = "home",
                        ) {
                            composable("home") { HomePage(navController = navController, modifier = Modifier) }
                            composable("item/{category}") {
                                backStackEntry ->
                                ItemScreen(
                                    backStackEntry.arguments?.getString("category"),
                                    randomItems = randomItems(backStackEntry.arguments?.getString("category")),
                                    navController = navController,
                                    startColour = lightOrange,
                                    endColour = darkOrange,
                                    modifier = Modifier)
                            }
                            composable("complete") {
                                FinalScreenLayout(
                                    navController = navController,
                                    startColour = lightOrange,
                                    endColour = darkOrange,
                                    modifier = Modifier)
                            }
                        }
                    }
                }
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    LingleTheme {
        val navController = rememberNavController()
        val offsetY = (-50).dp
        Column(modifier = Modifier) {
            Box(modifier = Modifier.zIndex(2f)) {
                Navbar(navController = navController)
            }
            Box(
                modifier = Modifier
                    .absoluteOffset(x = 0.dp, y = offsetY)
                    .weight(1f)
                    .zIndex(1f)
                    .fillMaxSize()
            ) {
                NavHost(
                    navController = navController,
                    startDestination = "home",
                    modifier = Modifier,
                    ) {
                    composable("home") { HomePage(navController = navController, modifier = Modifier) }
                    composable("complete") {
                        FinalScreenLayout(
                            navController = navController,
                            startColour = lightOrange,
                            endColour = darkOrange,
                            modifier = Modifier)
                    }
                }
            }
        }
    }
}
