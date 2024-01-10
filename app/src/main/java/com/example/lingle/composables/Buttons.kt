package com.example.lingle.composables

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material.icons.outlined.ArrowForward
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lingle.R
import com.example.lingle.ui.theme.DarkTurquoise

// Button to link to a new game of the same category
@Composable
fun NewGameButton(onClick: () -> Unit, modifier: Modifier = Modifier) {
    Button(
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(
            containerColor = DarkTurquoise
        ),
        shape = RoundedCornerShape(10.dp),
        elevation = ButtonDefaults.buttonElevation(defaultElevation = 4.dp),
        border = BorderStroke(3.dp, Color.White),
//        modifier = modifier
    ) {
        Icon(
            imageVector = Icons.Filled.Refresh,
            contentDescription = "New Game",
            modifier = Modifier.size(40.dp)
        )
//        Text(
//            text = stringResource(id = R.string.new_game),
//            fontSize = 30.sp,
//            style = MaterialTheme.typography.bodyLarge
//        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NextButton(onButtonClick: () -> Unit, modifier: Modifier = Modifier) {
    Button(
        onClick = onButtonClick,
        colors = ButtonDefaults.buttonColors(
            containerColor = DarkTurquoise,
            contentColor = Color.White,
        ),
        shape = RoundedCornerShape(10.dp),
        border = BorderStroke(3.dp, Color.White),
        elevation = ButtonDefaults.buttonElevation(defaultElevation = 4.dp)
    ) {
        Icon(
            imageVector = Icons.Filled.ArrowForward,
            contentDescription = "Arrow Forward",
            modifier = Modifier.size(40.dp)
        )
    }
}

@Preview
@Composable
fun ButtonPreview() {
//    NewGameButton()
//    NextButton()
}