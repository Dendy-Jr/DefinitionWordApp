package com.dendi.android.definitionwordtestapp.core

import com.dendi.android.definitionwordtestapp.R
import retrofit2.HttpException
import java.lang.IllegalArgumentException
import java.net.SocketTimeoutException
import java.net.UnknownHostException

/**
 * @author Dendy-Jr on 29.11.2021
 * olehvynnytskyi@gmail.com
 */
interface ExceptionMapper : FactoryMapper<Exception, String> {

    class Base(private val resourceProvider: ResourceProvider) : ExceptionMapper {

        override fun map(data: Exception): String =
            when (data) {
                is UnknownHostException -> resourceProvider.provideString(R.string.no_connection_message)
                is HttpException -> resourceProvider.provideString(R.string.not_correctly_entered_word_error)
                is SocketTimeoutException -> resourceProvider.provideString(R.string.timeout_error)
                is NullPointerException -> resourceProvider.provideString(R.string.null_error)
                else -> throw IllegalArgumentException("data -> ExceptionMapper not found ${data.message}")
            }
    }
}