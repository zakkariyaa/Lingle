@file:Suppress("UNUSED_EXPRESSION")

package com.example.lingle.composables

import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedCard
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import com.example.lingle.R
import com.example.lingle.utils.Item


@OptIn(ExperimentalMaterial3Api::class)
@Composable
    fun ItemCard(name: String, image: String, modifier: Modifier = Modifier, onCardClick: () -> Unit, isFlipped: Boolean) {
        val density = LocalDensity.current.density

        val rotationY by animateFloatAsState(
            targetValue = if (isFlipped) 180f else 0f,
            animationSpec = tween(
                durationMillis = 400,
                easing = FastOutSlowInEasing
            ), label = "Card Flip Animation"
        )
        OutlinedCard(
            onClick = {
                onCardClick()

            },
            colors = CardDefaults.cardColors(
                containerColor = Color.White,
            ),
            elevation = CardDefaults.cardElevation(
                defaultElevation = 6.dp
            ),
            border = BorderStroke(4.dp, Color.Black),
            modifier = modifier
                .fillMaxWidth()
                .height(500.dp)
                .size(width = 240.dp, height = 100.dp)
                .graphicsLayer(
                    rotationY = rotationY,
                    cameraDistance = 8 * density
                )
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                if (isFlipped) {
                    Text(
                        text = name,
                        fontSize = 40.sp,
                        textAlign = TextAlign.Center,
                        modifier = Modifier
                            .padding(10.dp)
                            .graphicsLayer(
                                rotationY = 180f
                            )
                    )
                    AsyncImage(
                      model = image,
                      contentDescription = name,
                      modifier = Modifier
                          .size(300.dp).padding(20.dp)
                          .graphicsLayer(
                                rotationY = 180f
                            )
                )
                    val soundImage = painterResource(R.drawable.voice)
                    Image(
                        painter = soundImage,
                        contentDescription = "Volume",
                        modifier = Modifier
                            .size(55.dp)
                            .graphicsLayer(
                                rotationY = 180f
                            )
                    )

                } else {
                    Text(
                        text = "Guess what this is?",
                        fontSize = 25.sp,
                        textAlign = TextAlign.Center,
                        color = Color.Black,
                        modifier = Modifier
                            .padding(10.dp)

                    )
                    AsyncImage(
                      model = image,
                      contentDescription = name,
                      modifier = Modifier
                          .size(300.dp).padding(20.dp)

                )
                }
            }
        }
    }

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
//            .padding(2.dp)
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
                        contentDescription = it.name,
                        modifier = Modifier.aspectRatio(16f / 9f)
                    )
                    Text(
                        text = it.name,
                        fontSize = 25.sp,
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
fun HomePageCards (
    category: String,
    color: Color,
    picture: Painter,
    navController: NavHostController,
    modifier: Modifier = Modifier) {

    Card(onClick = { navController.navigate("item/${category}") },
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
                text = category,
                fontSize = 25.sp,
                modifier = modifier
                    .padding(top = 30.dp)
                    .align(Alignment.CenterHorizontally)
                    .weight(1f)
            )
            Image(
                painter = picture,
                contentDescription = "quiz logo",
                modifier = modifier
                    .padding(bottom = 20.dp)
                    .fillMaxWidth()
                    .weight(3f)
            )
        }
    }
}




// @Preview(showBackground = true)
// @Composable
// fun CardPreview() {
//     FinalCard(
//         arrayListOf
//             (
//         Item("Apple", "https://res.cloudinary.com/dqgeypwaa/image/upload/v1702393272/1_kjyk3h.png"),
//         Item("Pear", "https://res.cloudinary.com/dqgeypwaa/image/upload/v1702393272/5_qbaizz.png"),
//         Item(
//             "Orange",
//             "https://res.cloudinary.com/dqgeypwaa/image/upload/v1702393272/2_ymvg5d.png"
//         ),
//         Item(
//             "Strawberry",
//             "https://res.cloudinary.com/dqgeypwaa/image/upload/v1702393272/3_kiv5du.png"
//         ),
//         Item("Banana", "https://res.cloudinary.com/dqgeypwaa/image/upload/v1702393272/4_w6aicq.png")
//         )
//     )
// }

//  @Preview(showBackground = true)
//  @Composable
//  fun HomePageCardsPreview() {
//      val navController = rememberNavContro ller()
//      LingleTheme {
//          HomePageCards("HELLO ANDROID!", color = Color.Red, picture = painterResource(id = R.drawable.fruits), navController = navController) }
//  fun CardsPreview() {
//      LingleTheme {
//          ItemCard(name = "Apple")
//      }
//  }


// @Preview(showBackground = true)
// @Composable
// fun HomePageCardsPreview() {
//     LingleTheme {
//         HomePageCards("HELLO ANDROID!", color = Color.Red, picture = painterResource(id = R.drawable.fruits)) }
// }

