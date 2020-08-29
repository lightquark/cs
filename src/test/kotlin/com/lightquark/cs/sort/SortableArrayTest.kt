package com.lightquark.cs.sort

import io.kotlintest.shouldBe
import io.mockk.junit5.MockKExtension
import org.junit.jupiter.api.extension.ExtendWith
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream
import kotlin.streams.toList

@ExtendWith(MockKExtension::class)
class SortableArrayTest {

    @ParameterizedTest(name = "Arguments set #{index} : ''{0}'' ''{1}''")
    @MethodSource("valuesDataProvider")
    fun `should sort values`(sortMethod: AbstractSortableArray, input: IntArray, expected: IntArray) {
        val actual = sortMethod.sort(input)
        actual shouldBe expected
    }

    companion object {

        @JvmStatic
        private fun valuesDataProvider(): Stream<Arguments> {
            val sortMethods = listOf(
                BubbleSortableArray(),
                OptimizedBubbleSortableArray(),
                InsertionSortableArray(),
                SelectionSortableArray(),
                MergeSortableArray(),
                QuickSortableArray(),
                HeapSortableArray()
            )

            val values = listOf(
                Pair(intArrayOf(1, 2, 3, 4, 5), intArrayOf(1, 2, 3, 4, 5)),
                Pair(intArrayOf(5, 4, 3, 2, 1), intArrayOf(1, 2, 3, 4, 5)),
                Pair(intArrayOf(1, 2, 3, 4, 5, 5, 4, 3, 2, 1), intArrayOf(1, 1, 2, 2, 3, 3, 4, 4, 5, 5)),
                Pair(intArrayOf(5, 4, 3, 2, 1, 1, 2, 3, 4, 5), intArrayOf(1, 1, 2, 2, 3, 3, 4, 4, 5, 5)),
                Pair(intArrayOf(1, 0, 2, 9, 3, 8, 4, 7, 5, 6), intArrayOf(0, 1, 2, 3, 4, 5, 6, 7, 8, 9)),
                Pair(intArrayOf(1, 1, 1), intArrayOf(1, 1, 1)),
                Pair(intArrayOf(1, 1, 2, 2), intArrayOf(1, 1, 2, 2)),
                Pair(intArrayOf(1, 2, 1, 2), intArrayOf(1, 1, 2, 2)),
                Pair(intArrayOf(2, 2, 1, 1), intArrayOf(1, 1, 2, 2)),
            )

            return sortMethods.stream()
                .map { sortMethod ->
                    values.stream()
                        .map { p -> Arguments.of(sortMethod, p.first, p.second) }
                        .toList()
                }
                .toList().flatten().stream()
        }
    }
}