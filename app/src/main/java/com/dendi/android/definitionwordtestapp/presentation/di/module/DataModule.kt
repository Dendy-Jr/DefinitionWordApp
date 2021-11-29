package com.dendi.android.definitionwordtestapp.presentation.di.module

import com.dendi.android.definitionwordtestapp.core.Abstract
import com.dendi.android.definitionwordtestapp.core.ExceptionMapper
import com.dendi.android.definitionwordtestapp.core.ResourceProvider
import com.dendi.android.definitionwordtestapp.data.BaseToDataWordMapper
import com.dendi.android.definitionwordtestapp.data.DataWord
import com.dendi.android.definitionwordtestapp.data.WordsRepository
import com.dendi.android.definitionwordtestapp.data.cache.BaseToCacheWordMapper
import com.dendi.android.definitionwordtestapp.data.cache.CacheDataSource
import com.dendi.android.definitionwordtestapp.data.cache.CacheWord
import com.dendi.android.definitionwordtestapp.data.cloud.CloudDataSource
import dagger.Module
import dagger.Provides

/**
 * @author Dendy-Jr on 27.11.2021
 * olehvynnytskyi@gmail.com
 */
@Module(includes = [NetworkModule::class])
class DataModule {

    @Provides
    fun provideWordRepository(
        cloudDataSource: CloudDataSource,
        cacheDataSource: CacheDataSource,
        mapperCache: Abstract.ToCacheWordMapper<CacheWord.Base>,
        mapperData: Abstract.ToDataWordMapper<DataWord.Base>,
        resourceProvider: ResourceProvider
    ): WordsRepository {
        return WordsRepository.Base(
            cloudDataSource,
            cacheDataSource,
            mapperCache,
            mapperData,
            ExceptionMapper.Base(resourceProvider)
        )
    }

    @Provides
    fun provideDataWordMapper(): Abstract.ToDataWordMapper<DataWord.Base> {
        return BaseToDataWordMapper()
    }

    @Provides
    fun provideCacheWordMapper(): Abstract.ToCacheWordMapper<CacheWord.Base> {
        return BaseToCacheWordMapper()
    }
}