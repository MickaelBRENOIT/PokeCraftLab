package com.mickaelbrenoit.pokecraftlab.domain.authentication.use_case

data class AuthenticationUseCases(
    val signInUseCase: SignInUseCase,
    val signUpUseCase: SignUpUseCase
)
