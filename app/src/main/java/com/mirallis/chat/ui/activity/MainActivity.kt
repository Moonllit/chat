package com.mirallis.chat.ui.activity

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.mirallis.chat.R
import com.mirallis.chat.cache.AccountCacheImpl
import com.mirallis.chat.cache.SharedPrefsManager
import com.mirallis.chat.data.account.AccountRepositoryImpl
import com.mirallis.chat.domain.account.AccountRepository
import com.mirallis.chat.domain.account.Register
import com.mirallis.chat.remote.account.AccountRemoteImpl
import com.mirallis.chat.remote.core.NetworkHandler
import com.mirallis.chat.remote.core.Request
import com.mirallis.chat.remote.service.ServiceFactory

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val sharedPrefs = this.getSharedPreferences(this.packageName, Context.MODE_PRIVATE)

        val accountCache = AccountCacheImpl(SharedPrefsManager(sharedPrefs))
        val accountRemote = AccountRemoteImpl(Request(NetworkHandler(this)), ServiceFactory.makeService(true))

        val accountRepository: AccountRepository = AccountRepositoryImpl(accountRemote, accountCache)

        accountCache.saveToken("12345")

        val register = Register(accountRepository)
        register(Register.Params("abcd@m.com", "abcd", "123")) {
            it.either({
                Toast.makeText(this, it.javaClass.simpleName, Toast.LENGTH_SHORT).show()
            }, {
                Toast.makeText(this, "Аккаунт создан", Toast.LENGTH_SHORT).show()
            })
        }
    }
}
