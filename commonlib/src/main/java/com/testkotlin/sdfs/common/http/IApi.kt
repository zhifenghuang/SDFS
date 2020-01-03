package com.testkotlin.sdfs.common.http

import com.testkotlin.sdfs.common.bean.BasicResponse
import com.testkotlin.sdfs.common.bean.UserBean
import io.reactivex.Observable
import okhttp3.RequestBody
import retrofit2.http.Multipart
import retrofit2.http.POST
import retrofit2.http.Part

interface IApi {


    @Multipart
    @POST("api/v1/passport/login")
    fun login(@Part("loginAccount") loginAccount:RequestBody ,
              @Part("loginPassword") loginPassword: RequestBody
    ): Observable<BasicResponse<UserBean>>
}