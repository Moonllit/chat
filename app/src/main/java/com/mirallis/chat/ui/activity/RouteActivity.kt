package com.mirallis.chat.ui.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.mirallis.chat.ui.App
import com.mirallis.chat.ui.core.navigation.Navigator
import javax.inject.Inject

class RouteActivity : AppCompatActivity() {

    @Inject
    lateinit var navigator: Navigator

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        App.appComponent.inject(this)

        navigator.showMain(this)
    }
}