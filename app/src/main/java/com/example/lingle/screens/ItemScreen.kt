package com.example.lingle.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.lingle.R
import com.example.lingle.composables.ItemCard
import com.example.lingle.composables.NextButton
import com.example.lingle.composables.SubHeadingText
import com.example.lingle.ui.theme.darkOrange
import com.example.lingle.ui.theme.lightOrange

@Composable
fun ItemScreen(startColour: Color, endColour: Color, modifier: Modifier = Modifier) {

    var isFlipped by remember { mutableStateOf(false) }
    var onCardFlipped by remember { mutableStateOf(false) }


    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .fillMaxSize()
            .background(
                Brush.verticalGradient(
                    listOf(
                        startColour,
                        endColour
                    )
                )
            )
            .padding(20.dp)
    ) {

        Spacer(modifier = modifier
            .weight(0.5f)
        )
        SubHeadingText(
            text = stringResource(id = R.string.category_title),
            modifier = modifier
                .weight(1f)
        )
        Spacer(modifier = modifier
            .height(5.dp)
        )
        ItemCard(name = "Apple", onCardFlipped = {false});
        run {
            if (onCardFlipped) {
                NextButton()
            }
        }
        Spacer(modifier = modifier
            .height(25.dp)
        )
        if (isFlipped){
            NextButton()
        }


    }

}

@Preview(
    showBackground = true,
    showSystemUi = true,
    name = "Item Screen"
)
@Composable
fun ItemScreenPreview() {
    ItemScreen(
        startColour = lightOrange,
        endColour = darkOrange
    )
}