package com.testkotlin.sdfs.user.presenter

import com.testkotlin.sdfs.common.mvp.BasePresenter
import com.testkotlin.sdfs.user.contract.LoginContract

class LoginPresenter(view:LoginContract.View) :BasePresenter<LoginContract.View>(view),LoginContract.Presenter {
}