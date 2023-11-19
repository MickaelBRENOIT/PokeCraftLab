package com.mickaelbrenoit.pokecraftlab.domain.authentication.repository

import com.google.firebase.firestore.auth.User

interface AuthRepository {
    suspend fun signIn(email: String, password: String): Result<User>
    suspend fun signUp(email: String, password: String): Result<User>
}