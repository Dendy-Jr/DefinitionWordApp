package com.dendi.android.definitionwordtestapp.presentation.di.module

import com.dendi.android.definitionwordtestapp.core.ResourceProvider
import com.dendi.android.definitionwordtestapp.domain.WordsInteractor
import com.dendi.android.definitionwordtestapp.presentation.Communication
import com.dendi.android.definitionwordtestapp.presentation.UiWords
import com.dendi.android.definitionwordtestapp.presentation.WordsViewModelFactory
import dagger.Module
import dagger.Provides

/**
 * @author Dendy-Jr on 27.11.2021
 * olehvynnytskyi@gmail.com
 */
@Module
class UiModule {

    @Provides
    fun provideWordViewModelFactory(
        interactor: WordsInteractor,
        resourceProvider: ResourceProvider
    ): WordsViewModelFactory {
        return WordsViewModelFactory.Base(interactor, resourceProvider)
    }

    @Provides
    fun provideCommunication(): Communication<UiWords> {
        return Communication.Base()
    }
}