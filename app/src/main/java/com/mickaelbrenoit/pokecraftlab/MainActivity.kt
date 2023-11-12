package com.mickaelbrenoit.pokecraftlab

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.mickaelbrenoit.pokecraftlab.core.navigation.Screen
import com.mickaelbrenoit.pokecraftlab.core.ui.theme.PokeCraftLabTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PokeCraftLabTheme {
                val navController = rememberNavController()
                NavHost(navController = navController, startDestination = "authentication") {
                    navigation(startDestination = Screen.SignIn.route, route = "authentication") {
                        composable(Screen.SignIn.route) {
                            Surface(modifier = Modifier.fillMaxSize()) {
                                Text(text = "Signin")
                            }
                        }
                        composable(Screen.SignUp.route) {
                            Surface(modifier = Modifier.fillMaxSize()) {
                                Text(text = "Signup")
                            }
                        }
                        composable(Screen.ForgetPassword.route., arguments = listOf(navArgument("pokemonId") { type = NavType.StringType })) { backStackEntry ->
                            val pokemonId = backStackEntry.arguments?.getString("pokemonId") ?: return@composable
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    PokeCraftLabTheme {
        Greeting("Android")
    }
}