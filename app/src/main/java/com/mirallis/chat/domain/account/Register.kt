package com.mirallis.chat.domain.account

import com.mirallis.chat.domain.type.None
import com.mirallis.chat.domain.type.Either
import com.mirallis.chat.domain.type.exception.Failure
import com.mirallis.chat.domain.interactor.UseCase
import javax.inject.Inject

class Register @Inject constructor(
    private val repository: AccountRepository
) : UseCase<None, Register.Params>() {

    override suspend fun run(params: Params): Either<Failure, None> {
        return repository.register(params.email, params.name, params.password)
    }

    data class Params(val email: String, val name: String, val password: String)
}

