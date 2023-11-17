package com.mickaelbrenoit.pokecraftlab.ui.authentication.signin

data class SignInUiState(
    val email: String = "",
    val isEmailValid: Boolean = true,
    val password: String = "",
    val isPasswordValid: Boolean = true
)
