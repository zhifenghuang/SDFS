package com.testkotlin.sdfs.common.http

import com.testkotlin.sdfs.common.bean.BasicResponse
import com.testkotlin.sdfs.common.bean.UserBean
import io.reactivex.Observable
import retrofit2.http.POST

interface IApi {


    @POST("/login")
    fun login(): Observable<BasicResponse<UserBean>>
}