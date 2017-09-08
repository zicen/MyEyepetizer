package com.zhenquan.myeyepetizer.net

import android.util.Log
import com.xk.eyepetizer.net.ApiService
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

/**
 * Created by zhenquan on 2017/9/8.
 */
object Network {
    private val retrofit: Retrofit
    private val base_url: String = "http://baobab.kaiyanapp.com/api/"
    private val DEFAULT_TIMEOUT = 5L
    private val okHttpClient: OkHttpClient

    init {
        val longging = Interceptor { chain ->
            val request = chain.request()
            Log.d("okhttp", "okhttp--->" + request.url().toString())
            chain.proceed(request)
        }
        okHttpClient = OkHttpClient.Builder()
                .connectTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS)
                .addInterceptor(longging)
                .build()

        retrofit = Retrofit.Builder()
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .baseUrl(base_url)
                .build()
    }

    val service:ApiService by lazy { retrofit.create(ApiService::class.java) }
}