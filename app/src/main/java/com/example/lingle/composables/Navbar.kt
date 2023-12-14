package com.example.lingle.composables

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.lingle.R
import com.example.lingle.ui.theme.DarkTurquoise
import com.example.lingle.ui.theme.LingleTheme

@Composable
fun Navbar(navController: NavHostController) {
    Box(modifier = Modifier.fillMaxWidth()) {
        Image(painter = painterResource(
            id = R.drawable.navbar_background
        ),
            contentDescription = "navbar light blue background",
            contentScale = ContentScale.FillBounds,
            modifier = Modifier.fillMaxWidth().height(160.dp).align(Alignment.BottomCenter)
        )
    }
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(33.33.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
    ) {
        Logo("Lingle")
        HomeIcon(navController)
    }
}

@Composable
fun Logo(name: String, modifier: Modifier = Modifier) {
    Text(
        text = name,
        modifier = modifier,
        style = MaterialTheme.typography.titleLarge
    )
}

@Composable
fun HomeIcon(navController: NavHostController) {
    Button(
        onClick = { navController.navigate("home") },
        colors = ButtonDefaults.buttonColors(
            containerColor = DarkTurquoise,
            contentColor = Color.White,
        ),
        shape = RoundedCornerShape(10.dp),
        elevation = ButtonDefaults.buttonElevation(defaultElevation = 4.dp),
        modifier = Modifier.border(BorderStroke(2.dp, Color.White), RoundedCornerShape(10.dp))
    ) {
        Icon(
            imageVector = Icons.Filled.Home,
            contentDescription = "Home icon",
            modifier = Modifier.size(50.dp)
        )
    }
}

@Preview(showBackground = true)

@Composable
fun GreetingPreview() {
    val navController = rememberNavController()
    LingleTheme {
        Navbar(navController = navController)
    }
}