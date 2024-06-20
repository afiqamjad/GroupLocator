package com.example.grouplocator

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.grouplocator.ui.theme.GroupLocatorTheme
import com.example.grouplocator.ui.theme.LoginScreen

class LoginActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GroupLocatorTheme {
                LoginScreen()
            }
        }
    }
}
