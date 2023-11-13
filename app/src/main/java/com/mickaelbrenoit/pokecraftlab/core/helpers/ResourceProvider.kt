package com.mickaelbrenoit.pokecraftlab.core.helpers

import androidx.annotation.StringRes

interface ResourceProvider {
    fun getResString(@StringRes id: Int): String
}