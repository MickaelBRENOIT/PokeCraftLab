package com.mickaelbrenoit.pokecraftlab.core.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import com.mickaelbrenoit.pokecraftlab.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PokeCraftLabEmailField(
    value: String,
    onValueChange: (String) -> Unit,
    isValueValid: Boolean,
    onClearField: () -> Unit,
    modifier: Modifier = Modifier
) {
    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        placeholder = {
            Text(text = stringResource(id = R.string.authentication_email_placeholder))
        },
        label = {
            Text(text = stringResource(id = R.string.authentication_email_label))
        },
        isError = !isValueValid,
        supportingText = {
            if (isValueValid) {
                Text(text = stringResource(id = R.string.authentication_required_field_supported_text))
            } else {
                Text(text = stringResource(id = R.string.authentication_email_supported_text))
            }
        },
        leadingIcon = {
            Icon(imageVector = Icons.Filled.Person, contentDescription = stringResource(id = R.string.authentication_email_leading_icon_description))
        },
        trailingIcon = {
            if (value.isNotEmpty()) {
                IconButton(onClick = onClearField) {
                    Icon(imageVector = Icons.Filled.Clear, contentDescription = stringResource(
                        id = R.string.authentication_email_trailing_icon_description
                    )
                    )
                }
            }
        },
        singleLine = true,
        modifier = modifier
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PokeCraftLabPasswordField(
    value: String,
    onValueChange: (String) -> Unit,
    isValueValid: Boolean,
    label: String = stringResource(id = R.string.authentication_password_label),
    placeholder: String = stringResource(id = R.string.authentication_password_placeholder),
    modifier: Modifier = Modifier
) {

    var isPasswordVisible by rememberSaveable {
        mutableStateOf(false)
    }

    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        placeholder = {
            Text(text = placeholder)
        },
        label = {
            Text(text = label)
        },
        isError = !isValueValid,
        supportingText = {
            if (isValueValid) {
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
        visualTransformation = if (isPasswordVisible) VisualTransformation.None else PasswordVisualTransformation(),
        singleLine = true,
        modifier = modifier
    )
}