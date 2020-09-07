package com.lightquark.cs.datastructure;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

public class DoublyLinkedList implements LinkedList<Integer> {

    private Node head;
    private Node tail;
    private int size;

    public DoublyLinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    @Override
    public long size() {
        return size;
    }

    @Override
    public void add(Integer value) {
        if (head == null) {
            head = new Node(value, null, null);
            tail = head;
            size++;
        } else {
            Node node = new Node(value, tail, null);
            tail.setNext(node);
            tail = node;
            size++;
        }
    }

    @Override
    public void addFirst(Integer value) {
        if (head == null) {
            head = new Node(value, null, null);
            tail = head;
            size++;
        } else {
            Node node = new Node(value, null, head);
            head.setPrev(node);
            head = node;
            size++;
        }
    }

    @Override
    public Integer get(long index) {
        if (0 <= index && index < size) {

            Node node;
            if (index < size / 2) {
                node = head;
                while (node != null && index > 0) {
                    node = node.getNext();
                    index--;
                }
            } else {
                node = tail;
                while (node != null && index < size - 1) {
                    node = node.getPrev();
                    index++;
                }
            }

            if (node == null) {
                throw new IllegalStateException("Node should not be null");
            }
            return node.getValue();
        }
        return null;
    }

    @Override
    public Integer getFirst() {
        return get(0);
    }

    @Override
    public Integer getLast() {
        return get(size - 1);
    }

    @Override
    public void remove(long index) {
        if (0 <= index && index < size) {
            if (index == 0) {
                head = head.getNext();
                size--;
                if (size < 0) {
                    tail = null;
                }
                return;
            }

            Node node = head;
            Node prev = null;
            while (node != null && index > 0) {
                prev = node;
                node = node.getNext();
                index--;
            }

            if (node == null) {
                throw new IllegalStateException("Node should not be null");
            }
            prev.setNext(node.getNext());
            if (node == tail) {
                tail = prev;
            }
            size--;
        }
    }

    @Override
    public void removeFirst() {
        remove(0);
    }

    @Override
    public void removeLast() {
        remove(size - 1);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("DoublyLinkedList(size=").append(this.size).append(",values=");
        Node node = head;
        while (node != null) {
            sb.append(node.getValue());
            node = node.getNext();
            if (node != null) {
                sb.append(",");
            }
        }
        sb.append(")");
        return sb.toString();
    }

    @Getter
    @Setter
    @AllArgsConstructor
    private static class Node {

        private Integer value;
        private Node prev;
        private Node next;

    }
}
