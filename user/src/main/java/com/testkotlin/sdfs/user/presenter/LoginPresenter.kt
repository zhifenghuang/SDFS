package com.testkotlin.sdfs.user.presenter

import com.testkotlin.sdfs.common.bean.UserBean
import com.testkotlin.sdfs.common.http.Api
import com.testkotlin.sdfs.common.http.HttpListener
import com.testkotlin.sdfs.common.http.HttpObserver
import com.testkotlin.sdfs.common.mvp.BasePresenter
import com.testkotlin.sdfs.user.contract.LoginContract

class LoginPresenter(view: LoginContract.View) : BasePresenter<LoginContract.View>(view),
    LoginContract.Presenter {


    override fun login() {
        Api.getInstance().login(
            HttpObserver(mRootView, object : HttpListener<UserBean> {
                override fun onNext(bean: UserBean) {

                }

                override fun dataError(code: Int, msg: String) {

                }

                override fun onError(e: Throwable) {

                }
            })
        )
    }
}