package com.example.lingle.composables

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


// Card to list all items viewed in current game
@Composable
fun FinalCard(itemList: List<String>, modifier: Modifier = Modifier) {
    Card(
        colors = CardDefaults.cardColors(Color.White),
        border = BorderStroke(3.dp, Color.Black),
        shape = RoundedCornerShape(20.dp),
        elevation = CardDefaults.cardElevation(16.dp),
        modifier = modifier
            .fillMaxWidth()
    ) {
        itemList.forEach {
            Text(
                text = it,
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                modifier = modifier
//                    .height(30.dp)
                    .wrapContentHeight(align = Alignment.CenterVertically)
                    .align(Alignment.CenterHorizontally)
                    .fillMaxWidth()
                    .weight(1f)
            )
        }
    }
}




@Preview(showBackground = true)
@Composable
fun CardPreview() {
    FinalCard(listOf("Apple", "Banana", "Orange", "Pear", "Kiwi"))
}
