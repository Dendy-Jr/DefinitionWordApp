package com.dendi.android.definitionwordtestapp.di.module

import com.dendi.android.definitionwordtestapp.core.Abstract
import com.dendi.android.definitionwordtestapp.data.BaseToDomainWordMapper
import com.dendi.android.definitionwordtestapp.domain.DomainWords
import com.dendi.android.definitionwordtestapp.domain.WordsInteractor
import org.koin.dsl.module

/**
 * @author Dendy-Jr on 03.12.2021
 * olehvynnytskyi@gmail.com
 */

val domainModule = module {

    factory<WordsInteractor> {
        WordsInteractor.Base(repository = get(), mapper = get())
    }

    factory<Abstract.WordsDataToDomainMapper> {
        Abstract.WordsDataToDomainMapper.Base(BaseToDomainWordMapper())
    }
}