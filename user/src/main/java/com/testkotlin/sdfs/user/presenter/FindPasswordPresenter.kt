package com.testkotlin.sdfs.user.presenter

import com.testkotlin.sdfs.common.mvp.BasePresenter
import com.testkotlin.sdfs.user.contract.FindPasswordContract

class FindPasswordPresenter(view:FindPasswordContract.View) :BasePresenter<FindPasswordContract.View>(view),FindPasswordContract.Presenter{
}