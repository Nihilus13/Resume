package com.nihilus13.data.repository.api

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.nihilus13.data.BuildConfig
import com.nihilus13.dateutils.DateConstants
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiProvider {

    private lateinit var api: ApiService

    private fun prepareOkhttpClient(): OkHttpClient =
        with(OkHttpClient.Builder()) {
            if (BuildConfig.DEBUG) {
                val logging = HttpLoggingInterceptor()
                logging.setLevel(HttpLoggingInterceptor.Level.BODY)
                addInterceptor(logging)
            }
            addInterceptor {
                val original = it.request()

                val request = original.newBuilder()
                    .method(original.method, original.body)
                    .build()

                it.proceed(request)
            }
        }.build()

    private fun prepareGson(): Gson = GsonBuilder()
        .setDateFormat(DateConstants.DATE_PATTERN)
        .create()

    private fun getService(url: String): ApiService =
        Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create(prepareGson()))
            .client(prepareOkhttpClient())
            .baseUrl(url)
            .build()
            .create(ApiService::class.java)


    private fun initService() {
        val url = BuildConfig.API_URL
        api = getService(url)
    }

    fun getService(): ApiService {
        if (!ApiProvider::api.isInitialized) {
            initService()
        }
        return api
    }
}