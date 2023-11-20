package com.mickaelbrenoit.pokecraftlab.ui.authentication.signin

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mickaelbrenoit.pokecraftlab.core.helpers.ResourceProvider
import com.mickaelbrenoit.pokecraftlab.core.helpers.isValidEmail
import com.mickaelbrenoit.pokecraftlab.core.helpers.isValidPassword
import com.mickaelbrenoit.pokecraftlab.domain.authentication.use_case.AuthenticationUseCases
import com.mickaelbrenoit.pokecraftlab.ui.authentication.AuthState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import java.lang.Exception
import javax.inject.Inject

@HiltViewModel
class SignInViewModel @Inject constructor(
    private val authenticationUseCases: AuthenticationUseCases
) : ViewModel() {

    var uiState = mutableStateOf(SignInUiState())
        private set

    // https://stackoverflow.com/questions/70016316/convert-mutablelivedata-to-mutablestate
    private val _authState = MutableLiveData<AuthState>()
    val authState: LiveData<AuthState> = _authState

    private val email
        get() = uiState.value.email

    private val isEmailValid
        get() = uiState.value.isEmailValid

    private val password
        get() = uiState.value.password

    private val isPasswordValid
        get() = uiState.value.isPasswordValid

    fun onEmailChange(newValue: String) {
        uiState.value = uiState.value.copy(email = newValue)
    }

    fun onEmailClear() {
        uiState.value = uiState.value.copy(email = "")
    }

    fun onPasswordChange(newValue: String) {
        uiState.value = uiState.value.copy(password = newValue)
    }

    fun onSignInClick() {
        if (!email.isValidEmail()) {
            uiState.value = uiState.value.copy(isEmailValid = false)
            return
        }
        uiState.value = uiState.value.copy(isEmailValid = true)

        if (!password.isValidPassword()) {
            uiState.value = uiState.value.copy(isPasswordValid = false)
            return
        }
        uiState.value = uiState.value.copy(isPasswordValid = true)

        viewModelScope.launch {
            _authState.value = AuthState.Loading
            val data = try {
                authenticationUseCases.signInUseCase(uiState.value.email, uiState.value.password)
                    .onSuccess {
                        _authState.value = AuthState.Success(it)
                    }
                    .onFailure {
                        _authState.value = AuthState.Error(it.localizedMessage)
                    }
            } catch (e: Exception) {
                _authState.value = AuthState.Error(e.localizedMessage)
                return@launch
            }
        }
    }

}