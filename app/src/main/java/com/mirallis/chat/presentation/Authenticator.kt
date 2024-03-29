package com.mirallis.chat.presentation

import com.mirallis.chat.cache.SharedPrefsManager
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class Authenticator @Inject constructor(
        val sharedPrefsManager: SharedPrefsManager
) {
    fun userLoggedIn() = sharedPrefsManager.containsAnyAccount()
}