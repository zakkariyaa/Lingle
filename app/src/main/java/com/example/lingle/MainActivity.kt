package com.example.lingle

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.lingle.composables.Navbar
import com.example.lingle.screens.HomePage
import com.example.lingle.ui.theme.LingleTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            LingleTheme {
                val navController = rememberNavController()
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                ) {
                    NavHost(navController = navController, startDestination = "home") {
                        composable("home") { HomePage(navController = navController, modifier = Modifier) }
                    }
                    Navbar(navController = navController)
                    HomePage(navController = navController, modifier = Modifier)
                }
            }
        }
    }
}


//@Preview(showBackground = true)
//@Composable
//fun HomePagePreview() {
//    LingleTheme {
//        HomePage(navController = navController)
//    }
//}
