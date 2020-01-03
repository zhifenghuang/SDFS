package com.testkotlin.sdfs.user.presenter

import com.testkotlin.sdfs.common.mvp.BasePresenter
import com.testkotlin.sdfs.user.contract.RegisterContract
import com.testkotlin.sdfs.user.contract.ResetPasswordContract

class RegisterPresenter(view:RegisterContract.View) :BasePresenter<RegisterContract.View>(view),ResetPasswordContract.Presenter {
}