package com.testkotlin.sdfs.user.presenter

import com.testkotlin.sdfs.common.mvp.BasePresenter
import com.testkotlin.sdfs.user.contract.RegisterContract
import com.testkotlin.sdfs.user.contract.ResetPasswordContract

class ResetPasswordPresenter(view:ResetPasswordContract.View) : BasePresenter<ResetPasswordContract.View>(view),ResetPasswordContract.Presenter {
}