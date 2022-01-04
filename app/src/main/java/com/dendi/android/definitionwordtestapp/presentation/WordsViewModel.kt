package com.dendi.android.definitionwordtestapp.presentation

import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Build
import androidx.lifecycle.*
import com.dendi.android.definitionwordtestapp.core.Abstract
import com.dendi.android.definitionwordtestapp.core.ResourceProvider
import com.dendi.android.definitionwordtestapp.domain.WordsInteractor
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

/**
 * @author Dendy-Jr on 27.11.2021
 * olehvynnytskyi@gmail.com
 */

class WordsViewModel(
    private val interactor: WordsInteractor,
    private val communication: Communication<UiWords>,
    private val mapper: Abstract.WordsDomainToUiMapper,
    private val resourceProvider: ResourceProvider
) : ViewModel() {

    fun observe(owner: LifecycleOwner, observer: Observer<UiWords>) =
        communication.observe(owner, observer)

    fun fetchWordDefinition(srsWord: String) {
        communication.postValue(UiWords.Base(listOf(UiWord.Progress)))
        viewModelScope.launch(Dispatchers.IO) {
            val resultUi: UiWords =
                if (checkInternetConnection(resourceProvider.getSystemService())) {
                    val resultDomain = interactor.readOnlineData(srsWord)
                    resultDomain.mapper(mapper)
                } else {
                    val resultDomain = interactor.readOfflineData(srsWord)
                    resultDomain.mapper(mapper)
                }
            withContext(Dispatchers.Main) {
                communication.postValue(resultUi)
            }
        }
    }

    private fun checkInternetConnection(connectivityManager: ConnectivityManager): Boolean {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {

            val network = connectivityManager.activeNetwork ?: return false
            val activeNetwork =
                connectivityManager.getNetworkCapabilities(network) ?: return false
            return when {
                activeNetwork.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) -> true
                activeNetwork.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) -> true
                else -> false
            }
        } else {
            @Suppress("DEPRECATION") val networkInfo =
                connectivityManager.activeNetworkInfo ?: return false
            @Suppress("DEPRECATION")
            return networkInfo.isConnected
        }
    }
}
