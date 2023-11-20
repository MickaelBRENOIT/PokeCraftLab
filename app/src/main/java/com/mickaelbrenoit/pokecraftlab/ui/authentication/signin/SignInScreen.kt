package com.mickaelbrenoit.pokecraftlab.ui.authentication.signin

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.mickaelbrenoit.pokecraftlab.R
import com.mickaelbrenoit.pokecraftlab.core.navigation.Screen
import com.mickaelbrenoit.pokecraftlab.core.ui.components.PokeCraftLabEmailField
import com.mickaelbrenoit.pokecraftlab.core.ui.components.PokeCraftLabPasswordField

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SignInScreen(
    navController: NavController,
    viewModel: SignInViewModel = hiltViewModel()
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        val uiState by viewModel.uiState

        PokeCraftLabEmailField(
            value = uiState.email,
            onValueChange = viewModel::onEmailChange,
            isValueValid = uiState.isEmailValid,
            onClearField = viewModel::onEmailClear,
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(8.dp))

        PokeCraftLabPasswordField(
            value = uiState.password,
            onValueChange = viewModel::onPasswordChange,
            isValueValid = uiState.isPasswordValid,
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(8.dp))

        Button(
            onClick = viewModel::onSignInClick,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = stringResource(id = R.string.authentication_signin_button))
        }

        TextButton(
            onClick = { navController.navigate(Screen.SignUp.route) },
            modifier = Modifier.align(Alignment.End)) {
            Text(text = stringResource(id = R.string.authentication_signup_textbutton), style = MaterialTheme.typography.labelSmall)
        }

        TextButton(
            onClick = { /*TODO*/ },
            modifier = Modifier.align(Alignment.End)) {
            Text(text = stringResource(id = R.string.authentication_forget_password_textbutton), style = MaterialTheme.typography.labelSmall)
        }
    }
}