package com.dendi.android.definitionwordtestapp.presentation

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer


/**
 * @author Dendy-Jr on 27.11.2021
 * olehvynnytskyi@gmail.com
 */
interface Communication<T> {

    fun observe(owner: LifecycleOwner, observer: Observer<T>)

    fun postValue(value: T)

    class Base : Communication<UiWords> {

        private val liveData = MutableLiveData<UiWords>()

        override fun observe(owner: LifecycleOwner, observer: Observer<UiWords>) =
            liveData.observe(owner, observer)

        override fun postValue(value: UiWords) {
            liveData.value = value
        }
    }
}