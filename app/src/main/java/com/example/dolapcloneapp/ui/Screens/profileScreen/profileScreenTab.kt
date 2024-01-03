package com.example.dolapcloneapp.ui.Screens.profileScreen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.List
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp


@Composable
fun ProfileScreenTab(timesOfProduct : Int,modifier: Modifier = Modifier) {
    Divider(thickness = 2.dp, color = Color.LightGray)

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text("$timesOfProduct Product${if (timesOfProduct > 1) "s" else ""}")




        IconButton(
            onClick = { /* Handle settings button click */ },
            modifier = Modifier
                .padding(end = 9.dp)
        ) {
            Icon(
                imageVector = Icons.Default.List,
                contentDescription = "List"
            )
        }
    }

    Divider(thickness = 2.dp, color = Color.LightGray)
}



