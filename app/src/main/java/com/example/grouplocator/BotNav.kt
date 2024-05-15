package com.example.grouplocator

import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.getValue
import androidx.compose.ui.res.stringResource
import androidx.navigation.compose.currentBackStackEntryAsState

@Composable
fun BotNav(navController: NavHostController, items: List<BottomNavScreens>) {
    NavigationBar {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route
        items.forEach {screen ->
            NavigationBarItem(
                selected = (currentRoute == screen.route),
                icon = { Icon(screen.icon, contentDescription = null)},
                alwaysShowLabel = false,
                onClick = {
                          navController.navigate(screen.route) {
                              popUpTo(navController.graph.startDestinationId)
                              launchSingleTop = true
                          }
                }
            )
        }
    }
}