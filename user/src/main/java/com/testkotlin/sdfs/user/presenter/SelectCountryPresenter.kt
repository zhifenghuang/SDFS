package com.testkotlin.sdfs.user.presenter

import com.testkotlin.sdfs.common.mvp.BasePresenter
import com.testkotlin.sdfs.user.contract.FindPasswordContract
import com.testkotlin.sdfs.user.contract.SelectCountryContract

class SelectCountryPresenter(view:SelectCountryContract.View) :BasePresenter<SelectCountryContract.View>(view),SelectCountryContract.Presenter {
}