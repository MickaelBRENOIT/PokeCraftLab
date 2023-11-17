package com.mickaelbrenoit.pokecraftlab.core.navigation

sealed class Destination(val route: String) {
    object Authentication : Destination("authentication")
}
