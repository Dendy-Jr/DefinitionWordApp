package com.dendi.android.definitionwordtestapp.di.module

import com.dendi.android.definitionwordtestapp.presentation.Communication
import com.dendi.android.definitionwordtestapp.presentation.UiWords
import org.koin.dsl.module

/**
 * @author Dendy-Jr on 03.12.2021
 * olehvynnytskyi@gmail.com
 */

val uiModule = module {

    factory<Communication<UiWords>> {
        Communication.Base()
    }
}