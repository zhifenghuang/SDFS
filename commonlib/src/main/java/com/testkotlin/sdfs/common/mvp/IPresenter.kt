package com.testkotlin.sdfs.common.mvp

interface IPresenter {

    /**
     * 做一些初始化操作
     */
    abstract fun onStart()

    /**
     * 在框架中 { Activity#onDestroy() } 时会默认调用 [IPresenter.onDestroy]
     */
    abstract fun onDestroy()
}