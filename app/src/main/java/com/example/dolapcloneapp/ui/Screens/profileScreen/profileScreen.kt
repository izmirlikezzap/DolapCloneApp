package com.example.dolapcloneapp.ui.Screens.profileScreen

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun ProfileScreen(openPostList: List<Painter>, navController: NavController, paddingValues: Int) {


    Card(
        modifier = Modifier.padding(bottom = paddingValues.dp),
        shape = RectangleShape,
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant)
    ){


        ProfileScreenHeaderImagePart(rating = 5 )
        ProfileScreenHeader()
        ProfileScreenTab(openPostList.size)
        ProductSection(posts= openPostList, navController= navController)

    }

}