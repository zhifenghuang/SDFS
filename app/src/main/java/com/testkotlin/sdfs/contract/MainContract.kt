package com.testkotlin.sdfs.contract

import com.testkotlin.sdfs.common.mvp.IPresenter
import com.testkotlin.sdfs.common.mvp.IView

interface MainContract {

    interface View : IView {

        fun getUserSuccess()

        fun getUserFailed()
    }

    interface Presenter : IPresenter {
        fun getUserInfo()
    }
}