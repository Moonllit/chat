package com.mirallis.chat.data.account

import com.mirallis.chat.domain.account.AccountEntity
import com.mirallis.chat.domain.type.Either
import com.mirallis.chat.domain.type.None
import com.mirallis.chat.domain.type.Failure

interface AccountRemote {
    fun register(
            email: String,
            name: String,
            password: String,
            token: String,
            userDate: Long
    ): Either<Failure, None>

    fun login(email: String, password: String, token: String): Either<Failure, AccountEntity>

    fun updateToken(userId: Long, token: String, oldToken: String): Either<Failure, None>
}