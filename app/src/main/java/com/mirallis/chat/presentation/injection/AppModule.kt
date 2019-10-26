package com.mirallis.chat.presentation.injection

import android.content.Context
import com.mirallis.chat.data.account.AccountCache
import com.mirallis.chat.data.account.AccountRemote
import com.mirallis.chat.data.account.AccountRepositoryImpl
import com.mirallis.chat.domain.account.AccountRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule(private val context: Context) {

    @Provides
    @Singleton
    fun provideAppContext(): Context = context

    @Provides
    @Singleton
    fun provideAccountRepository(remote: AccountRemote, cache: AccountCache): AccountRepository {
        return AccountRepositoryImpl(remote, cache)
    }
}