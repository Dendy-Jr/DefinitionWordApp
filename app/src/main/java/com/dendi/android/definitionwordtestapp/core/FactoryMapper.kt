package com.dendi.android.definitionwordtestapp.core

/**
 * @author Dendy-Jr on 29.11.2021
 * olehvynnytskyi@gmail.com
 */
interface FactoryMapper<S, R>: Abstract.Mapper {
    fun map(data: S): R
}