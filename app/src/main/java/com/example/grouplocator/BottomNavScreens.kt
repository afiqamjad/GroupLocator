package com.example.grouplocator

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Home
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottomNavScreens(val route: String, @StringRes val resourceId: Int, val icon: ImageVector) {
    data object Home : BottomNavScreens("Home", R.string.home_route, Icons.Filled.Home)
    data object CreateEvent : BottomNavScreens("CreateEVent", R.string.create_event_route, Icons.Filled.Add)
    data object Profile : BottomNavScreens("Profile", R.string.profile_route, Icons.Filled.AccountCircle)
}