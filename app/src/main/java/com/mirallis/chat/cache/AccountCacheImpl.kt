package com.mirallis.chat.cache

import com.mirallis.chat.data.account.AccountCache
import com.mirallis.chat.domain.type.Either
import com.mirallis.chat.domain.type.None
import com.mirallis.chat.domain.type.exception.Failure
import javax.inject.Inject

class AccountCacheImpl @Inject constructor(private val prefsManager: SharedPrefsManager) : AccountCache {

    override fun saveToken(token: String): Either<Failure, None> {
        return prefsManager.saveToken(token)
    }

    override fun getToken(): Either<Failure, String> {
        return prefsManager.getToken()
    }
}