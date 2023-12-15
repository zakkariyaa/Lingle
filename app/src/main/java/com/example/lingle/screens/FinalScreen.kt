package com.example.lingle.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.lingle.R
import com.example.lingle.composables.FinalCard
import com.example.lingle.composables.NewGameButton
import com.example.lingle.composables.SubHeadingText

// Layout of the final screen of the game
@Composable
fun FinalScreenLayout(navController: NavHostController, startColour: Color, endColour: Color, modifier: Modifier = Modifier) {
    val fakeItemsList = listOf("Apple", "Banana", "Orange", "Pear", "Kiwi")

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

        FakeNavBar(
            modifier.weight(1f)
        )
        Spacer(modifier = modifier
            .weight(0.5f)
        )
        SubHeadingText(
            text = stringResource(id = R.string.final_message),
            modifier = modifier.weight(1f)
        )
        Spacer(modifier = modifier
            .weight(0.5f)
        )
        FinalCard(
            itemList = fakeItemsList,
            modifier = modifier.weight(4f)
        )
        Spacer(modifier = modifier
            .weight(0.5f)
        )
        NewGameButton(modifier = modifier.weight(0.6f))

        Spacer(modifier = modifier
            .weight(0.5f)
        )
    }

}

// Fake navbar as a placeholder
@Composable
fun FakeNavBar(modifier: Modifier = Modifier) {
    Row {
        Text(
            text = "Lingle",
            fontSize = 40.sp,
            modifier = modifier.weight(1f)
        )
        Button(
            onClick = { /*TODO*/ },
            modifier = modifier.weight(1f)
        ) {

        }
    }
}

//@Preview(showBackground = true)
//@Composable
//fun FinalScreenPreview() {
//    FinalScreenLayout(
//        startColour = lightOrange,
//        endColour = darkOrange
//    )
//}