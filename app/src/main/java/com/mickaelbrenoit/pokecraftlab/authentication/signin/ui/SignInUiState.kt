package com.mickaelbrenoit.pokecraftlab.authentication.signin.ui

data class SignInUiState(
    val email: String = "",
    val isEmailValid: Boolean = true,
    val password: String = "",
    val isPasswordValid: Boolean = true
)
