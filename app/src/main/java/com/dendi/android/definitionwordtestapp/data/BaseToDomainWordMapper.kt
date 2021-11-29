package com.dendi.android.definitionwordtestapp.data

import com.dendi.android.definitionwordtestapp.core.Abstract
import com.dendi.android.definitionwordtestapp.domain.DomainMeaning
import com.dendi.android.definitionwordtestapp.domain.DomainWord

/**
 * @author Dendy-Jr on 29.11.2021
 * olehvynnytskyi@gmail.com
 */
class BaseToDomainWordMapper : Abstract.ToDomainWordMapper<DomainWord> {
    override fun map(
        id: Long,
        word: String,
        phonetic: String,
        origin: String,
        meanings: List<DomainMeaning.Base>
    ) = DomainWord.Base(id, word, phonetic, origin, meanings)
}