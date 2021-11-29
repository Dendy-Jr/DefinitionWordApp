package com.dendi.android.definitionwordtestapp.core

import android.app.Application
import com.dendi.android.definitionwordtestapp.presentation.di.component.AppComponent
import com.dendi.android.definitionwordtestapp.presentation.di.component.DaggerAppComponent
import com.dendi.android.definitionwordtestapp.presentation.di.module.AppModule


/**
 * @author Dendy-Jr on 27.11.2021
 * olehvynnytskyi@gmail.com
 */
class WordApp : Application() {

    lateinit var component: AppComponent

    override fun onCreate() {
        super.onCreate()

        component = DaggerAppComponent
            .builder()
            .appModule(AppModule(this))
            .build()
    }
}