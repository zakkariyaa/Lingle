package com.example.lingle.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.TileMode
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.lingle.R
import com.example.lingle.composables.HomePageCards
import com.example.lingle.ui.theme.LingleTheme


@Composable
fun HomePage(modifier: Modifier = Modifier) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.linearGradient(
                    colors = listOf(
                        Color(0xFFB5FFFB),
                        Color(0xFF07A69E)
                    ),
                    start = Offset(0f, 0f),
                    end = Offset(1f, 0f),
                    tileMode = TileMode.Clamp
                )
            )
            .padding(10.dp)
    ){

        Spacer(modifier = modifier
            .height(125.dp))
        Box(modifier = modifier
            .align(Alignment.CenterHorizontally)
        ){
            Text(
            text = "Pick a Category"
            )
        }
        Row (modifier = modifier
            .weight(1f)){

            HomePageCards(
                text = "Fruits",
                color = Color(0xFFFFC824),
                picture = painterResource(id = R.drawable.fruits),
                modifier = modifier
                    .weight(0.5f)
            )

            HomePageCards(
                text = "Colours",
                color = Color(0xFFC08EC9),
                picture = painterResource(id = R.drawable.colours),
                modifier = modifier
                    .weight(0.5f)
            )
        }
        Row (modifier = modifier
            .weight(1f)){
            HomePageCards(
                text = "Vegetables",
                color = Color(0xFF00D572),
                picture = painterResource(id = R.drawable.vegetables),
                modifier = modifier
                    .weight(0.5f)
            )

            HomePageCards(
                text = "Animals",
                color = Color(0xFFFF5959),
                picture = painterResource(id = R.drawable.animals),
                modifier = modifier
                    .weight(0.5f)
            )
        }

        Spacer(modifier = modifier
            .height(50.dp))

    }
}



@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    LingleTheme {
        HomePage()
    }
}