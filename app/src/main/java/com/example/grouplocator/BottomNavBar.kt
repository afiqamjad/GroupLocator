package com.example.grouplocator

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.rememberNavController

@Composable
fun BottomNavBar() {
    val navController = rememberNavController()

    val bottomNavItems = listOf(
        BottomNavScreens.Home,
        BottomNavScreens.CreateEvent,
        BottomNavScreens.Profile
    )

    Scaffold (
        bottomBar = {
            BotNav(navController, bottomNavItems)
        },
        content = { padding ->
            Column {
                Modifier.padding(padding)
                NavConfig(navController)
            }
        }
    )
}