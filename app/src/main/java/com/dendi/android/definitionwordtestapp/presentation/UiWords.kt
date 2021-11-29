package com.dendi.android.definitionwordtestapp.presentation

import com.dendi.android.definitionwordtestapp.core.Abstract

/**
 * @author Dendy-Jr on 28.11.2021
 * olehvynnytskyi@gmail.com
 */
interface UiWords {

    fun map(mapper: Abstract.ListMapper<UiWord>)

    data class Base(private val words: List<UiWord>) : UiWords {
        override fun map(mapper: Abstract.ListMapper<UiWord>) = mapper.map(words)
    }
}

