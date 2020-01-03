package com.testkotlin.sdfs.common.http

import com.testkotlin.sdfs.common.bean.BasicResponse
import com.testkotlin.sdfs.common.bean.UserBean
import io.reactivex.Observable

interface IApi {

    fun login(): Observable<BasicResponse<UserBean>>
}