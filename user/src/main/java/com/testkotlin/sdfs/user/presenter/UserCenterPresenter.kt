package com.testkotlin.sdfs.user.presenter

import com.testkotlin.sdfs.common.mvp.BasePresenter
import com.testkotlin.sdfs.user.contract.DiscoverContract
import com.testkotlin.sdfs.user.contract.FindPasswordContract
import com.testkotlin.sdfs.user.contract.UserCenterContract

class UserCenterPresenter(view:UserCenterContract.View) :BasePresenter<UserCenterContract.View>(view),UserCenterContract.Presenter{
}