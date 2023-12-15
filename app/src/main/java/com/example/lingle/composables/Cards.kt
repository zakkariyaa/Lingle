package com.example.lingle.composables

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.graphics.painter.Painter
import androidx.navigation.NavHostController
import com.example.lingle.utils.Item
import java.util.ArrayList

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
                    .wrapContentHeight(align = Alignment.CenterVertically)
                    .align(Alignment.CenterHorizontally)
                    .fillMaxWidth()
                    .weight(1f)            
            )
          }    
      }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomePageCards (
    text: String,
    color: Color,
    picture: Painter,
    modifier: Modifier = Modifier,
    navController: NavHostController,
    items: ArrayList<Item>?
) {
    Card(
        onClick = {
            navController.navigate("fakeScreen") {
                putParcelableArrayListExtra("items", items)
            } },
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
                    .fillMaxWidth()
                    .weight(1f)
            )
        }
    }
}

//@Preview(showBackground = true)
//@Composable
//fun CardPreview() {
//    FinalCard(listOf("Apple", "Banana", "Orange", "Pear", "Kiwi"))
//}

//@Preview(showBackground = true)
//@Composable
//fun HomePageCardsPreview() {
// LingleTheme {
//     HomePageCards(
//         "HELLO ANDROID!",
//         color = Color.Red,
//         picture = painterResource(id = R.drawable.fruits),
//         navController = navController
//     ) }
//}
