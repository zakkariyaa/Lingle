package com.example.lingle.screens

import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.compose.foundation.layout.Column
import com.example.lingle.utils.Item

@Composable
fun FakeScreen(navController: NavHostController, value: String, itemsString: String?, modifier: Modifier = Modifier) {

    Column {
        Text(
            text = value,
            fontWeight = FontWeight.Bold,
            fontSize = 35.sp,
        )

        Button(
            onClick = { navController.navigate("homepage") }) {
            Text(text = "Homepage")
        }
    }
}