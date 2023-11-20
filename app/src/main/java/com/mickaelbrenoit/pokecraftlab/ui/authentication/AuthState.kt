package com.mickaelbrenoit.pokecraftlab.ui.authentication

import com.google.firebase.firestore.auth.User

sealed class AuthState {
    object Loading : AuthState()
    data class Success(val user: User) : AuthState()
    data class Error(val message: String?) : AuthState()
}
