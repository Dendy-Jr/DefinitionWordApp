package com.dendi.android.definitionwordtestapp.presentation.di.module

import com.dendi.android.definitionwordtestapp.core.Abstract
import com.dendi.android.definitionwordtestapp.data.BaseToDomainWordMapper
import com.dendi.android.definitionwordtestapp.data.WordsRepository
import com.dendi.android.definitionwordtestapp.domain.WordsInteractor
import dagger.Module
import dagger.Provides

/**
 * @author Dendy-Jr on 28.11.2021
 * olehvynnytskyi@gmail.com
 */
@Module
class DomainModule {

    @Provides
    fun provideWordsInteractor(
        repository: WordsRepository
    ): WordsInteractor {
        return WordsInteractor.Base(
            repository,
            Abstract.WordsDataToDomainMapper.Base(
                BaseToDomainWordMapper()
            )
        )
    }
}