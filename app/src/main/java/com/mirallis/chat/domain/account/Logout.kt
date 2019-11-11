package com.mirallis.chat.domain.account

import com.mirallis.chat.domain.interactor.UseCase
import com.mirallis.chat.domain.type.Either
import com.mirallis.chat.domain.type.Failure
import com.mirallis.chat.domain.type.None
import javax.inject.Inject

class Logout @Inject constructor(
        private val accountRepository: AccountRepository
) : UseCase<None, None>() {

    override suspend fun run(params: None): Either<Failure, None> = accountRepository.logout()
}