package com.mickaelbrenoit.pokecraftlab.core.di

import com.mickaelbrenoit.pokecraftlab.domain.authentication.repository.AuthRepository
import com.mickaelbrenoit.pokecraftlab.domain.authentication.use_case.AuthenticationUseCases
import com.mickaelbrenoit.pokecraftlab.domain.authentication.use_case.SignInUseCase
import com.mickaelbrenoit.pokecraftlab.domain.authentication.use_case.SignUpUseCase
import com.mickaelbrenoit.pokecraftlab.domain.user.repository.UserRepository
import com.mickaelbrenoit.pokecraftlab.domain.user.use_case.AddUserUseCase
import com.mickaelbrenoit.pokecraftlab.domain.user.use_case.UserUseCases
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
object UseCasesModule {

    @Provides
    @ViewModelScoped
    fun provideAuthenticationUseCases(authRepository: AuthRepository): AuthenticationUseCases {
        return AuthenticationUseCases(
            signInUseCase = SignInUseCase(authRepository),
            signUpUseCase = SignUpUseCase(authRepository)
        )
    }

    @Provides
    @ViewModelScoped
    fun provideUserUseCases(userRepository: UserRepository): UserUseCases {
        return UserUseCases(
            addUserUseCase = AddUserUseCase(userRepository)
        )
    }
}