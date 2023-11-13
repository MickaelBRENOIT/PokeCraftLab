package com.mickaelbrenoit.pokecraftlab.authentication.signin.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.mickaelbrenoit.pokecraftlab.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SignInScreen(
    navController: NavController,
    viewModel: SignInViewModel = hiltViewModel()
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        val uiState by viewModel.uiState
        
        var isPasswordVisible by rememberSaveable {
            mutableStateOf(true)
        }

        OutlinedTextField(
            value = uiState.email,
            onValueChange = viewModel::onEmailChange,
            placeholder = {
                Text(text = stringResource(id = R.string.authentication_email_placeholder))
            },
            label = {
                Text(text = stringResource(id = R.string.authentication_email_label))
            },
            isError = !uiState.isEmailValid,
            supportingText = {
                if (uiState.isEmailValid) {
                    Text(text = stringResource(id = R.string.authentication_required_field_supported_text))
                } else {
                    Text(text = stringResource(id = R.string.authentication_email_supported_text))
                }
            },
            leadingIcon = {
                Icon(imageVector = Icons.Filled.Person, contentDescription = stringResource(id = R.string.authentication_email_leading_icon_description))
            },
            trailingIcon = {
                if (uiState.email.isNotEmpty()) {
                    IconButton(onClick = viewModel::onEmailClear) {
                        Icon(imageVector = Icons.Filled.Clear, contentDescription = stringResource(
                            id = R.string.authentication_email_trailing_icon_description
                        ))
                    }
                }
            },
            singleLine = true,
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(8.dp))

        OutlinedTextField(
            value = uiState.password,
            onValueChange = viewModel::onPasswordChange,
            placeholder = {
                Text(text = stringResource(id = R.string.authentication_password_placeholder))
            },
            label = {
                Text(text = stringResource(id = R.string.authentication_password_label))
            },
            isError = !uiState.isPasswordValid,
            supportingText = {
                if (uiState.isPasswordValid) {
                    Text(text = stringResource(id = R.string.authentication_required_field_supported_text))
                } else {
                    Text(text = stringResource(id = R.string.authentication_password_supported_text))
                }
            },
            leadingIcon = {
                Icon(imageVector = Icons.Filled.Lock, contentDescription = stringResource(id = R.string.authentication_email_leading_icon_description))
            },
            trailingIcon = {
                IconButton(onClick = { isPasswordVisible = !isPasswordVisible }) {
                    val visibilityIcon = if (isPasswordVisible) Icons.Filled.Visibility else Icons.Filled.VisibilityOff
                    val descriptionIcon = if (isPasswordVisible) stringResource(id = R.string.authentication_password_trailing_icon_activated_description) else stringResource(
                        id = R.string.authentication_password_trailing_icon_deactivated_description
                    )
                    Icon(imageVector = visibilityIcon, contentDescription = descriptionIcon)
                }
            },
            singleLine = true,
            modifier = Modifier.fillMaxWidth()
        )

        Button(
            onClick = { /*TODO*/ },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = stringResource(id = R.string.authentication_signin_button))
        }

        TextButton(
            onClick = { /*TODO*/ },
            modifier = Modifier.align(Alignment.End)) {
            Text(text = stringResource(id = R.string.authentication_signup_textbutton))
        }

        TextButton(
            onClick = { /*TODO*/ },
            modifier = Modifier.align(Alignment.End)) {
            Text(text = stringResource(id = R.string.authentication_forget_password_textbutton))
        }
    }
}