package com.mickaelbrenoit.pokecraftlab.ui.authentication.signup

data class SignUpUiState(
    val email: String = "",
    val isEmailValid: Boolean = true,
    val password: String = "",
    val isPasswordValid: Boolean = true,
    val repeatPassword: String = "",
    val isRepeatPasswordValid: Boolean = true
)
