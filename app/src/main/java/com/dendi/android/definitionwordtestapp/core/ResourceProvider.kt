package com.dendi.android.definitionwordtestapp.core

import android.content.Context
import android.net.ConnectivityManager
import androidx.annotation.StringRes

/**
 * @author Dendy-Jr on 29.11.2021
 * olehvynnytskyi@gmail.com
 */
interface ResourceProvider {

    fun provideString(@StringRes id: Int): String

    fun getSystemService(): ConnectivityManager

    class Base(private val context: Context): ResourceProvider {
        override fun provideString(id: Int) = context.getString(id)

        override fun getSystemService(): ConnectivityManager {
            return context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        }
    }
}