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
        queueImplementation.peek() shouldBe null
        queueImplementation.dequeue() shouldBe null
        queueImplementation.size() shouldBe 0
        queueImplementation.isEmpty shouldBe true

        queueImplementation.enqueue(VALUE)
        queueImplementation.size() shouldBe 1
        queueImplementation.isEmpty shouldBe false
        queueImplementation.peek() shouldBe VALUE
        queueImplementation.dequeue() shouldBe VALUE

        queueImplementation.peek() shouldBe null
        queueImplementation.dequeue() shouldBe null
        queueImplementation.size() shouldBe 0
        queueImplementation.isEmpty shouldBe true
    }

    @ParameterizedTest(name = "Arguments set #{index} : ''{0}''")
    @MethodSource("queueDataProvider")
    fun `should push, peek and pop many values`(queueImplementation: Queue<Any>) {
        queueImplementation.peek() shouldBe null
        queueImplementation.dequeue() shouldBe null
        queueImplementation.size() shouldBe 0
        queueImplementation.isEmpty shouldBe true

        VALUES.forEachIndexed { index, value ->
            queueImplementation.enqueue(value)
            queueImplementation.size() shouldBe index + 1
            queueImplementation.isEmpty shouldBe false
        }

        VALUES.forEachIndexed { index, value ->
            queueImplementation.size() shouldBe VALUES.size - index
            queueImplementation.isEmpty shouldBe false
            queueImplementation.peek() shouldBe value
            queueImplementation.dequeue() shouldBe value
        }

        queueImplementation.peek() shouldBe null
        queueImplementation.dequeue() shouldBe null
        queueImplementation.size() shouldBe 0
        queueImplementation.isEmpty shouldBe true
    }

    @Test
    fun `should throw IndexOutOfBoundsException when size exceeded`() {
        val queue = ArrayBasedQueue<Int>(2)

        queue.enqueue(VALUE)
        queue.enqueue(VALUE)

        assertThrows<IndexOutOfBoundsException> {
            queue.enqueue(VALUE)
        }
    }

    companion object {

        const val VALUE = 99;
        val VALUES = intArrayOf(91, 93, 97, 99, 92)

        @JvmStatic
        private fun queueDataProvider(): Stream<Arguments> {
            return Stream.of(
                Arguments.of(ArrayBasedQueue<Int>()),
                Arguments.of(ListBasedQueue<Int>())
            )
        }
    }

}