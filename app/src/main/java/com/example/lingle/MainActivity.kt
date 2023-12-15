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
import com.example.lingle.ui.theme.LingleTheme
import com.example.lingle.ui.theme.darkOrange
import com.example.lingle.ui.theme.lightOrange

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
                val offsetY = (-50).dp

                val items = arrayListOf(
                    Item("Apple", "https://res.cloudinary.com/dqgeypwaa/image/upload/v1702393272/1_kjyk3h.png"),
                    Item("Pear", "https://res.cloudinary.com/dqgeypwaa/image/upload/v1702393272/5_qbaizz.png"),
                    Item("Orange", "https://res.cloudinary.com/dqgeypwaa/image/upload/v1702393272/2_ymvg5d.png"),
                    Item("Strawberry", "https://res.cloudinary.com/dqgeypwaa/image/upload/v1702393272/3_kiv5du.png"),
                    Item("Banana", "https://res.cloudinary.com/dqgeypwaa/image/upload/v1702393272/4_w6aicq.png")
                )

                Column {
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
//                            startDestination = "home",
                            startDestination = "complete",
                            ) {
                            composable("home") { HomePage(navController = navController, modifier = Modifier) }
                            composable("complete") {
                                FinalScreenLayout(
//                                    navController = navController,
                                    itemList = items,
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
// //        HomePage()
//         FinalScreenLayout(
//             startColour = lightOrange,
//             endColour = darkOrange
//         )
        val navController = rememberNavController()
        val offsetY = (-50).dp

        val items = arrayListOf(
            Item("Apple", "https://res.cloudinary.com/dqgeypwaa/image/upload/v1702393272/1_kjyk3h.png"),
            Item("Pear", "https://res.cloudinary.com/dqgeypwaa/image/upload/v1702393272/5_qbaizz.png"),
            Item("Orange", "https://res.cloudinary.com/dqgeypwaa/image/upload/v1702393272/2_ymvg5d.png"),
            Item("Strawberry", "https://res.cloudinary.com/dqgeypwaa/image/upload/v1702393272/3_kiv5du.png"),
            Item("Banana", "https://res.cloudinary.com/dqgeypwaa/image/upload/v1702393272/4_w6aicq.png")
        )

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
//                            navController = navController,
                            itemList = items,
                            startColour = lightOrange,
                            endColour = darkOrange,
                            modifier = Modifier)
                    }
                }
            }
        }
    }
}
