package com.mirallis.chat.data.account

import com.mirallis.chat.domain.type.Either
import com.mirallis.chat.domain.type.None
import com.mirallis.chat.domain.type.exception.Failure

interface AccountRemote {
    fun register(
            email: String,
            name: String,
            password: String,
            token: String,
            userDate: Long
    ): Either<Failure, None>
}