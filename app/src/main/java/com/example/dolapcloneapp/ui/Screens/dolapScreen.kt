package com.example.dolapcloneapp.ui.Screens

sealed class DolapScreen(val route: String) {
    object Profile: DolapScreen(route = "profile_screen")
    object Home: DolapScreen(route = "home_screen")
    object Alert: DolapScreen(route = "alert_screen")
    object Details: DolapScreen(route = "details_screen")
    object SafeShopping : DolapScreen(route = "safe_shopping_info")
    object LoginScreen : DolapScreen(route = "login_screen")
    object RegisterScreen : DolapScreen(route = "register_screen")

}