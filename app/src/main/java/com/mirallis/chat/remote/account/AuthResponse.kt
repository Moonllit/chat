package com.mirallis.chat.remote.account

import com.mirallis.chat.domain.account.AccountEntity
import com.mirallis.chat.remote.core.BaseResponse

class AuthResponse(
        success: Int,
        message: String,
        val user: AccountEntity
) : BaseResponse(success, message)