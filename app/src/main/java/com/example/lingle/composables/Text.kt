package com.example.lingle.composables


import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

// Subheading text composable
// Can be reused on all game screens with appropriate text
@Composable
fun SubHeadingText(text: String, modifier: Modifier = Modifier) {
    Text(
        text = text,
        fontWeight = FontWeight.Bold,
        fontSize = 35.sp,
    )
}