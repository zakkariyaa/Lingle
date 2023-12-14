package com.example.lingle.composables

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lingle.R
import com.example.lingle.ui.theme.LingleTheme

@Composable
fun ItemCard(name: String, modifier: Modifier = Modifier) {
//    var isClicked by remember { mutableStateOf(false) }
    OutlinedCard(
//        onClick = {isClicked = !isClicked},
        colors = CardDefaults.cardColors(
            containerColor = Color.White,
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 6.dp
        ),
        border = BorderStroke(4.dp, Color.Black),
        modifier = modifier
//            .clickable { isClicked = !isClicked }
            .fillMaxWidth()
            .height(500.dp)
            .size(width = 240.dp, height = 100.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "$name",
                fontSize = 25.sp,
                textAlign = TextAlign.Center,
                color = Color.Black,
                modifier = Modifier
                    .padding(10.dp)
            )

            val appleImage = painterResource(R.drawable.apple)
            Image(
                painter = appleImage,
                contentDescription = "Apple"
            )

            val soundImage = painterResource(R.drawable.voice)
            Image(
                painter = soundImage,
                contentDescription = "Volume",
                modifier = Modifier
                    .size(50.dp)
            )
        }
    }
}
@Preview(showBackground = true)
@Composable
fun CardsPreview() {
    LingleTheme {
        ItemCard(name = "Apple")
    }
}