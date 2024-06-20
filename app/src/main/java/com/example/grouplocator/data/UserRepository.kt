package com.example.grouplocator.data

import org.mindrot.jbcrypt.BCrypt

class UserRepository(private val userDao: UserDao) {
    suspend fun registerUser(email: String, password: String) {
        val salt = BCrypt.gensalt()
        val hashedPassword = BCrypt.hashpw(password, salt)
        val user = User(email = email, hashedPassword = hashedPassword, salt = salt)
        userDao.insert(user)
    }

    suspend fun authenticateUser(email: String, password: String): Boolean {
        val user = userDao.getUserByEmail(email) ?: return false
        return BCrypt.checkpw(password, user.hashedPassword)
    }
}
