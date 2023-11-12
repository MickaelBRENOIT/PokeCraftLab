package com.mickaelbrenoit.pokecraftlab

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import androidx.navigation.compose.rememberNavController
import com.mickaelbrenoit.pokecraftlab.core.navigation.Screen

@Composable
fun TestNavHost(navController: NavHostController = rememberNavController()) {
    NavHost(navController = navController, startDestination = "authentication") {
        navigation(startDestination = Screen.SignIn.route, route = "authentication") {
            composable(Screen.SignIn.route) {
                Text(text = "Signin")
            }
            composable(Screen.SignUp.route) {
                Text(text = "Signup")
            }
            composable(Screen.ForgetPassword.route) {
                Text(text = "ForgetPassword")
            }
        }
    }
}