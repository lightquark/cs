package com.lightquark.cs.dynamicprogramming

import io.kotlintest.shouldBe
import io.mockk.junit5.MockKExtension
import org.junit.jupiter.api.extension.ExtendWith
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

@ExtendWith(MockKExtension::class)
class FindTheLongestSubstringTest {

    @ParameterizedTest(name = "Arguments set #{index} : ''{0}'' ''{1}''")
    @MethodSource("valuesDataProvider")
    fun `should find the longest substring`(first: String, second: String, expected: String?) {
        val finder = FindTheLongestSubstring()
        val actual = finder.find(first, second)
        actual shouldBe expected
    }

    companion object {

        @JvmStatic
        private fun valuesDataProvider(): Stream<Arguments> {
            return Stream.of(
                Arguments.of("ABCDEFGH", "EBCDF", "BCD"),
                Arguments.of("ABCDEFGH", "ABCDEFGH", "ABCDEFGH"),
                Arguments.of("ABCDEFGH", "XYZ", null),
                Arguments.of("ABCDEFGH", "CBA", "A")
            )
        }
    }
}