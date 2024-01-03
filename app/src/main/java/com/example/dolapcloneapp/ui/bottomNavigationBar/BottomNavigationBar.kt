package com.example.dolapcloneapp.ui.bottomNavigationBar

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.dolapcloneapp.ui.getIconForScreen


@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun BottomNavigationBar(navController: NavController) {
    val screens = listOf("Home", "Alert", "Mine", "Cart", "Profile")

    var selectedScreen by remember { mutableStateOf(screens.last()) }

    Scaffold(
        bottomBar = {
            NavigationBar {
                screens.forEach { screen ->
                    NavigationBarItem(
                        label = {
                            Text(text = screen, fontSize = 12.sp)
                        },
                        selected = screen == selectedScreen,
                        modifier = Modifier.padding(5.dp),
                        onClick = { selectedScreen = screen

                                  },
                        icon = { Icon(getIconForScreen(screen = screen), contentDescription = screen) }
                    )
                }
            }
        }
    ) { innerPadding ->

        Box(
            modifier = Modifier
                .padding(
                    PaddingValues(bottom = innerPadding.calculateBottomPadding())
                )
        ){
            when (selectedScreen) {
                "Profile" -> navController.navigate(route = "profile_screen")
                "Home" -> navController.navigate(route = "home_screen")
                "Alert" -> navController.navigate(route = "alert_screen")
            }
        }
    }
}



