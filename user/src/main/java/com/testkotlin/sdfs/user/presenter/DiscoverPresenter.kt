package com.testkotlin.sdfs.user.presenter

import com.testkotlin.sdfs.common.mvp.BasePresenter
import com.testkotlin.sdfs.user.contract.DiscoverContract
import com.testkotlin.sdfs.user.contract.FindPasswordContract

class DiscoverPresenter(view:DiscoverContract.View) :BasePresenter<DiscoverContract.View>(view),DiscoverContract.Presenter{
}