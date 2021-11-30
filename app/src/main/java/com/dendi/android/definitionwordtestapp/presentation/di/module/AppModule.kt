package com.dendi.android.definitionwordtestapp.presentation.di.module

import android.content.Context
import com.dendi.android.definitionwordtestapp.core.ResourceProvider
import dagger.Module
import dagger.Provides

/**
 * @author Dendy-Jr on 27.11.2021
 * olehvynnytskyi@gmail.com
 */
@Module(includes = [CacheModule::class, DataModule::class, DomainModule::class, UiModule::class])
class AppModule {

    @Provides
    fun provideResourceProvider(context: Context): ResourceProvider {
        return ResourceProvider.Base(context)
    }
}