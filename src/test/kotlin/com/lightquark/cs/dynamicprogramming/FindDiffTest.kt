package com.lightquark.cs.dynamicprogramming

import io.kotlintest.shouldBe
import io.mockk.junit5.MockKExtension
import org.junit.jupiter.api.extension.ExtendWith
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

@ExtendWith(MockKExtension::class)
class FindDiffTest {

    @ParameterizedTest(name = "Arguments set #{index} : ''{0}'' ''{1}''")
    @MethodSource("valuesDataProvider")
    fun `should find the diff between strings`(first: String, second: String, expected: String?) {
        val finder = FindDiff()
        val actual = finder.find(first, second)
        actual shouldBe expected
    }

    companion object {

        @JvmStatic
        private fun valuesDataProvider(): Stream<Arguments> {
            return Stream.of(
                Arguments.of("ABCDFGHJQZ", "ABCDEFGIJKRXYZ", "ABCD+EFG-H+IJ-Q+K+R+X+YZ"),
                Arguments.of("ABCD", "BC", "-ABC-D"),
                Arguments.of("ABCD", "AD", "A-B-CD"),
                Arguments.of("ABCD", "XYZ", "-A-B-C-D+X+Y+Z"),
                Arguments.of("ABCDEFGH", "ABCDEFGH", "ABCDEFGH")
            )
        }
    }
}