package com.lightquark.cs.datastructure

import io.kotlintest.shouldBe
import io.mockk.junit5.MockKExtension
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.api.extension.ExtendWith
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

@ExtendWith(MockKExtension::class)
class QueueTest {

    @ParameterizedTest(name = "Arguments set #{index} : ''{0}''")
    @MethodSource("queueDataProvider")
    fun `should push, peek and pop one value`(queueImplementation: Queue<Any>) {
        var actual = queueImplementation.peek()
        actual shouldBe null
        actual = queueImplementation.dequeue()
        actual shouldBe null

        queueImplementation.enqueue(VALUE)
        actual = queueImplementation.peek()
        actual shouldBe VALUE
        actual = queueImplementation.dequeue()
        actual shouldBe VALUE

        actual = queueImplementation.peek()
        actual shouldBe null
        actual = queueImplementation.dequeue()
        actual shouldBe null
    }

    @ParameterizedTest(name = "Arguments set #{index} : ''{0}''")
    @MethodSource("queueDataProvider")
    fun `should push, peek and pop many values`(queueImplementation: Queue<Any>) {
        var actual = queueImplementation.peek()
        actual shouldBe null
        actual = queueImplementation.dequeue()
        actual shouldBe null

        VALUES.forEach { value ->
            queueImplementation.enqueue(value)
        }

        VALUES.forEach { value ->
            actual = queueImplementation.peek()
            actual shouldBe value
            actual = queueImplementation.dequeue()
            actual shouldBe value
        }

        actual = queueImplementation.peek()
        actual shouldBe null
        actual = queueImplementation.dequeue()
        actual shouldBe null
    }

    @Test
    fun `should throw IndexOutOfBoundsException when size exceeded`() {
        val queue = ArrayBasedQueue(2)

        queue.enqueue(VALUE)
        queue.enqueue(VALUE)

        assertThrows<IndexOutOfBoundsException> {
            queue.enqueue(VALUE)
        }
    }

    companion object {

        val VALUE = 1;
        val VALUES = intArrayOf(1, 2, 3, 4, 5)

        @JvmStatic
        private fun queueDataProvider(): Stream<Arguments> {
            return Stream.of(
                Arguments.of(ArrayBasedQueue()),
                Arguments.of(ListBasedQueue())
            )
        }
    }

}