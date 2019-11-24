package com.mirallis.chat.ui

import android.app.Application
import com.mirallis.chat.presentation.injection.AppModule
import com.mirallis.chat.presentation.injection.CacheModule
import com.mirallis.chat.presentation.injection.RemoteModule
import com.mirallis.chat.presentation.injection.ViewModelModule
import com.mirallis.chat.ui.register.RegisterActivity
import com.mirallis.chat.ui.core.navigation.RouteActivity
import com.mirallis.chat.ui.firebase.FirebaseService
import com.mirallis.chat.ui.fragment.RegisterFragment
import com.mirallis.chat.ui.home.HomeActivity
import dagger.Component
import javax.inject.Singleton

class App : Application() {

    companion object {
        lateinit var appComponent: AppComponent
    }

    override fun onCreate() {
        super.onCreate()

        initAppComponent()
    }

    private fun initAppComponent() {
        appComponent = DaggerAppComponent.builder()
                .appModule(AppModule(this)).build()
    }
}

@Singleton
@Component(modules = [AppModule::class, CacheModule::class, RemoteModule::class, ViewModelModule::class])
interface AppComponent {

    //activities
    fun inject(activity: RegisterActivity)
    fun inject(activity: RouteActivity)
    fun inject(activity: HomeActivity)

    //fragments
    fun inject(fragment: RegisterFragment)

    //services
    fun inject(service: FirebaseService)
}