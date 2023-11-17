package com.mickaelbrenoit.pokecraftlab

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
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
import com.mickaelbrenoit.pokecraftlab.ui.authentication.signin.SignInScreen
import com.mickaelbrenoit.pokecraftlab.core.navigation.Destination
import com.mickaelbrenoit.pokecraftlab.core.navigation.Screen
import com.mickaelbrenoit.pokecraftlab.core.ui.theme.PokeCraftLabTheme
import com.mickaelbrenoit.pokecraftlab.ui.authentication.signup.SignUpScreen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PokeCraftLabTheme {
                Surface(
                    modifier = Modifier.fillMaxSize()
                ) {
                    val navController = rememberNavController()
                    NavHost(navController = navController, startDestination = Destination.Authentication.route) {
                        navigation(startDestination = Screen.SignIn.route, route = Destination.Authentication.route) {
                            composable(Screen.SignIn.route) {
                                SignInScreen(navController = navController)
                            }
                            composable(Screen.SignUp.route) {
                                SignUpScreen(navController = navController)
                            }
                            composable(Screen.ForgetPassword.route, arguments = listOf(navArgument("pokemonId") { type = NavType.StringType })) { backStackEntry ->
                                val pokemonId = backStackEntry.arguments?.getString("pokemonId") ?: return@composable
                            }
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