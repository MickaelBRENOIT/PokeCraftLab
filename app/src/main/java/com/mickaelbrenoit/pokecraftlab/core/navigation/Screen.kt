package com.mickaelbrenoit.pokecraftlab.core.navigation

sealed class Screen(val route: String) {

    // Routes for authentication
    object SignIn : Screen("sign_in")
    object SignUp : Screen("sign_up")
    object ForgetPassword : Screen("forget_password")

    // Routes for Pokemon collections
    object PokemonsList : Screen("pokemons_list")
    object PokemonDetail : Screen("pokemon_detail/{pokemonId}") {
        fun createRoute(pokemonId: String) = "pokemon_detail/$pokemonId"
    }
}
