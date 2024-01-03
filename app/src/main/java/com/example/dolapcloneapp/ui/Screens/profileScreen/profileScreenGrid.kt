package com.example.dolapcloneapp.ui.Screens.profileScreen

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.dolapcloneapp.ui.Screens.DolapScreen


@Composable
fun ProductSection(
    posts: List<Painter>,
    modifier: Modifier = Modifier,
    navController: NavController
) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        modifier = modifier.fillMaxSize()

    ) {
        items(posts.size) { index ->
            val imagePainter = posts[index]
            Box(modifier = Modifier
                .padding(8.dp) // Add padding for better spacing
                .clip(RoundedCornerShape(8.dp)) // Add rounded corners for a nicer look
                .background(MaterialTheme.colorScheme.background)
                ){
                Log.d("gridImage","$imagePainter")
                GridPhoto(photo = imagePainter, index = index,navController = navController)
            }

           

        }
    }
}



@Composable
fun GridPhoto(photo: Painter, index : Int, navController: NavController) {


    Column(
        modifier = Modifier
            .fillMaxSize()
            .clickable {
                navController.navigate(route = DolapScreen.Details.route + "/$index")
            }
    ) {
        Image(
            painter = photo,
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier

                .padding(5.dp)
                .fillMaxWidth()
                .height(150.dp)
                .clip(RoundedCornerShape(8.dp))
        )
        Spacer(modifier = Modifier.height(8.dp))
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(5.dp)
        ) {
            Text("Apple", fontWeight = FontWeight.Bold, fontSize = 20.sp)
            Spacer(modifier = Modifier.height(4.dp)) // Add spacing between text elements
            Text("6500 TL", fontWeight = FontWeight.Bold, fontSize = 18.sp, color = Color.Gray)
        }

    }
}

