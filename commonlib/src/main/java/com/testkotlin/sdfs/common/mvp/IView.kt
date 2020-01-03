package com.testkotlin.sdfs.common.mvp

interface IView {

    fun showLoading(tips: String)

    fun hideLoading()
}