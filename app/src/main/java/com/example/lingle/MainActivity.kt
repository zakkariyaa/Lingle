package com.example.lingle

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.lingle.screens.ItemScreen
import com.example.lingle.ui.theme.LingleTheme
import com.example.lingle.ui.theme.darkOrange
import com.example.lingle.ui.theme.lightOrange

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LingleTheme {
                ItemScreen(
                    startColour = lightOrange,
                    endColour = darkOrange
                )
            }
        }
    }
}

@Preview(
    showBackground = true,
    showSystemUi = true,
    name = "My Preview"
)
@Composable
fun FilmPreview() {
    LingleTheme(
    ) {
        ItemScreen(
            startColour = lightOrange,
            endColour = darkOrange
        )
    }

}
