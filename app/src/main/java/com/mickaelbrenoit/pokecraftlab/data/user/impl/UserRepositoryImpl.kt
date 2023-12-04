package com.mickaelbrenoit.pokecraftlab.data.user.impl

import com.google.firebase.firestore.FirebaseFirestore
import com.mickaelbrenoit.pokecraftlab.domain.user.entity.User
import com.mickaelbrenoit.pokecraftlab.domain.user.repository.UserRepository
import kotlinx.coroutines.tasks.await
import java.lang.Exception
import java.util.Date
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(
    private val firestore: FirebaseFirestore
): UserRepository {
    override suspend fun addUser(user: User): Result<Unit> {
        return try {
            val currentTime = Date()
            val userMap = hashMapOf(
                "uid" to user.uid,
                "email" to user.email,
                "createdAt" to currentTime
            )
            firestore.collection("users").document(user.uid).set(userMap).await()
            Result.success(Unit)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

}