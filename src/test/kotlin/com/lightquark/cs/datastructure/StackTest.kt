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
        var actual = stackImplementation.peek()
        actual shouldBe null
        actual = stackImplementation.pop()
        actual shouldBe null

        stackImplementation.push(VALUE)
        actual = stackImplementation.peek()
        actual shouldBe VALUE
        actual = stackImplementation.pop()
        actual shouldBe VALUE

        actual = stackImplementation.peek()
        actual shouldBe null
        actual = stackImplementation.pop()
        actual shouldBe null
    }

    @ParameterizedTest(name = "Arguments set #{index} : ''{0}''")
    @MethodSource("stackDataProvider")
    fun `should push, peek and pop many values`(stackImplementation: Stack<Any>) {
        var actual = stackImplementation.peek()
        actual shouldBe null
        actual = stackImplementation.pop()
        actual shouldBe null

        VALUES.forEach { value ->
            stackImplementation.push(value)
        }

        VALUES.reversedArray().forEach { value ->
            actual = stackImplementation.peek()
            actual shouldBe value
            actual = stackImplementation.pop()
            actual shouldBe value
        }

        actual = stackImplementation.peek()
        actual shouldBe null
        actual = stackImplementation.pop()
        actual shouldBe null
    }

    @Test
    fun `should throw IndexOutOfBoundsException when size exceeded`() {
        val stack = ArrayBasedStack(2)

        stack.push(QueueTest.VALUE)
        stack.push(QueueTest.VALUE)

        assertThrows<IndexOutOfBoundsException> {
            stack.push(QueueTest.VALUE)
        }
    }

    companion object {

        val VALUE = 1;
        val VALUES = intArrayOf(1, 2, 3, 4, 5)

        @JvmStatic
        private fun stackDataProvider(): Stream<Arguments> {
            return Stream.of(
                Arguments.of(ArrayBasedStack()),
                Arguments.of(ListBasedStack())
            )
        }
    }

}