package com.example.lingle.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.lingle.R

@Composable
fun NextButton(modifier: Modifier = Modifier) {
    Card(
        colors = CardDefaults.cardColors(
            containerColor = Color.Transparent,
        ),
        modifier = modifier
            .size(width = 105.dp, height = 50.dp)
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
        ) {
            val nextButtonImage = painterResource(R.drawable.next_button)
            Image(
                painter = nextButtonImage,
                contentDescription = "Next Button",
                modifier = modifier
                    .size(105.dp)
            )
        }
    }
}
@Preview
@Composable fun ButtonPreview() {
    NextButton()
}