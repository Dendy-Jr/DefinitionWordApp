package com.dendi.android.definitionwordtestapp.core

import com.dendi.android.definitionwordtestapp.data.DataDefinition
import com.dendi.android.definitionwordtestapp.data.DataMeaning
import com.dendi.android.definitionwordtestapp.data.DataPhonetic
import com.dendi.android.definitionwordtestapp.data.DataWord
import com.dendi.android.definitionwordtestapp.data.cache.CacheDefinition
import com.dendi.android.definitionwordtestapp.data.cache.CacheMeaning
import com.dendi.android.definitionwordtestapp.data.cache.CachePhonetic
import com.dendi.android.definitionwordtestapp.data.cache.CacheWord
import com.dendi.android.definitionwordtestapp.domain.*
import com.dendi.android.definitionwordtestapp.presentation.*


/**
 * @author Dendy-Jr on 27.11.2021
 * olehvynnytskyi@gmail.com
 */
interface Abstract {

    interface Object<R, M: Mapper> {
        fun mapper(mapper: M): R
    }

    interface ToCacheWordMapper : Mapper {
        fun map(
            id: Long,
            word: String,
            phonetic: String,
            phonetics: List<CachePhonetic>,
            origin: String,
            meanings: List<CacheMeaning>
        ): CacheWord
    }

    interface ToDataWordMapper : Mapper {
        fun map(
            id: Long,
            word: String,
            phonetic: String,
            phonetics: List<DataPhonetic>,
            origin: String,
            meanings: List<DataMeaning>
        ): DataWord
    }

    interface ToDomainWordMapper : Mapper {
        fun map(
            id: Long,
            word: String,
            phonetic: String,
            phonetics: List<DomainPhonetic>,
            origin: String,
            meanings: List<DomainMeaning>
        ): DomainWord
    }

    interface UiWordMapper<T> : Mapper {
        fun map(
            id: Long,
            word: String,
            phonetic: String,
            phonetics: List<UiPhonetic>,
            origin: String,
            meanings: List<UiMeaning>
        ): T

        fun map(message: String): T
    }

    interface PhoneticMapper<T> : Mapper {
        fun map(id: Long, audio: String, text: String): T
    }

    interface ToCacheMeaningMapper : Mapper {
        fun map(
            id: Long,
            partOfSpeech: String,
            definitions: List<CacheDefinition>
        ): CacheMeaning
    }

    interface ToDataMeaningMapper : Mapper {
        fun map(id: Long, partOfSpeech: String, definitions: List<DataDefinition>): DataMeaning
    }

    interface ToDomainMeaningMapper : Mapper {
        fun map(
            id: Long,
            partOfSpeech: String,
            definitions: List<DomainDefinition>
        ): DomainMeaning
    }

    interface UiMeaningMapper<T> : Mapper {
        fun map(id: Long, partOfSpeech: String, definitions: List<UiDefinition>): T
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

    interface WordsDataToDomainMapper : Mapper {
        fun map(words: List<DataWord>): DomainWords
        fun map(message: String): DomainWords

        class Base(private val mapper: ToDomainWordMapper) :
            WordsDataToDomainMapper {
            override fun map(words: List<DataWord>) =
                DomainWords.Success(words.map { it.mapper(mapper) })


            override fun map(message: String) =
                DomainWords.Failure(message)
        }
    }

    interface WordsDomainToUiMapper : Mapper {
        fun map(words: List<DomainWord>): UiWords
        fun map(message: String): UiWords

        class Base(private val mapper: UiWordMapper<UiWord>) :
            WordsDomainToUiMapper {
            override fun map(words: List<DomainWord>) =
                UiWords.Base(words.map { it.mapper(mapper) })

            override fun map(message: String) =
                UiWords.Base(listOf(UiWord.Failure(message)))
        }
    }

    interface ListMapper<S> : Mapper {
        fun map(data: List<S>)
    }

    interface Mapper
}