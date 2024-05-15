package com.example.grouplocator

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@Composable
fun NavConfig(navController: NavHostController) {
    NavHost(navController, startDestination = BottomNavScreens.Home.route) {
        composable(BottomNavScreens.Home.route) {
            navController.navigate(BottomNavScreens.Home.route)
        }
        composable(BottomNavScreens.Profile.route) {
            navController.navigate(BottomNavScreens.Profile.route)
        }
        composable(BottomNavScreens.CreateEvent.route) {
            navController.navigate(BottomNavScreens.CreateEvent.route)
        }
    }
}