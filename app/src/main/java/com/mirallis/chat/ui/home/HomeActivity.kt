package com.mirallis.chat.ui.home

import android.os.Bundle
import android.view.MenuItem
import com.mirallis.chat.R
import com.mirallis.chat.domain.account.AccountEntity
import com.mirallis.chat.domain.type.None
import com.mirallis.chat.presentation.viewmodel.AccountViewModel
import com.mirallis.chat.ui.App
import com.mirallis.chat.ui.core.BaseActivity
import com.mirallis.chat.ui.core.ext.onFailure
import com.mirallis.chat.ui.core.ext.onSuccess

class HomeActivity : BaseActivity() {

    override val fragment = ChatsFragment()

    override val contentId = R.layout.activity_navigation

    private lateinit var accountViewModel: AccountViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        App.appComponent.inject(this)

        accountViewModel = viewModel {
            onSuccess(accountData, ::handleAccount)
            onSuccess(logoutData, ::handleLogout)
            onFailure(failureData, ::handleFailure)
        }

        accountViewModel.getAccount()

        supportActionBar?.setHomeAsUpIndicator(R.drawable.menu)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        return super.onOptionsItemSelected(item)
    }

    private fun handleAccount(account: AccountEntity?) {

    }

    private fun handleLogout(none: None? = None()) {

    }

    override fun onBackPressed() {

    }
}