package com.mickaelbrenoit.pokecraftlab.domain.user.entity

data class User(
    val uid: String,
    val email: String,
    val username: String? = null,
    val age: Int? = null,
    val gender: String? = null,
    val createdAt: String? = null,
    val updatedAt: String? = null
)
