package com.mirallis.chat.presentation.injection

import com.mirallis.chat.BuildConfig
import com.mirallis.chat.data.account.AccountRemote
import com.mirallis.chat.remote.account.AccountRemoteImpl
import com.mirallis.chat.remote.core.Request
import com.mirallis.chat.remote.service.ApiService
import com.mirallis.chat.remote.service.ServiceFactory
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RemoteModule {

    @Provides
    @Singleton
    fun provideApiService(): ApiService = ServiceFactory.makeService(BuildConfig.DEBUG)

    @Provides
    @Singleton
    fun provideAccountRemote(request: Request, apiService: ApiService): AccountRemote {
        return AccountRemoteImpl(request, apiService)
    }
}