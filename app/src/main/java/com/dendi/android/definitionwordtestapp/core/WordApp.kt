package com.dendi.android.definitionwordtestapp.core

import android.app.Application
import com.dendi.android.definitionwordtestapp.BuildConfig
import com.dendi.android.definitionwordtestapp.di.*
import com.dendi.android.definitionwordtestapp.di.module.*
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level


/**
 * @author Dendy-Jr on 27.11.2021
 * olehvynnytskyi@gmail.com
 */
class WordApp : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger(if (BuildConfig.DEBUG) Level.ERROR else Level.NONE)
            androidContext(this@WordApp)
            modules(listOf(appModule, uiModule, cacheModule, networkModule, dataModule, domainModule))
        }
    }
}