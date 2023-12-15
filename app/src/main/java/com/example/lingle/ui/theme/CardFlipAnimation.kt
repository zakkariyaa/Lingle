package com.example.lingle.ui.theme

import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.lingle.R


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CardFlip(text: String, color: Color, picture: Painter, modifier: Modifier = Modifier) {
    var isFlipped by remember { mutableStateOf(false) }
    val density = LocalDensity.current.density


    val rotationY by animateFloatAsState(
        targetValue = if (isFlipped) 180f else 0f,
        animationSpec = tween(
            durationMillis = 400, // Adjust the duration as needed
            easing = FastOutSlowInEasing
        ), label = "Card Flip Animation"
    )


    Card(
        onClick = { isFlipped = !isFlipped },
        colors = CardDefaults.cardColors(color),
        border = BorderStroke(3.dp, Color.White),
        elevation = CardDefaults.cardElevation(16.dp),
        modifier = modifier
            .fillMaxSize()
            .padding(10.dp)
            .graphicsLayer(
                rotationY = rotationY,
                cameraDistance = 8 * density
            )
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            if (isFlipped) {
                Text(
                    text = "This is the back when flipped",
                    modifier = modifier
                        .padding(top = 30.dp)
                        .graphicsLayer(
                            rotationY = 180f
                        )
                )

            } else {
                Text(
                    text = text,
                    modifier = modifier
                        .padding(top = 30.dp)
                )
            }

            if (isFlipped){
                Image(
                    painter = painterResource(id = R.drawable.ic_launcher_foreground),
                    contentDescription = "quiz logo",
                    modifier = modifier
                        .padding(bottom = 20.dp)
                        .fillMaxWidth()
                        .weight(1f)
                        .graphicsLayer(
                            rotationY = 180f
                        )
                )
            } else{
                Image(
                    painter = picture,
                    contentDescription = "quiz logo",
                    modifier = modifier
                        .padding(bottom = 20.dp)
                        .fillMaxWidth()
                        .weight(1f)
                )
            }

        }
    }

}


@Preview(showBackground = true)
@Composable
fun CardFlipAnimationPreview() {
    LingleTheme {
        CardFlip("HELLO ANDROID!", color = Color.Red, picture = painterResource(id = R.drawable.fruits)) }
}

