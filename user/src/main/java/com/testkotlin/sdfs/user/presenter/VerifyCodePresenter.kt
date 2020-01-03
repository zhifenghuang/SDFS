package com.testkotlin.sdfs.user.presenter

import com.testkotlin.sdfs.common.mvp.BasePresenter
import com.testkotlin.sdfs.user.contract.FindPasswordContract
import com.testkotlin.sdfs.user.contract.VerifyCodeContract

class VerifyCodePresenter(view: VerifyCodeContract.View) :
    BasePresenter<VerifyCodeContract.View>(view), VerifyCodeContract.Presenter {
}