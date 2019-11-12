package com.mirallis.chat.presentation.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.mirallis.chat.domain.type.HandleOnce
import com.mirallis.chat.domain.type.Failure

abstract class BaseViewModel : ViewModel() {

    var failureData: MutableLiveData<HandleOnce<Failure>> = MutableLiveData()

    protected fun handleFailure(failure: Failure) {
        this.failureData.value = HandleOnce(failure)
    }
}