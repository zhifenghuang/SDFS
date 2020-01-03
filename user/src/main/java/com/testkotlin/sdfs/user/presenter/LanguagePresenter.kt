package com.testkotlin.sdfs.user.presenter

import com.testkotlin.sdfs.common.mvp.BasePresenter
import com.testkotlin.sdfs.user.contract.LanguageContract

class LanguagePresenter(view:LanguageContract.View) :BasePresenter<LanguageContract.View>(view),LanguageContract.Presenter {
}