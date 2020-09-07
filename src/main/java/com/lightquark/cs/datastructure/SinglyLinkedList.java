package com.lightquark.cs.datastructure;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

public class SinglyLinkedList implements LinkedList<Integer> {

    private Node head;
    private int size;

    public SinglyLinkedList() {
        this.head = null;
        this.size = 0;
    }

    @Override
    public long size() {
        return size;
    }

    @Override
    public void add(Integer value) {
        if (head == null) {
            head = new Node(value, null);
            size++;
        } else {
            Node node = new Node(value, null);
            Node last = getLastNode();
            last.setNext(node);
            size++;
        }
    }

    @Override
    public void addFirst(Integer value) {
        if (head == null) {
            head = new Node(value, null);
            size++;
        } else {
            head = new Node(value, head);
            size++;
        }
    }

    @Override
    public Integer get(long index) {
        if (0 <= index && index < size) {
            Node node = head;
            while (node != null && index > 0) {
                node = node.getNext();
                index--;
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

    private Node getLastNode() {
        Node node = head;
        while (node.getNext() != null) {
            node = node.getNext();
        }
        return node;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("SinglyLinkedList(size=").append(this.size).append(",values=");
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
        private Node next;

    }
}
