package com.lightquark.cs.datastructure

import io.kotlintest.shouldBe
import io.mockk.junit5.MockKExtension
import org.junit.jupiter.api.extension.ExtendWith
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

@ExtendWith(MockKExtension::class)
class LinkedListTest {

    @ParameterizedTest(name = "Arguments set #{index} : ''{0}''")
    @MethodSource("listDataProvider")
    fun `should add, get and remove one value`(listImplementation: LinkedList<Any>) {
        listImplementation.size() shouldBe 0
        listImplementation.get(0) shouldBe null

        listImplementation.add(VALUE)
        listImplementation.size() shouldBe 1
        listImplementation.get(0) shouldBe VALUE

        listImplementation.remove(0)
        listImplementation.size() shouldBe 0
        listImplementation.get(0) shouldBe null
    }

    @ParameterizedTest(name = "Arguments set #{index} : ''{0}''")
    @MethodSource("listDataProvider")
    fun `should add, get and remove many values`(listImplementation: LinkedList<Any>) {
        listImplementation.size() shouldBe 0
        listImplementation.get(0) shouldBe null

        VALUES.forEachIndexed { index, value ->
            println(listImplementation)
            listImplementation.add(value)
            listImplementation.size() shouldBe index + 1
            listImplementation.get(index.toLong()) shouldBe value
            listImplementation.getFirst() shouldBe VALUES[0]
            listImplementation.getLast() shouldBe value
        }

        VALUES.forEachIndexed { index, value ->
            println(listImplementation)

            listImplementation.removeLast()
            listImplementation.size() shouldBe VALUES.size - index - 1

            for (i in 0 until listImplementation.size()) {
                println(i)
                listImplementation.get(i) shouldBe VALUES[i.toInt()]
            }
        }

        listImplementation.size() shouldBe 0
        listImplementation.get(0) shouldBe null
    }

    @ParameterizedTest(name = "Arguments set #{index} : ''{0}''")
    @MethodSource("listDataProvider")
    fun `should add and remove at the beginning many values`(listImplementation: LinkedList<Any>) {
        listImplementation.size() shouldBe 0
        listImplementation.get(0) shouldBe null

        VALUES.forEachIndexed { index, value ->
            println(listImplementation)
            listImplementation.addFirst(value)
            listImplementation.size() shouldBe index + 1
            listImplementation.get(0) shouldBe value
            listImplementation.getFirst() shouldBe value
            listImplementation.getLast() shouldBe VALUES[0]
        }

        VALUES.forEachIndexed { index, value ->
            println(listImplementation)

            listImplementation.removeFirst()
            listImplementation.size() shouldBe VALUES.size - index - 1

            for (i in 0 until listImplementation.size()) {
                listImplementation.get(i) shouldBe VALUES[VALUES.size - (i + index + 2).toInt()]
            }
        }

        listImplementation.size() shouldBe 0
        listImplementation.get(0) shouldBe null
    }

    companion object {

        const val VALUE = 1;
        val VALUES = intArrayOf(5, 1, 2, 4, 3)

        @JvmStatic
        private fun listDataProvider(): Stream<Arguments> {
            return Stream.of(
                Arguments.of(SinglyLinkedList()),
                Arguments.of(DoublyLinkedList())
            )
        }
    }

}