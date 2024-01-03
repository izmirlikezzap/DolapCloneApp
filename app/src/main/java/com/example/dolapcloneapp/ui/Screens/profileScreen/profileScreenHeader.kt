package com.example.dolapcloneapp.ui.Screens.profileScreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme.shapes
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

import com.example.dolapcloneapp.di.RoundImage
import com.example.dolapcloneapp.ui.Screens.profileScreen.extensions.HeaderExtensions
import com.example.dolapcloneapp.R


@Composable
fun ProfileScreenHeaderImagePart(rating: Int, modifier: Modifier = Modifier) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.Top
    ) {

        RoundImage(
            image = painterResource(id = R.drawable.mustafa),
            modifier = Modifier
                .size(90.dp)
                .weight(3f)
                .padding(5.dp)
        )
        Spacer(modifier = modifier.width(5.dp))
        Column(
            modifier = modifier
                .weight(7f)
                .padding(top = 5.dp)
                .height(60.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.Start
        ) {
            Row (verticalAlignment = Alignment.CenterVertically){
                Text(
                    text = "@" + "melikayanoglu",
                    fontWeight = FontWeight.Bold,
                    color = Color.Black
                )
                Box(
                    modifier = Modifier

                        .padding(start = 10.dp)
                        .background(Color.Green, shapes.small)

                ) {
                    Text(
                        text = "10",
                        fontSize = 10.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.Black,
                        modifier = modifier.padding(3.dp)
                    )
                }
            }
            Row {
                Icon(imageVector = Icons.Default.ArrowBack, contentDescription = null,  )
                Text("Active in 6 minutes ago ",   overflow = TextOverflow.Ellipsis)
            }
            
            Spacer(modifier = modifier.width(1.dp))
            Row(modifier = Modifier.fillMaxWidth()) {
                repeat(5) { index ->
                    Icon(
                        imageVector = Icons.Default.Star,
                        contentDescription = "Star$index",
                        tint = if (index < rating) Color.Yellow else Color.Gray,
                        modifier = Modifier.size(13.dp)
                    )
                }
            }
        }
        Box() {
            IconButton(
                onClick = { /* Handle settings button click */ },
                modifier = Modifier
                    .padding(9.dp)
            ) {
                Icon(
                    imageVector = Icons.Default.Settings,
                    contentDescription = "Settings"
                )
            }
        }
    }
}


@Composable
fun ProfileScreenHeader(modifier : Modifier = Modifier){
    Row(
        modifier =  Modifier.padding(start = 20.dp,top = 5.dp, bottom = 5.dp ),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceAround
    ){
        HeaderExtensions("15","Sold")
        Spacer(modifier = modifier.width(9.dp))
        HeaderExtensions("100","Followers")
        Spacer(modifier = modifier.width(9.dp))
        HeaderExtensions("65","Following")
        Spacer(modifier = modifier.width(9.dp))
        HeaderExtensions("280","Favorite")

    }

}