package com.dendi.android.definitionwordtestapp.presentation.di.module

import com.dendi.android.definitionwordtestapp.data.cloud.CloudDataSource
import com.dendi.android.definitionwordtestapp.data.cloud.WordService
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * @author Dendy-Jr on 27.11.2021
 * olehvynnytskyi@gmail.com
 */
@Module
class NetworkModule {

    private companion object {
        private const val BASE_URL = "https://api.dictionaryapi.dev/"
    }

    @Provides
    fun provideClient(): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(HttpLoggingInterceptor().apply {
                level = HttpLoggingInterceptor.Level.BODY
            })
            .build()
    }

    @Provides
    fun provideGson(): GsonConverterFactory = GsonConverterFactory.create()

    @Provides
    fun provideRetrofit(
        client: OkHttpClient,
        gsonConverterFactory: GsonConverterFactory
    ): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(client)
            .addConverterFactory(gsonConverterFactory)
            .build()
    }

    @Provides
    fun provideWordService(retrofit: Retrofit): WordService {
        return retrofit.create(WordService::class.java)
    }

    @Provides
    fun provideBaseCloudDataSource(service: WordService): CloudDataSource {
        return CloudDataSource.Base(service)
    }

}