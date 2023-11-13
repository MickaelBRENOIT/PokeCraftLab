package com.mickaelbrenoit.pokecraftlab.core.helpers

import android.content.Context
import javax.inject.Inject

class ResourceProviderImpl @Inject constructor(
    private val context: Context
) : ResourceProvider {
    override fun getResString(id: Int): String {
        return context.getString(id)
    }
}