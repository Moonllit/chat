package com.mirallis.chat.presentation.injection

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.mirallis.chat.presentation.viewmodel.AccountViewModel
import com.mirallis.chat.presentation.viewmodel.ViewModelFactory
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {
    @Binds
    internal abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

    @Binds // в аргументы передаем не необходимые зависимости, а конкретную реализацию
    @IntoMap
    @ViewModelKey(AccountViewModel::class)
    abstract fun bindAccountViewModel(accountViewModel: AccountViewModel): ViewModel
}