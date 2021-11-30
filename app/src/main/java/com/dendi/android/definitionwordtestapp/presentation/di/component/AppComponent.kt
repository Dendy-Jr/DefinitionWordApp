package com.dendi.android.definitionwordtestapp.presentation.di.component

import android.content.Context
import com.dendi.android.definitionwordtestapp.presentation.MainActivity
import com.dendi.android.definitionwordtestapp.presentation.fragments.WordsFragment
import com.dendi.android.definitionwordtestapp.presentation.di.module.AppModule
import com.dendi.android.definitionwordtestapp.presentation.fragments.MeaningsFragment
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

/**
 * @author Dendy-Jr on 27.11.2021
 * olehvynnytskyi@gmail.com
 */

@Singleton
@Component(modules = [AppModule::class])
interface AppComponent {

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun context(context: Context): Builder

        fun build(): AppComponent
    }

    fun inject(activity: MainActivity)
    fun inject(fragment: WordsFragment)
    fun inject(fragment: MeaningsFragment)
}