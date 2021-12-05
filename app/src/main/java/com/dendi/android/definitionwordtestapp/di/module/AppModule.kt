package com.dendi.android.definitionwordtestapp.di.module

import com.dendi.android.definitionwordtestapp.core.Abstract
import com.dendi.android.definitionwordtestapp.presentation.BaseUiWordMapper
import com.dendi.android.definitionwordtestapp.presentation.UiWords
import com.dendi.android.definitionwordtestapp.presentation.WordsViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

/**
 * @author Dendy-Jr on 03.12.2021
 * olehvynnytskyi@gmail.com
 */
val appModule = module {

    single<Abstract.WordsDomainToUiMapper> {
        Abstract.WordsDomainToUiMapper.Base(BaseUiWordMapper())
    }

    viewModel<WordsViewModel> {
        WordsViewModel(
            interactor = get(),
            communication = get(),
            mapper = get(),
            resourceProvider = get()
        )
    }
}