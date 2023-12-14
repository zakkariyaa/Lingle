package com.example.lingle.composables

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.lingle.Item


// Card to list all items viewed in current game, on final screen
@Composable
fun FinalCard(itemList: ArrayList<Item>, modifier: Modifier = Modifier) {

    Card(
        colors = CardDefaults.cardColors(Color.White),
        border = BorderStroke(3.dp, Color.Black),
        shape = RoundedCornerShape(20.dp),
        elevation = CardDefaults.cardElevation(16.dp),
        modifier = modifier
            .fillMaxWidth()
    )
    {
        Column(verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.Start,
            modifier = modifier
                    .padding(horizontal = 50.dp, vertical = 15.dp)
        )
        {
            // Display image and name for each item viewed in the game
            itemList.forEach {
                Row(horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = modifier
                        .padding(vertical = 15.dp)
                        )
                {
                    AsyncImage(
                        model = it.imgUrl,
                        contentDescription = it.name
                    )
                    // Image for preview
    //                Image(
    //                    painter = painterResource(id = R.drawable.colours),
    //                    contentDescription = it.name
    //                )
                    Text(
                        text = it.name,
                        fontSize = 30.sp,
                        fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.Left,
                        modifier = modifier
                            .padding(horizontal = 20.dp)
                    )
                }
            }
        }
    }
}

// Card to show category, on homepage screen
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomePageCards (text: String, color: Color, picture: Painter, modifier: Modifier = Modifier) {

    Card(onClick = { /*TODO*/ },
        colors = CardDefaults.cardColors(color),
        border = BorderStroke(3.dp, Color.White),
        elevation = CardDefaults.cardElevation(16.dp),
        modifier = modifier
            .fillMaxSize()
            .padding(10.dp)

    ){
        Column (
            verticalArrangement = Arrangement.Center
        ){
            Text(
                text = text,
                modifier = modifier
                    .padding(top = 30.dp)
                    .align(Alignment.CenterHorizontally)
            )
            Image(
                painter = picture,
                contentDescription = "quiz logo",
                modifier = modifier
                    .padding(bottom = 20.dp)
            )
        }
    }
}




@Preview(showBackground = true)
@Composable
fun CardPreview() {
    FinalCard(
        arrayListOf
            (
        Item("Apple", "https://res.cloudinary.com/dqgeypwaa/image/upload/v1702393272/1_kjyk3h.png"),
        Item("Pear", "https://res.cloudinary.com/dqgeypwaa/image/upload/v1702393272/5_qbaizz.png"),
        Item(
            "Orange",
            "https://res.cloudinary.com/dqgeypwaa/image/upload/v1702393272/2_ymvg5d.png"
        ),
        Item(
            "Strawberry",
            "https://res.cloudinary.com/dqgeypwaa/image/upload/v1702393272/3_kiv5du.png"
        ),
        Item("Banana", "https://res.cloudinary.com/dqgeypwaa/image/upload/v1702393272/4_w6aicq.png")
        )
    )
}


// @Preview(showBackground = true)
// @Composable
// fun HomePageCardsPreview() {
//     LingleTheme {
//         HomePageCards("HELLO ANDROID!", color = Color.Red, picture = painterResource(id = R.drawable.fruits)) }
// }
