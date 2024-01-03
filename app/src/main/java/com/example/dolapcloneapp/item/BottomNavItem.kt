package com.example.dolapcloneapp.ui

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector

@Composable
fun getIconForScreen(screen: String): ImageVector {
    return when (screen) {
        "Home" -> Icons.Default.Home
        "Notifications" -> Icons.Default.Notifications
        "Cart" -> Icons.Default.ShoppingCart
        "Profile" -> Icons.Default.Person
        "Mine" -> Icons.Default.Settings
        else -> Icons.Default.Home
    }
}
