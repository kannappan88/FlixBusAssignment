package com.flixbus.timetable.api.client

import com.flixbus.timetable.BuildConfig
import com.flixbus.timetable.FlixbusApplication
import com.flixbus.timetable.util.NetworkUtil
import okhttp3.Cache
import okhttp3.CacheControl
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.File
import java.util.concurrent.TimeUnit


/**
 * Project           : FlixbusTimetable
 * File Name         : ApiClient
 * Description       :
 * Revision History  : version 1
 * Date              : 20/01/22
 * Original author   : Kannappan
 * Description       : Initial version
 */
object ApiClient {

    private const val BASE_URL = "https://global.api-dev.flixbus.com/"
    private const val HEADER_AUTHORIZATION_KEY = "X-Api-Authentication"
    private const val HEADER_AUTHORIZATION_VALUE = "intervIEW_TOK3n"
    private const val CACHE_MAX_STALE = 60 * 60 * 24 * 1 // 1day
    private const val CACHE_MAX_AGE = 60// 60 seconds
    private const val CACHE_FOLDER_NAME = "offlineCache"
    private const val CACHE_MAX_SIZE = 10 * 1024 * 1024L //10 MB

    private fun getApiClient(): Retrofit {
        //Log level
        val logLevelType =
            if (BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BODY else HttpLoggingInterceptor.Level.NONE
        val logging = HttpLoggingInterceptor()
        logging.setLevel(logLevelType)

        //Cache directory
        val httpCacheDirectory =
            File(FlixbusApplication.application?.cacheDir, CACHE_FOLDER_NAME)
        val cache = Cache(httpCacheDirectory, CACHE_MAX_SIZE)

        //HTTP CLIENT
        val okhttpClient = OkHttpClient.Builder()
        okhttpClient.addInterceptor(logging)
        okhttpClient.addNetworkInterceptor(cacheInterceptor)
        okhttpClient.cache(cache)

        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(okhttpClient.build())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val apiService: ApiService by lazy {
        getApiClient().create(ApiService::class.java)
    }

    private val cacheInterceptor = Interceptor { chain ->
        val cacheBuilder = CacheControl.Builder()
        cacheBuilder.maxAge(30, TimeUnit.SECONDS)
        cacheBuilder.maxStale(1, TimeUnit.DAYS)
        val cacheControl: CacheControl = cacheBuilder.build()
        var request = chain.request()
        request = request.newBuilder().header(HEADER_AUTHORIZATION_KEY, HEADER_AUTHORIZATION_VALUE).build()

        if (isOnline()) {
            request = request.newBuilder()
                .cacheControl(cacheControl)
                .build()
        }

        val originalResponse = chain.proceed(request)
        if (isOnline()) {
            originalResponse.newBuilder()
                .header("Cache-Control", "public, max-age=$CACHE_MAX_AGE")
                .build()
        } else {
            originalResponse.newBuilder()
                .header("Cache-Control", "public, only-if-cached, max-stale=$CACHE_MAX_STALE")
                .build()
        }
    }

    private fun isOnline(): Boolean {
        return NetworkUtil.isNetworkOnline(FlixbusApplication.application?.applicationContext!!)
    }

}