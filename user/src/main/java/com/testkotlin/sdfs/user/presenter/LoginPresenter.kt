package com.testkotlin.sdfs.user.presenter

import com.testkotlin.sdfs.common.bean.UserBean
import com.testkotlin.sdfs.common.http.Api
import com.testkotlin.sdfs.common.http.HttpListener
import com.testkotlin.sdfs.common.http.HttpObserver
import com.testkotlin.sdfs.common.mvp.BasePresenter
import com.testkotlin.sdfs.user.contract.LoginContract

class LoginPresenter(view: LoginContract.View) : BasePresenter<LoginContract.View>(view),
    LoginContract.Presenter {


    override fun login(account: String, password: String) {
        Api.getInstance().login(account,password,
            HttpObserver(mRootView, object : HttpListener<UserBean> {
                override fun onSuccess(bean: UserBean) {
                    mRootView?.loginSuccess()
                }

                override fun dataError(code: Int, msg: String) {

                }

                override fun connectError(e: Throwable) {

                }
            })
        )
    }
}