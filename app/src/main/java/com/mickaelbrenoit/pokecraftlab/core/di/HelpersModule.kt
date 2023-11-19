package com.mickaelbrenoit.pokecraftlab.core.di

import android.content.Context
import com.mickaelbrenoit.pokecraftlab.core.helpers.ResourceProvider
import com.mickaelbrenoit.pokecraftlab.core.helpers.ResourceProviderImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
object HelpersModule {

    @Provides
    @ViewModelScoped
    fun provideResourceProvider(@ApplicationContext context: Context): ResourceProvider {
        return ResourceProviderImpl(context)
    }
}