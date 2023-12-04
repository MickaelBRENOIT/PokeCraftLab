package com.mickaelbrenoit.pokecraftlab.domain.user.repository

import com.mickaelbrenoit.pokecraftlab.domain.user.entity.User

interface UserRepository {
    suspend fun addUser(user: User): Result<Unit>
}