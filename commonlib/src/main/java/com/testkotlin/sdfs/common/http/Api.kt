package com.testkotlin.sdfs.common.http

import android.util.Log
import com.google.gson.GsonBuilder
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import com.testkotlin.sdfs.common.bean.BasicResponse
import com.testkotlin.sdfs.common.bean.UserBean
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.annotations.NonNull
import io.reactivex.functions.Predicate
import io.reactivex.schedulers.Schedulers
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.apache.http.conn.ConnectTimeoutException
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.net.ConnectException
import java.net.SocketTimeoutException
import java.util.concurrent.TimeUnit
import java.util.concurrent.TimeoutException

class Api private constructor() {

    private val TAG: String = "Api"

    private var mRetrofit: Retrofit? = null
    private val DEFAULT_TIMEOUT = 10

    init {
        val builder = OkHttpClient.Builder();
        val loggingInterceptor =
            HttpLoggingInterceptor(HttpLoggingInterceptor.Logger { message -> Log.i(TAG, message) })


//        val interceptor = Interceptor { chain ->
//            val request: Request
        //           if (!TextUtils.isEmpty()) {
//                request = chain.request()
//                    .newBuilder()
//                    .addHeader("Authorization", "token)
//                    .build()
//            } else {
//                request = chain.request()
//                    .newBuilder()
//                    .build()
//            }
        //           chain.proceed(request)
//        }

        loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
        builder.connectTimeout(DEFAULT_TIMEOUT.toLong(), TimeUnit.SECONDS)
            //          .addInterceptor(interceptor)
            .addInterceptor(loggingInterceptor)
        mRetrofit = Retrofit.Builder()
            .client(builder.build())
            .addConverterFactory(
                GsonConverterFactory.create(
                    GsonBuilder()
                        .setLenient()
                        .create()
                )
            )
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .baseUrl(getBaseUrl())
            .build()
    }

    private fun getBaseUrl(): String {
        return "";
    }

    companion object {
        @Volatile
        private var instance: Api? = null

        fun getInstance() =
            instance ?: synchronized(this) {
                instance ?: Api().also { instance = it }
            }
    }

    fun login(observer: HttpObserver<BasicResponse<UserBean>, UserBean>) {
        val iApi = mRetrofit?.create(IApi::class.java)
        val observable = iApi?.login()
        toSubscribe(observable, observer)
    }

    private fun <T : BasicResponse<Data>, Data> toSubscribe(
        observable: Observable<T>?,
        observer: HttpObserver<T, Data>
    ) {
        observable?.retry(2) { throwable ->
            throwable is SocketTimeoutException ||
                    throwable is ConnectException ||
                    throwable is TimeoutException
        }?.subscribeOn(Schedulers.io())
            ?.unsubscribeOn(Schedulers.io())
            ?.observeOn(AndroidSchedulers.mainThread())
            ?.subscribe(observer)
    }

}