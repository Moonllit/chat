package com.mirallis.chat.domain.account

import com.mirallis.chat.domain.interactor.UseCase
import com.mirallis.chat.domain.type.Either
import com.mirallis.chat.domain.type.Failure
import javax.inject.Inject

class Login @Inject constructor(
        private val accountRepository: AccountRepository
) : UseCase<AccountEntity, Login.Params>() {

    override suspend fun run(params: Params): Either<Failure, AccountEntity> {
        return accountRepository.login(params.email, params.password)
    }

    data class Params(val email: String, val password: String)
}