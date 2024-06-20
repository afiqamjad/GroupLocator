package com.example.grouplocator.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.grouplocator.data.AppDatabase
import com.example.grouplocator.data.UserRepository
import kotlinx.coroutines.launch

class UserViewModel(application: Application) : AndroidViewModel(application) {
    private val userRepository: UserRepository

    init {
        val userDao = AppDatabase.getDatabase(application).userDao()
        userRepository = UserRepository(userDao)
    }

    fun registerUser(email: String, password: String, onResult: (Boolean, String) -> Unit) {
        viewModelScope.launch {
            val result = userRepository.registerUser(email, password)
            if (result.isSuccess) {
                onResult(true, "Registration successful")
            } else {
                onResult(false, result.exceptionOrNull()?.message ?: "Unknown error")
            }
        }
    }

    fun authenticateUser(email: String, password: String, onResult: (Boolean) -> Unit) {
        viewModelScope.launch {
            val isAuthenticated = userRepository.authenticateUser(email, password)
            onResult(isAuthenticated)
        }
    }
}
