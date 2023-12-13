package com.example.lingle.composables

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lingle.R

@Composable
fun NewGameButton(modifier: Modifier = Modifier) {
    Button(
        onClick = { /*TODO*/ },
        shape = RoundedCornerShape(10.dp),
        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF077274)),
        border = BorderStroke(2.dp, Color.White),
        modifier = modifier
            .height(50.dp)
            .width(150.dp)
    ) {
        Text(
            text = stringResource(id = R.string.new_game),
            fontSize = 20.sp,
            style = MaterialTheme.typography.bodyLarge
        )
    }
}


@Preview
@Composable
fun ButtonPreview() {
    NewGameButton()
}