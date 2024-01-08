package com.example.lingle.composables

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lingle.R

// Button to link to a new game of the same category
@Composable
fun NewGameButton(modifier: Modifier = Modifier) {
    Button(
        onClick = { /*TODO*/ },
        shape = RoundedCornerShape(10.dp),
        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF077274)),
        border = BorderStroke(3.dp, Color.White),
        modifier = modifier
    ) {
        Text(
            text = stringResource(id = R.string.new_game),
            fontSize = 30.sp,
            style = MaterialTheme.typography.bodyLarge
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NextButton(onButtonClick: () -> Unit, modifier: Modifier = Modifier, isFlipped: Boolean) {
    Card(
        onClick = onButtonClick,
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
@Composable
fun ButtonPreview() {
//    NewGameButton()
//    NextButton()
}