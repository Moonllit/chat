package com.mirallis.chat.data.account

import com.mirallis.chat.domain.type.Either
import com.mirallis.chat.domain.type.None
import com.mirallis.chat.domain.type.exception.Failure

interface AccountCache {
    fun getToken(): Either<Failure, String>
    fun saveToken(token: String): Either<Failure, None>
}