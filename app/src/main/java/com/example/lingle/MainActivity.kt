package com.example.lingle

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.lingle.composables.Navbar
import com.example.lingle.screens.HomePage
import com.example.lingle.screens.ItemScreen
import com.example.lingle.ui.theme.DarkOrange
import com.example.lingle.ui.theme.DarkTurquoise
import com.example.lingle.ui.theme.LightOrange
import com.example.lingle.ui.theme.LightTurquoise
import com.example.lingle.ui.theme.LingleTheme
import com.example.lingle.ui.theme.categoriesColorList
import com.example.lingle.utils.categories
import com.example.lingle.utils.Item
import com.example.lingle.utils.randomItems

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            LingleTheme {
//                 Surface(
//                     modifier = Modifier.fillMaxSize(),
//                     color = MaterialTheme.colorScheme.background
//                 ) {
// //                    HomePage()
//                     FinalScreenLayout(
//                         startColour = lightOrange,
//                         endColour = darkOrange
//                     )
                val navController = rememberNavController()
//                val offsetY = (-50).dp
                Column(modifier = Modifier.fillMaxSize(),
                        verticalArrangement = Arrangement.spacedBy((-50).dp),
                    ) {
                    Box(modifier = Modifier.zIndex(2f)) {
                        Navbar(navController = navController)
                    }
                    Box(
                        modifier = Modifier
//                            .absoluteOffset(x = 0.dp, y = offsetY)
//                            .weight(1f)
                            .zIndex(1f)
                    ) {
                        NavHost(
                            navController = navController,
                            startDestination = "home",
                        ) {
                            composable("home") { HomePage(categories = categories, navController = navController, modifier = Modifier) }
                            composable("item/{category}") {
                                backStackEntry ->
                                val category: String = rememberSaveable { backStackEntry.arguments?.getString("category") ?: ""}
                                val randomItems: ArrayList<Item> = rememberSaveable { randomItems(category) ?: arrayListOf() }
                                val categoryIndex: Int = categories.indexOfFirst { it.name == category }
                                val startColour: Color = categoriesColorList[categoryIndex % categoriesColorList.size].first
                                val endColour: Color = categoriesColorList[categoryIndex % categoriesColorList.size].second

                                ItemScreen(
                                    category,
                                    randomItems,
                                    startColour,
                                    endColour,
                                    navController = navController,
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
// //        HomePage()
//         FinalScreenLayout(
//             startColour = lightOrange,
//             endColour = darkOrange
//         )
        val navController = rememberNavController()
//        val offsetY = (-50).dp

        val items = arrayListOf(
            Item("Apple", "https://res.cloudinary.com/dqgeypwaa/image/upload/v1702393272/1_kjyk3h.png"),
            Item("Pear", "https://res.cloudinary.com/dqgeypwaa/image/upload/v1702393272/5_qbaizz.png"),
            Item("Orange", "https://res.cloudinary.com/dqgeypwaa/image/upload/v1702393272/2_ymvg5d.png"),
            Item("Strawberry", "https://res.cloudinary.com/dqgeypwaa/image/upload/v1702393272/3_kiv5du.png"),
            Item("Banana", "https://res.cloudinary.com/dqgeypwaa/image/upload/v1702393272/4_w6aicq.png")
        )

        Column(modifier = Modifier,
            verticalArrangement = Arrangement.spacedBy((-50).dp),
        ) {
            Box(modifier = Modifier.zIndex(2f),) {
                Navbar(navController = navController)
            }
            Box(
                modifier = Modifier
//                    .absoluteOffset(x = 0.dp, y = offsetY)
                    .weight(1f)
                    .zIndex(1f)
                    .fillMaxSize()
            ) {
                NavHost(
                    navController = navController,
                    startDestination = "home",
                    modifier = Modifier,
                    ) {
                    composable("home") { HomePage(categories = categories, navController = navController, modifier = Modifier) }
                }
            }
        }
    }
}
