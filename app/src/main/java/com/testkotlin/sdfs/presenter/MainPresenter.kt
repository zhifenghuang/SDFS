package com.testkotlin.sdfs.presenter

import com.testkotlin.sdfs.common.mvp.BasePresenter
import com.testkotlin.sdfs.contract.MainContract

class MainPresenter(rootView: MainContract.View) : BasePresenter<MainContract.View>(rootView), MainContract.Presenter {

    override fun getUserInfo() {

    }
}