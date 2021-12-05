package com.dendi.android.definitionwordtestapp.di.module

import com.dendi.android.definitionwordtestapp.core.Abstract
import com.dendi.android.definitionwordtestapp.core.ExceptionMapper
import com.dendi.android.definitionwordtestapp.core.ResourceProvider
import com.dendi.android.definitionwordtestapp.data.BaseToDataWordMapper
import com.dendi.android.definitionwordtestapp.data.WordsRepository
import com.dendi.android.definitionwordtestapp.data.cache.BaseToCacheWordMapper
import org.koin.dsl.module

/**
 * @author Dendy-Jr on 03.12.2021
 * olehvynnytskyi@gmail.com
 */
val dataModule = module {

    factory<ResourceProvider> {
        ResourceProvider.Base(context = get())
    }

    factory<Abstract.ToDataWordMapper> {
        BaseToDataWordMapper()
    }

    factory<Abstract.ToCacheWordMapper> {
        BaseToCacheWordMapper()
    }

    factory<ExceptionMapper> {
        ExceptionMapper.Base(resourceProvider = get())
    }

    factory<WordsRepository> {
        WordsRepository.Base(
            cloudDataSource = get(),
            cacheDataSource = get(),
            mapperCache = get(),
            mapperData = get(),
            exceptionMapper = get()
        )
    }
}