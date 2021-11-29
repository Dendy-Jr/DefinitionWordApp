package com.dendi.android.definitionwordtestapp.core

import com.dendi.android.definitionwordtestapp.data.DataDefinition
import com.dendi.android.definitionwordtestapp.data.DataMeaning
import com.dendi.android.definitionwordtestapp.data.DataWord
import com.dendi.android.definitionwordtestapp.data.cache.CacheDefinition
import com.dendi.android.definitionwordtestapp.data.cache.CacheMeaning
import com.dendi.android.definitionwordtestapp.domain.DomainDefinition
import com.dendi.android.definitionwordtestapp.domain.DomainMeaning
import com.dendi.android.definitionwordtestapp.domain.DomainWord
import com.dendi.android.definitionwordtestapp.domain.DomainWords
import com.dendi.android.definitionwordtestapp.presentation.UiDefinition
import com.dendi.android.definitionwordtestapp.presentation.UiMeaning
import com.dendi.android.definitionwordtestapp.presentation.UiWord
import com.dendi.android.definitionwordtestapp.presentation.UiWords


/**
 * @author Dendy-Jr on 27.11.2021
 * olehvynnytskyi@gmail.com
 */
interface Abstract {

    interface ToCacheWordMapper<T> : Mapper {
        fun map(
            id: Long,
            word: String,
            phonetic: String,
            origin: String,
            meanings: List<CacheMeaning.Base>
        ): T
    }

    interface ToDataWordMapper<T> : Mapper {
        fun map(
            id: Long,
            word: String,
            phonetic: String,
            origin: String,
            meanings: List<DataMeaning.Base>
        ): T
    }

    interface ToDomainWordMapper<T> : Mapper {
        fun map(
            id: Long,
            word: String,
            phonetic: String,
            origin: String,
            meanings: List<DomainMeaning.Base>
        ): T
    }

    interface UiWordMapper<T> : Mapper {
        fun map(
            id: Long,
            word: String,
            phonetic: String,
            origin: String,
            meanings: List<UiMeaning.Base>
        ): T

        fun map(message: String): T
    }

    interface ToCacheMeaningMapper<T> : Mapper {
        fun map(id: Long, partOfSpeech: String, definitions: List<CacheDefinition.Base>): T
    }

    interface ToDataMeaningMapper<T> : Mapper {
        fun map(id: Long, partOfSpeech: String, definitions: List<DataDefinition.Base>): T
    }

    interface ToDomainMeaningMapper<T> : Mapper {
        fun map(id: Long, partOfSpeech: String, definitions: List<DomainDefinition.Base>): T
    }

    interface UiMeaningMapper<T> : Mapper {
        fun map(id: Long, partOfSpeech: String, definitions: List<UiDefinition.Base>): T
    }

    interface DefinitionMapper<T> : Mapper {
        fun map(
            id: Long,
            antonyms: List<Any>,
            definition: String,
            example: String,
            synonyms: List<String>
        ): T
    }

    interface WordsDataToDomainMapper<T> : Mapper {
        fun map(words: List<DataWord>): T
        fun map(message: String): T

        class Base(private val mapper: ToDomainWordMapper<DomainWord>) :
            WordsDataToDomainMapper<DomainWords> {
            override fun map(words: List<DataWord>): DomainWords {
                return DomainWords.Success(words.map { it.map(mapper) })
            }

            override fun map(message: String): DomainWords {
                return DomainWords.Failure(message)
            }
        }
    }

    interface WordsDomainToUiMapper<T> : Mapper {
        fun map(words: List<DomainWord>): T
        fun map(message: String): T

        class Base(private val mapper: UiWordMapper<UiWord>) :
            WordsDomainToUiMapper<UiWords> {
            override fun map(words: List<DomainWord>): UiWords =
                UiWords.Base(words.map { it.map(mapper) })

            override fun map(message: String) =
                UiWords.Base(listOf(UiWord.Failure(message)))
        }
    }

    interface ListMapper<S> : Mapper {
        fun map(data: List<S>)
    }

    interface Mapper
}