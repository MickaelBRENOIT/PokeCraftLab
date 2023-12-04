package com.mickaelbrenoit.pokecraftlab.domain.user.use_case

import com.mickaelbrenoit.pokecraftlab.domain.user.entity.User
import com.mickaelbrenoit.pokecraftlab.domain.user.repository.UserRepository
import javax.inject.Inject

class AddUserUseCase @Inject constructor(
    private val userRepository: UserRepository
) {
    suspend operator fun invoke(user: User): Result<Unit> {
        return userRepository.addUser(user)
    }
}