package com.lightquark.cs.dynamicprogramming

import io.kotlintest.matchers.collections.shouldContainAll
import io.kotlintest.shouldBe
import io.mockk.junit5.MockKExtension
import org.junit.jupiter.api.extension.ExtendWith
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

@ExtendWith(MockKExtension::class)
class FindAllLongestSubsequencesTest {

    @ParameterizedTest(name = "Arguments set #{index} : ''{0}'' ''{1}''")
    @MethodSource("valuesDataProvider")
    fun `should find the longest substring`(first: String, second: String, expected: Set<String>) {
        val finder = FindAllLongestSubsequences()
        val actual = finder.find(first, second)
        actual shouldContainAll expected
    }

    companion object {

        @JvmStatic
        private fun valuesDataProvider(): Stream<Arguments> {
            return Stream.of(
                Arguments.of("ABCDEFGH", "EBADCF", setOf("BDF")),
                Arguments.of("ABCDEFGH", "ABCDEFGH", setOf("ABCDEFGH")),
                Arguments.of("ABCDEFGH", "XYZ", setOf("")),
                Arguments.of("ABCDEFGH", "CBA", setOf("A", "B", "C"))
            )
        }
    }
}