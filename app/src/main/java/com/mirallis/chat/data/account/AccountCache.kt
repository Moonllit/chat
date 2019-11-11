package com.mirallis.chat.data.account

import com.mirallis.chat.domain.account.AccountEntity
import com.mirallis.chat.domain.type.Either
import com.mirallis.chat.domain.type.None
import com.mirallis.chat.domain.type.Failure

interface AccountCache {
    fun getToken(): Either<Failure, String>
    fun saveToken(token: String): Either<Failure, None>

    fun logout(): Either<Failure, None>

    fun getCurrentAccount(): Either<Failure, AccountEntity>
    fun saveAccount(account: AccountEntity): Either<Failure, None>
}