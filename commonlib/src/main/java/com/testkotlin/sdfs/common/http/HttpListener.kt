package com.testkotlin.sdfs.common.http

interface HttpListener<Data> {

    fun onNext(bean: Data)

    fun onError(e: Throwable)
}