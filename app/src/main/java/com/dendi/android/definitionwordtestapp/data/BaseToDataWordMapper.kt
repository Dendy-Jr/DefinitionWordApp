package com.dendi.android.definitionwordtestapp.data

import com.dendi.android.definitionwordtestapp.core.Abstract

/**
 * @author Dendy-Jr on 28.11.2021
 * olehvynnytskyi@gmail.com
 */
class BaseToDataWordMapper : Abstract.ToDataWordMapper<DataWord.Base> {
    override fun map(
        id: Long,
        word: String,
        phonetic: String,
        origin: String,
        meanings: List<DataMeaning.Base>
    ) = DataWord.Base(id, word, phonetic, origin, meanings)
}
