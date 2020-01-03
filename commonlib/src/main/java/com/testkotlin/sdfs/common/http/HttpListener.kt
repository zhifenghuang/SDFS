package com.testkotlin.sdfs.common.http

interface HttpListener<Data> {

    fun onNext(bean: Data)

    fun dataError(code: Int, msg: String)

    fun onError(e: Throwable)
}