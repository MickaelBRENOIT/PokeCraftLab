package com.mickaelbrenoit.pokecraftlab.data

import android.annotation.SuppressLint
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.auth.User
import com.mickaelbrenoit.pokecraftlab.domain.authentication.repository.AuthRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.tasks.await
import kotlinx.coroutines.withContext
import javax.inject.Inject

class AuthRepositoryImpl @Inject constructor(
    private val firebaseAuth: FirebaseAuth
): AuthRepository {
    @SuppressLint("RestrictedApi")
    override suspend fun signIn(email: String, password: String): Result<User> {
        return withContext(Dispatchers.IO) {
            try {
                val result = firebaseAuth.signInWithEmailAndPassword(email, password).await()
                Result.success(User(result.user?.uid))
            } catch (e: Exception) {
                Result.failure(e)
            }
        }
    }

    @SuppressLint("RestrictedApi")
    override suspend fun signUp(email: String, password: String): Result<User> {
        return withContext(Dispatchers.IO) {
            try {
                val result = firebaseAuth.createUserWithEmailAndPassword(email, password).await()
                Result.success(User(result.user?.uid))
            } catch (e: Exception) {
                Result.failure(e)
            }
        }
    }
}