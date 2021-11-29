package com.dendi.android.definitionwordtestapp.presentation.di.component

import com.dendi.android.definitionwordtestapp.presentation.MainActivity
import com.dendi.android.definitionwordtestapp.presentation.WordsFragment
import com.dendi.android.definitionwordtestapp.presentation.di.module.AppModule
import dagger.Component

/**
 * @author Dendy-Jr on 27.11.2021
 * olehvynnytskyi@gmail.com
 */

@Component(modules = [AppModule::class])
interface AppComponent {

    fun inject(activity: MainActivity)
    fun inject(fragment: WordsFragment)
}