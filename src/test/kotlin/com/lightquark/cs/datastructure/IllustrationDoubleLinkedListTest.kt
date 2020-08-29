package com.lightquark.cs.datastructure

import io.kotlintest.shouldBe
import io.mockk.junit5.MockKExtension
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(MockKExtension::class)
class IllustrationDoubleLinkedListTest {

    @Test
    fun addOneElement() {
        // PREDICATE
        val list = IllustrationDoubleLinkedList()
        val value = "value"

        // FUNCTIONALITY
        list.add(value)

        // TESTS
        list.size shouldBe 1
        list[0] shouldBe value
    }

    @Test
    fun addTwoElements() {
        // PREDICATE
        val list = IllustrationDoubleLinkedList()
        val value1 = "value1"
        val value2 = "value2"

        // FUNCTIONALITY
        list.add(value1)
        list.add(value2)

        // TESTS
        list.size shouldBe 2
        list[0] shouldBe value1
        list[1] shouldBe value2
    }

    @Test
    fun addSeveralElements() {
        // PREDICATE
        val NUM_ELEMENTS = 10
        val list = IllustrationDoubleLinkedList()
        val values = arrayOfNulls<String>(NUM_ELEMENTS)
        for (i in 0 until NUM_ELEMENTS) {
            values[i] = "value$i"
        }

        // FUNCTIONALITY
        for (i in 0 until NUM_ELEMENTS) {
            list.add(values[i])
        }

        // TESTS
        list.size shouldBe NUM_ELEMENTS
        for (i in 0 until NUM_ELEMENTS) {
            list[i] shouldBe values[i]
        }
    }

    @Test
    fun addOneElementToTheBeginning() {
        // PREDICATE
        val list = IllustrationDoubleLinkedList()
        val value = "value"

        // FUNCTIONALITY
        list.addFirst(value)

        // TESTS
        list.size shouldBe 1
        list[0] shouldBe value
    }

    @Test
    fun addTwoElementsToTheBeginning() {
        // PREDICATE
        val list = IllustrationDoubleLinkedList()
        val value1 = "value1"
        val value2 = "value2"

        // FUNCTIONALITY
        list.addFirst(value1)
        list.addFirst(value2)

        // TESTS
        list.size shouldBe 2
        list[0] shouldBe value2
        list[1] shouldBe value1
    }

    @Test
    fun addSeveralElementsToTheBeginning() {
        // PREDICATE
        val NUM_ELEMENTS = 10
        val list = IllustrationDoubleLinkedList()
        val values = arrayOfNulls<String>(NUM_ELEMENTS)
        for (i in 0 until NUM_ELEMENTS) {
            values[i] = "value$i"
        }

        // FUNCTIONALITY
        for (i in 0 until NUM_ELEMENTS) {
            list.addFirst(values[i])
        }

        // TESTS
        list.size shouldBe NUM_ELEMENTS
        for (i in 0 until NUM_ELEMENTS) {
            list[i] shouldBe values[NUM_ELEMENTS - i - 1]
        }
    }

    @Test
    fun testSize() {
        // PREDICATE
        val NUM_ELEMENTS = 10
        val list = IllustrationDoubleLinkedList()
        val values = arrayOfNulls<String>(NUM_ELEMENTS)
        for (i in 0 until NUM_ELEMENTS) {
            values[i] = "value$i"
        }

        // FUNCTIONALITY AND TESTS
        for (i in 0 until NUM_ELEMENTS) {
            list.add(values[i])
            list.size shouldBe i + 1
        }
    }

    @Test
    fun testNPEs() {
        // PREDICATE
        val list = IllustrationDoubleLinkedList()

        // TESTS
        list.size shouldBe 0
        list.isEmpty() shouldBe true
        list[0] shouldBe null
        list.contains("ABCDE") shouldBe false
        list.contains(null) shouldBe false
    }

    @Test
    fun removeOneElement() {
        // PREDICATE
        val list = IllustrationDoubleLinkedList()
        val value = "value"

        // FUNCTIONALITY
        list.add(value)

        // TESTS
        list.size shouldBe 1
        list[0] shouldBe value
        list.remove(value) shouldBe true
        list.remove(value) shouldBe false
        list.size shouldBe 0
    }

    @Test
    fun removeTwoElements() {
        // PREDICATE
        val list = IllustrationDoubleLinkedList()
        val value1 = "value1"
        val value2 = "value2"

        // FUNCTIONALITY
        list.add(value1)
        list.add(value2)

        // TESTS

        list.size shouldBe 2
        list[0] shouldBe value1
        list[1] shouldBe value2
        list.remove(value1) shouldBe true
        list.remove(value1) shouldBe false
        list.size shouldBe 1
        list.remove(value2) shouldBe true
        list.remove(value2) shouldBe false
        list.size shouldBe 0
    }

    @Test
    fun removeSeveralElements() {
        // PREDICATE
        val NUM_ELEMENTS = 10
        val list = IllustrationDoubleLinkedList()
        val values = arrayOfNulls<String>(NUM_ELEMENTS)
        for (i in 0 until NUM_ELEMENTS) {
            values[i] = "value$i"
        }

        // FUNCTIONALITY
        for (i in 0 until NUM_ELEMENTS) {
            list.add(values[i])
        }

        // TESTS
        list.size shouldBe NUM_ELEMENTS
        for (i in 0 until NUM_ELEMENTS) {
            list[i] shouldBe values[i]
        }
        for (i in 0 until NUM_ELEMENTS) {
            list.remove(values[i]) shouldBe true
            list.remove(values[i]) shouldBe false
            list.size shouldBe NUM_ELEMENTS - i - 1
        }
    }
}