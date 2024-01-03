package com.example.dolapcloneapp.ui.root



import DetailScreen
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.dolapcloneapp.R
import com.example.dolapcloneapp.ui.Screens.DolapScreen
import com.example.dolapcloneapp.ui.Screens.alertScreen.AlertScreen
import com.example.dolapcloneapp.ui.Screens.homeScreen.HomeScreen
import com.example.dolapcloneapp.ui.Screens.profileScreen.ProfileScreen
import com.example.dolapcloneapp.ui.Screens.register_screen.LoginScreen
import com.example.dolapcloneapp.ui.Screens.register_screen.RegisterScreen
import com.example.dolapcloneapp.ui.bottomNavigationBar.BottomNavigationBar

@Composable
fun RootScreen() {

    val openPostList = listOf(
        painterResource(id = R.drawable.image_1),
        painterResource(id = R.drawable.image_2),
        painterResource(id = R.drawable.image_3),
        painterResource(id = R.drawable.image_4),
        painterResource(id = R.drawable.image_5),

        painterResource(id = R.drawable.image_2),
        painterResource(id = R.drawable.image_3),
        painterResource(id = R.drawable.image_4),
        painterResource(id = R.drawable.image_2),
        painterResource(id = R.drawable.image_3),
        painterResource(id = R.drawable.image_4),
        painterResource(id = R.drawable.image_3),
        painterResource(id = R.drawable.image_4),
    )


    val navController = rememberNavController()
    RegisterScreen(navController = navController)

    // BottomNavigationBar'ı burada çağırın
    BottomNavigationBar(navController)

    // NavHost'u burada çağırın
    NavHost(navController = navController, startDestination = DolapScreen.Home.route) {
        composable(route = DolapScreen.Home.route) {
            HomeScreen()
        }
        composable(route = DolapScreen.Alert.route) {

            AlertScreen()
        }

        composable(route = DolapScreen.LoginScreen.route) {

            LoginScreen(navController = navController)
        }

        composable(route = DolapScreen.Profile.route) {
            // ProfileScreen içinde BottomNavigationBar çağırılmasına gerek yok
            ProfileScreen(navController = navController, openPostList = openPostList, paddingValues =  80)
        }
        composable(
            route = "details_screen/{index}",
            arguments = listOf(navArgument("index") { type = NavType.StringType })
        ) { navBackStackEntry ->
            val index = navBackStackEntry.arguments?.getString("index")
            if (index != null) {
                DetailScreen(openPostList = openPostList,imageIndex = index.toInt(), navController = navController)
            }
        }

    }
}



