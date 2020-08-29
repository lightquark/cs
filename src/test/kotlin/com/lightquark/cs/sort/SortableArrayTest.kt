package com.lightquark.cs.sort

import io.kotlintest.shouldBe
import io.mockk.junit5.MockKExtension
import org.junit.jupiter.api.extension.ExtendWith
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

@ExtendWith(MockKExtension::class)
class SortableArrayTest {

    @ParameterizedTest(name = "Arguments set #{index} : ''{0}''")
    @MethodSource("valuesDataProvider")
    fun `should sort values using Bubble Sort method`(example: IntArray, expected: IntArray) {
        sortValues(BubbleSortableArray(example), expected)
    }

    @ParameterizedTest(name = "Arguments set #{index} : ''{0}''")
    @MethodSource("valuesDataProvider")
    fun `should sort values using Optimized Bubble Sort method`(example: IntArray, expected: IntArray) {
        sortValues(OptimizedBubbleSortableArray(example), expected)
    }

    @ParameterizedTest(name = "Arguments set #{index} : ''{0}''")
    @MethodSource("valuesDataProvider")
    fun `should sort values using Selection Sort method`(example: IntArray, expected: IntArray) {
        sortValues(SelectionSortableArray(example), expected)
    }

    @ParameterizedTest(name = "Arguments set #{index} : ''{0}''")
    @MethodSource("valuesDataProvider")
    fun `should sort values using Insertion Sort method`(example: IntArray, expected: IntArray) {
        sortValues(InsertionSortableArray(example), expected)
    }

    @ParameterizedTest(name = "Arguments set #{index} : ''{0}''")
    @MethodSource("valuesDataProvider")
    fun `should sort values using Merge Sort method`(example: IntArray, expected: IntArray) {
        sortValues(MergeSortableArray(example), expected)
    }

    fun sortValues(array: AbstractSortableArray, expected: IntArray) {
        array.sort()
        array.values shouldBe expected
    }

    companion object {

        @JvmStatic
        private fun valuesDataProvider(): Stream<Arguments> {
            return Stream.of(
                Arguments.of(intArrayOf(1, 2, 3, 4, 5), intArrayOf(1, 2, 3, 4, 5)),
                Arguments.of(intArrayOf(5, 4, 3, 2, 1), intArrayOf(1, 2, 3, 4, 5)),
                Arguments.of(intArrayOf(1, 2, 3, 4, 5, 5, 4, 3, 2, 1), intArrayOf(1, 1, 2, 2, 3, 3, 4, 4, 5, 5)),
                Arguments.of(intArrayOf(5, 4, 3, 2, 1, 1, 2, 3, 4, 5), intArrayOf(1, 1, 2, 2, 3, 3, 4, 4, 5, 5)),
                Arguments.of(intArrayOf(1, 0, 2, 9, 3, 8, 4, 7, 5, 6), intArrayOf(0, 1, 2, 3, 4, 5, 6, 7, 8, 9)),
                Arguments.of(intArrayOf(1, 1, 1), intArrayOf(1, 1, 1)),
                Arguments.of(intArrayOf(1, 1, 2, 2), intArrayOf(1, 1, 2, 2)),
                Arguments.of(intArrayOf(1, 2, 1, 2), intArrayOf(1, 1, 2, 2)),
                Arguments.of(intArrayOf(2, 2, 1, 1), intArrayOf(1, 1, 2, 2))
            )
        }
    }
}