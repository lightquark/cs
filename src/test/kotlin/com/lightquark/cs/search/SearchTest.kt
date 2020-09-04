package com.lightquark.cs.search

import io.kotlintest.shouldBe
import io.mockk.junit5.MockKExtension
import org.junit.jupiter.api.extension.ExtendWith
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream
import kotlin.streams.toList

@ExtendWith(MockKExtension::class)
class SearchTest {

    @ParameterizedTest(name = "Arguments set #{index} : ''{0}'' ''{1}''")
    @MethodSource("valuesDataProvider")
    fun `should search value`(sortMethod: AbstractSearchableArray, input: IntArray, value: Int, expected: Int) {
        val actual = sortMethod.search(input, value)
        actual shouldBe expected
    }

    companion object {

        @JvmStatic
        private fun valuesDataProvider(): Stream<Arguments> {
            val sortMethods = listOf(
                BinarySearchableArray()
            )

            val values = listOf(
                Triple(intArrayOf(1, 2, 3, 4, 5), 1, 0),
                Triple(intArrayOf(1, 2, 3, 4, 5), 2, 1),
                Triple(intArrayOf(1, 2, 3, 4, 5), 3, 2),
                Triple(intArrayOf(1, 2, 3, 4, 5), 4, 3),
                Triple(intArrayOf(1, 2, 3, 4, 5), 5, 4),
                Triple(intArrayOf(1, 2, 3, 4, 5), 6, -1),
                Triple(intArrayOf(1, 1, 1), 1, 0),
                Triple(intArrayOf(1, 1, 2, 2), 2, 2),
                Triple(intArrayOf(0), 0, 0),
                Triple(intArrayOf(5), 5, 0)
            )

            return sortMethods.stream()
                .map { sortMethod ->
                    values.stream()
                        .map { t -> Arguments.of(sortMethod, t.first, t.second, t.third) }
                        .toList()
                }
                .toList().flatten().stream()
        }
    }
}