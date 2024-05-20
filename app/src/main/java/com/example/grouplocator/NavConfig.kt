package com.example.grouplocator

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.grouplocator.ui.theme.CreateEventScreen
import com.example.grouplocator.ui.theme.HomeScreen
import com.example.grouplocator.ui.theme.ProfileScreen

//Navigation Graph to show which routes map to which composable function
@Composable
fun NavConfig(navController: NavHostController, modifier: Modifier = Modifier) {
    NavHost(navController = navController, startDestination = BottomNavScreens.Home.route, modifier = modifier) {
        composable(BottomNavScreens.Home.route) { HomeScreen() }
        composable(BottomNavScreens.Profile.route) { ProfileScreen() }
        composable(BottomNavScreens.CreateEvent.route) { CreateEventScreen() }
    }
}