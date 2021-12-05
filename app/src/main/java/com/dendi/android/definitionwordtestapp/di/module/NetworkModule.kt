package com.dendi.android.definitionwordtestapp.di.module

import com.dendi.android.definitionwordtestapp.data.cloud.CloudDataSource
import com.dendi.android.definitionwordtestapp.data.cloud.WordService
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * @author Dendy-Jr on 03.12.2021
 * olehvynnytskyi@gmail.com
 */

private const val BASE_URL = "https://api.dictionaryapi.dev/"

val networkModule = module {

    factory<OkHttpClient> {
        OkHttpClient.Builder()
            .addInterceptor(HttpLoggingInterceptor().apply {
                level = HttpLoggingInterceptor.Level.BODY
            }).build()
    }

    factory<GsonConverterFactory> {
        GsonConverterFactory.create()
    }

    fun getRetrofit(
        client: OkHttpClient,
        gsonConverterFactory: GsonConverterFactory
    ): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(client)
            .addConverterFactory(gsonConverterFactory)
            .build()
    }

    factory { getRetrofit(get(), get()) }

    fun getWordServices(retrofit: Retrofit): WordService {
        return retrofit.create(WordService::class.java)
    }

    factory { getWordServices(get()) }

    factory<CloudDataSource> {
        CloudDataSource.Base(get())
    }
}