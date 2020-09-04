package com.lightquark.cs.dynamicprogramming

import io.kotlintest.shouldBe
import io.mockk.junit5.MockKExtension
import org.junit.jupiter.api.extension.ExtendWith
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

@ExtendWith(MockKExtension::class)
class FindTheLongestSubsequenceLengthTest {

    @ParameterizedTest(name = "Arguments set #{index} : ''{0}'' ''{1}''")
    @MethodSource("valuesDataProvider")
    fun `should find the longest substring`(first: String, second: String, expected: Int) {
        val finder = FindTheLongestSubsequenceLength()
        val actual = finder.find(first, second)
        actual shouldBe expected
    }

    companion object {

        @JvmStatic
        private fun valuesDataProvider(): Stream<Arguments> {
            return Stream.of(
                Arguments.of("ABCDEFGH", "EBCDF", 4),
                Arguments.of("ABCDEFGH", "ABCDEFGH", 8),
                Arguments.of("ABCDEFGH", "XYZ", 0),
                Arguments.of("ABCDEFGH", "CBA", 1)
            )
        }
    }
}