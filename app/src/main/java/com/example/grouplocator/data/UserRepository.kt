package com.example.grouplocator.data

import org.mindrot.jbcrypt.BCrypt

class UserRepository(private val userDao: UserDao) {
    suspend fun registerUser(email: String, password: String): Result<Unit> {
        if (email.isBlank()) {
            return Result.failure(Exception("Email cannot be blank"))
        }
        if (password.isBlank()) {
            return Result.failure(Exception("Password cannot be blank"))
        }
        val existingUser = userDao.getUserByEmail(email)
        if (existingUser != null) {
            return Result.failure(Exception("User with this email already exists"))
        }
        val salt = BCrypt.gensalt()
        val hashedPassword = BCrypt.hashpw(password, salt)
        val user = User(email = email, hashedPassword = hashedPassword, salt = salt)
        userDao.insert(user)
        return Result.success(Unit)
    }

    suspend fun authenticateUser(email: String, password: String): Boolean {
        val user = userDao.getUserByEmail(email) ?: return false
        return BCrypt.checkpw(password, user.hashedPassword)
    }
}
