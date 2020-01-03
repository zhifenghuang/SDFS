package com.testkotlin.sdfs.common.http

interface HttpListener<Data> {

    fun onSuccess(bean: Data)

    fun dataError(code: Int, msg: String)

    fun connectError(e: Throwable)
}