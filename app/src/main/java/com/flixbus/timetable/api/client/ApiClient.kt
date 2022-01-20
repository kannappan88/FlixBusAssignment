package com.flixbus.timetable.api.client

import com.flixbus.timetable.BuildConfig
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

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

    private fun getApiClient(): Retrofit {
        val logLevelType =
            if (BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BODY else HttpLoggingInterceptor.Level.NONE
        val logging = HttpLoggingInterceptor()
        logging.setLevel(logLevelType)

        //Logging
        val okhttpClient = OkHttpClient.Builder()

        //DEFAULT API HEADER
        okhttpClient.networkInterceptors().add { chain ->
            val requestBuilder = chain.request().newBuilder()
            requestBuilder.header(HEADER_AUTHORIZATION_KEY, HEADER_AUTHORIZATION_VALUE).build()
            requestBuilder.header("Content-Type", "application/json")
            chain.proceed(requestBuilder.build())
        }

        okhttpClient.addInterceptor(logging)

        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(okhttpClient.build())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val apiService: ApiService by lazy {
        getApiClient().create(ApiService::class.java)
    }

}