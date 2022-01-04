package com.dendi.android.definitionwordtestapp.domain

import com.dendi.android.definitionwordtestapp.core.Abstract
import com.dendi.android.definitionwordtestapp.data.DataWord
import junit.framework.Assert.assertEquals
import org.junit.Test

/**
 * @author Dendy-Jr on 29.11.2021
 * olehvynnytskyi@gmail.com
 */
class WordsDataToDomainTest {

    private val mapperDomain =
        Abstract.WordsDataToDomainMapper.Base(object : Abstract.ToDomainWordMapper {
            override fun map(
                id: Long,
                word: String,
                phonetic: String,
                phonetics: List<DomainPhonetic>,
                origin: String,
                meanings: List<DomainMeaning>
            ): DomainWord {
                return DomainWord(id, word, phonetic, phonetics, origin, meanings)
            }
        })

    @Test
    fun test_success() {
        val actual = mapperDomain.map(
            listOf(
                DataWord(1, "hello", "həˈləʊ", listOf(), "exclamation", listOf()),
                DataWord(2, "hello2", "həˈləʊ2", listOf(), "exclamation2", listOf())
            )
        )

        val data = listOf(
            DomainWord(1, "hello", "həˈləʊ", listOf(), "exclamation", listOf()),
            DomainWord(2, "hello2", "həˈləʊ2", listOf(), "exclamation2", listOf())
        )

        val expected = DomainWords.Success(data)
        assertEquals(expected, actual)
    }

    @Test
    fun test_fail() {
        var actual = mapperDomain.map("Your value is empty or invalid")
        var expected = DomainWords.Failure("Your value is empty or invalid")
        assertEquals(expected, actual)
        actual = mapperDomain.map("Not correctly entered word")
        expected = DomainWords.Failure("Not correctly entered word")
        assertEquals(expected, actual)
    }
}
