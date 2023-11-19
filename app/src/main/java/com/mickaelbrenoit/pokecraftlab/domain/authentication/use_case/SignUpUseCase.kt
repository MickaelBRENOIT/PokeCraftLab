package com.mickaelbrenoit.pokecraftlab.domain.authentication.use_case

import com.google.firebase.firestore.auth.User
import com.mickaelbrenoit.pokecraftlab.domain.authentication.repository.AuthRepository
import javax.inject.Inject

class SignUpUseCase @Inject constructor(
    private val authRepository: AuthRepository
) {
    suspend operator fun invoke(email: String, password: String) : Result<User> {
        return authRepository.signUp(email, password)
    }
}