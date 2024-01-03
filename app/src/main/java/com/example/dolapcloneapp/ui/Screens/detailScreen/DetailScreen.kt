

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Send
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.lerp
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.dolapcloneapp.R
import com.example.dolapcloneapp.feature.getKeysAndValuesList
import com.example.dolapcloneapp.ui.Screens.detailScreen.SecureShoppingScreen
import com.example.dolapcloneapp.ui.Screens.profileScreen.ProfileScreenHeaderImagePart
import kotlin.math.absoluteValue


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun DetailScreen(openPostList: List<Painter>, imageIndex: Int,  navController: NavController) {
    val scrollState = rememberLazyListState()

    var isFavoritee by remember { mutableStateOf(false) }

    val keyOfImage = getKeysAndValuesList(imageIndex)


    val pagerState = rememberPagerState( )
    LazyColumn(
        modifier = Modifier.padding(bottom = 80.dp),
        state = scrollState
    ){
        item{
            MyAppBarWithActions(navController = navController)

            LazyHorizontalGrid(
                rows = GridCells.Fixed(1),
                modifier = Modifier.height(250.dp)
            ) {
                items(keyOfImage.size) { index ->
                    val imageOnIt = keyOfImage[index]

                    HorizontalPager(state = pagerState) { page ->
                        Card(Modifier.size(200.dp)
                        ) {
                            Image(
                                painter = imageOnIt,
                                contentDescription = null,
                                contentScale = ContentScale.Crop,
                                modifier = Modifier
                                    .clip(RoundedCornerShape(8.dp)) // Add rounded corners for a nicer look

                            )
                        }
                    }
                }
            }

            Divider(thickness = 20.dp, color = colorResource(id = R.color.lightos_green))
        }
        item{
            Column(modifier = Modifier.padding(start = 5.dp, top = 5.dp)) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding()
                ) {

                    // Icon on the left
                    Icon(
                        imageVector = Icons.Default.DateRange,
                        contentDescription = "updated_icon",
                        tint = Color.LightGray
                    )

                    // Updated text in the middle, taking most of the space
                    Text(
                        "Updated 6 days ago",
                        fontWeight = FontWeight.Bold,
                        fontSize = 13.sp,
                        modifier = Modifier
                            .weight(1f) // Takes most of the available space
                    )

                    // IconButton on the right
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier
                            .size(50.dp)
                    ) {
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.Center
                        ) {
                            Icon(
                                imageVector = Icons.Default.Favorite,
                                contentDescription = null,
                                tint = if (isFavoritee) Color.Red else Color.LightGray
                            )
                            Text(
                                text = "5",
                                fontWeight = FontWeight.Bold
                            )
                        }
                    }
                }

                Spacer(modifier = Modifier.height(4.dp))
                Text("Mountaineering Boots", fontWeight = FontWeight.Bold, fontSize = 15.sp)
                Spacer(modifier = Modifier.height(5.dp))
                Row(modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically){
                    Image(painter = painterResource(id = R.drawable.etiket_icon), contentDescription = null, modifier = Modifier.size(40.dp))

                    Text("New",  fontSize = 15.sp, modifier  = Modifier.padding(start = 2.dp))

                    Image(painter = painterResource(id = R.drawable.size_icon), contentDescription = null, modifier = Modifier
                        .size(60.dp)
                        .padding(start = 20.dp))

                    Text(text = "XL", color = Color.Black,  fontSize = 13.sp)

                    Image(painter = painterResource(id = R.drawable.color_icon), contentDescription = null, modifier = Modifier
                        .size(45.dp)
                        .padding(start = 20.dp))

                    Text(text = "Green", color = Color.Black,  fontSize = 13.sp, modifier  = Modifier.padding(start = 3.dp))

                }
                Divider(thickness = 3.dp, color = colorResource(id = R.color.lightos_green))
                Spacer(modifier = Modifier.height(10.dp))
                Text( overflow = TextOverflow.Ellipsis,text = "Lorem ipsum dolor sit amet, consectetur apsum dolor sit amet, consectetur adipiscing elit, sed dLorem ipsum dolor sit amet, consectetur adipiscing elit, sed dd do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.",  fontSize = 15.sp, modifier  = Modifier.padding(start = 3.dp))
                Divider(thickness = 10.dp, color = colorResource(id = R.color.lightos_green))
                ProfileScreenHeaderImagePart(rating = 5)
                Divider(thickness = 5.dp, color = colorResource(id = R.color.lightos_green))
                SecureShoppingScreen()
                Divider(thickness = 3.dp, color = colorResource(id = R.color.lightos_green))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Start
                ) {
                    Spacer(modifier = Modifier.weight(0.4f))
                    Button(
                        onClick = { /*TODO*/ },
                        modifier = Modifier.padding(top =10.dp,bottom = 10.dp,end = 3.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = colorResource(id = R.color.lightos_yellow)
                        )
                    ) {
                        Text(text = "Make an offer", fontWeight = FontWeight.Bold, color = Color.Black)
                    }

                    Button(
                        modifier = Modifier.padding(top =10.dp,bottom = 10.dp,end = 5.dp),
                        onClick = { /*TODO*/ },
                        colors = ButtonDefaults.buttonColors(
                            containerColor = colorResource(id = R.color.lightos_choosen)
                        )
                    ) {
                        Text(text = "ADD CARD", fontWeight = FontWeight.Bold, color = Color.Black)
                    }
                }


            }
        }


    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyAppBarWithActions(navController: NavController) {
    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior(rememberTopAppBarState())


    TopAppBar(
        modifier = Modifier.statusBarsPadding(),
        colors = TopAppBarDefaults.smallTopAppBarColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer,
            titleContentColor = MaterialTheme.colorScheme.primary,
        ),
        title = {
            Text("", maxLines = 1, overflow = TextOverflow.Ellipsis)
        },
        navigationIcon = {
            IconButton(onClick = { navController.popBackStack() }) {
                Icon(imageVector = Icons.Default.ArrowBack, contentDescription = null)
            }
        },
        actions = {
            var isFavorite by remember { mutableStateOf(false) }

            IconButton(
                onClick = { isFavorite = !isFavorite },
                modifier = Modifier.size(50.dp)
            ) {
                Icon(
                    imageVector = Icons.Default.Favorite,
                    contentDescription = null,
                    tint = if (isFavorite) Color.Red else Color.LightGray
                )
            }
            IconButton(
                onClick = { /*TODO*/ },
                modifier = Modifier.size(50.dp)
            ) {
                Icon(imageVector = Icons.Default.Send, contentDescription = null)
            }
        },
        scrollBehavior = scrollBehavior

    )
}

