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
class StackTest {

    @ParameterizedTest(name = "Arguments set #{index} : ''{0}''")
    @MethodSource("stackDataProvider")
    fun `should push, peek and pop one value`(stackImplementation: Stack<Any>) {
        stackImplementation.peek() shouldBe null
        stackImplementation.pop() shouldBe null
        stackImplementation.size() shouldBe 0
        stackImplementation.isEmpty shouldBe true

        stackImplementation.push(VALUE)
        stackImplementation.size() shouldBe 1
        stackImplementation.isEmpty shouldBe false
        stackImplementation.peek() shouldBe VALUE
        stackImplementation.pop() shouldBe VALUE

        stackImplementation.peek() shouldBe null
        stackImplementation.pop() shouldBe null
        stackImplementation.size() shouldBe 0
        stackImplementation.isEmpty shouldBe true
    }

    @ParameterizedTest(name = "Arguments set #{index} : ''{0}''")
    @MethodSource("stackDataProvider")
    fun `should push, peek and pop many values`(stackImplementation: Stack<Any>) {
        stackImplementation.peek() shouldBe null
        stackImplementation.pop() shouldBe null
        stackImplementation.size() shouldBe 0
        stackImplementation.isEmpty shouldBe true

        VALUES.forEachIndexed { index, value ->
            stackImplementation.push(value)
            stackImplementation.size() shouldBe index + 1
            stackImplementation.isEmpty shouldBe false
        }

        VALUES.reversedArray().forEachIndexed { index, value ->
            stackImplementation.size() shouldBe VALUES.size - index
            stackImplementation.isEmpty shouldBe false
            stackImplementation.peek() shouldBe value
            stackImplementation.pop() shouldBe value
        }

        stackImplementation.peek() shouldBe null
        stackImplementation.pop() shouldBe null
        stackImplementation.size() shouldBe 0
        stackImplementation.isEmpty shouldBe true
    }

    @Test
    fun `should throw IndexOutOfBoundsException when size exceeded`() {
        val stack = ArrayBasedStack<Int>(2)

        stack.push(QueueTest.VALUE)
        stack.push(QueueTest.VALUE)

        assertThrows<IndexOutOfBoundsException> {
            stack.push(QueueTest.VALUE)
        }
    }

    companion object {

        const val VALUE = 99;
        val VALUES = intArrayOf(91, 93, 97, 99, 92)

        @JvmStatic
        private fun stackDataProvider(): Stream<Arguments> {
            return Stream.of(
                Arguments.of(ArrayBasedStack<Int>()),
                Arguments.of(ListBasedStack<Int>())
            )
        }
    }

}