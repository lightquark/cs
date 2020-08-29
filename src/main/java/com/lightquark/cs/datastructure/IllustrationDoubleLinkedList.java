package com.lightquark.cs.datastructure;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Objects;

public class IllustrationDoubleLinkedList implements List<Object> {

    private Node head = null;
    private Node tail = null;

    /**
     * Add an element at the end of the list
     */
    @Override
    public boolean add(Object o) {
        // if this is the very first element
        if (head == null) {

            if (tail != null) {
                throw new IllegalStateException("tail should be null when head is null");
            }

            Node newNode = new Node();
            newNode.prev = null;
            newNode.next = null;
            newNode.data = o;

            head = newNode;
            tail = newNode;
            return true;
        }

        Node newNode = new Node();
        newNode.prev = tail;
        newNode.next = null;
        newNode.data = o;

        if (tail != null) {
            tail.next = newNode;
        }
        tail = newNode;
        return true;
    }

    /**
     * Add an element at the beginning of the list
     * @return true
     */
    public boolean addFirst(Object o) {
        // if this is the very first element
        if (head == null) {
            return add(o);
        }

        Node newNode = new Node();
        newNode.prev = null;
        newNode.next = head;
        newNode.data = o;

        if (head != null) {
            head.prev = newNode;
        }
        head = newNode;

        return true;
    }

    @Override
    public int size() {
        int count = 0;
        Node n = head;
        while (n != null) {
            n = n.next;
            count++;
        }
        return count;
    }

    @Override
    public Object get(int index) {
        if (isEmpty()) {
            return null;
        }

        Node n = head;
        do {
            if (index == 0) {
                return n.data;
            }
            n = n.next;
            index--;
        } while (index >= 0);
        return null;
    }

    @Override
    public boolean isEmpty() {
        return head == null;
    }

    @Override
    public boolean contains(Object o) {
        if (isEmpty()) {
            return false;
        }
        Node n = head;
        do {
            if (Objects.equals(n.data, o)) {
                return true;
            }
            n = n.next;
        } while (n != null);
        return false;
    }

    @Override
    public void clear() {
        head = null;
        tail = null;
    }

    @Override
    public boolean remove(Object o) {
        if (isEmpty()) {
            return false;
        }
        Node n = head;
        do {
            if (Objects.equals(n.data, o)) {

                if (n.prev != null) {
                    n.prev.next = n.next;
                }
                if (n.next != null) {
                    n.next.prev = n.prev;
                }
                if (head == n) {
                    head = n.next;
                }
                if (tail == n) {
                    tail = n.prev;
                }
                return true;
            }
            n = n.next;
        } while (n != null);
        return false;
    }

    @Override
    public void add(int index, Object element) {

    }

    @Override
    public Object remove(int index) {
        return null;
    }

    @Override
    public Iterator iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public boolean addAll(Collection c) {
        return false;
    }

    @Override
    public boolean addAll(int index, Collection c) {
        return false;
    }

    @Override
    public Object set(int index, Object element) {
        return null;
    }

    @Override
    public int indexOf(Object o) {
        return 0;
    }

    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

    @Override
    public ListIterator listIterator() {
        return null;
    }

    @Override
    public ListIterator listIterator(int index) {
        return null;
    }

    @Override
    public List subList(int fromIndex, int toIndex) {
        return null;
    }

    @Override
    public boolean retainAll(Collection c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection c) {
        return false;
    }

    @Override
    public boolean containsAll(Collection c) {
        return false;
    }

    @Override
    public Object[] toArray(Object[] a) {
        return new Object[0];
    }

    public static class Node {

        Node prev = null;
        Node next = null;
        Object data = null;

    }
}
