package com.dendi.android.definitionwordtestapp.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.dendi.android.definitionwordtestapp.core.Abstract
import com.dendi.android.definitionwordtestapp.core.ResourceProvider
import com.dendi.android.definitionwordtestapp.domain.WordsInteractor

/**
 * @author Dendy-Jr on 27.11.2021
 * olehvynnytskyi@gmail.com
 */
interface WordsViewModelFactory : ViewModelProvider.Factory {

    class Base(
        private val interactor: WordsInteractor,
        private val resourceProvider: ResourceProvider
    ) : WordsViewModelFactory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return WordsViewModel.Base(
                interactor,
                Communication.Base(),
                Abstract.WordsDomainToUiMapper.Base(BaseUiWordMapper()),
                resourceProvider
            ) as T
        }
    }
}