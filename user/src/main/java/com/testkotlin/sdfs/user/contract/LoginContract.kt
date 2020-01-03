package com.testkotlin.sdfs.user.contract

import com.testkotlin.sdfs.common.mvp.IPresenter
import com.testkotlin.sdfs.common.mvp.IView

interface LoginContract {
    interface View : IView {
        fun loginSuccess()
        fun loginFailed()
    }

    interface Presenter : IPresenter {
        fun login(account: String, password: String)
    }
}