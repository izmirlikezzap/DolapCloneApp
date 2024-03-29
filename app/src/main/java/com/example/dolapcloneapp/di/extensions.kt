package com.example.dolapcloneapp.di

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.unit.dp

@Composable
fun RoundImage(
    image : Painter,
    modifier : Modifier = Modifier
){
    Image(painter = image, contentDescription = null,
        modifier = modifier.
            aspectRatio(
                1f,
                matchHeightConstraintsFirst = true  // firstly get hight size and reassign it width if it is true
            )
            .border(width = 3.dp, color = Color.LightGray, shape = CircleShape)
            .clip(CircleShape)
    )
}


