package com.daniel.other;

import java.util.HashMap;

/**
 * TODO:
 *
 * @author Daniel X
 * @since 2019/8/26 14:17
 */
public class LRUCache {

    private DoubleList doubleList;
    private HashMap<Integer, Node> hashMap;
    private int cap;

    public LRUCache(int capacity) {
        this.doubleList = new DoubleList();
        this.hashMap = new HashMap<>();
        this.cap = capacity;
    }

    public int get(int key) {
        if (hashMap.containsKey(key)) {
            Node node = hashMap.get(key);
            put(key, node.value);
            return node.value;
        } else {
            return -1;
        }
    }

    public void put(int key, int value) {
        Node node = new Node(key, value);
        if (hashMap.containsKey(key)) {
            doubleList.remove(hashMap.get(key));
            doubleList.addFirst(node);

            hashMap.put(key, node);
        } else {
            if (cap == doubleList.size) {
                Node last = doubleList.removeLast();
                hashMap.remove(last.key);
            }
            doubleList.addFirst(node);
            hashMap.put(key, node);
        }
    }

    private static class Node {
        private Integer key;
        private Integer value;
        private Node next;
        private Node prev;

        public Node(Integer key, Integer value) {
            this.key = key;
            this.value = value;
        }
    }

    private static class DoubleList {
        private int size;
        private Node head;
        private Node tail;

        public DoubleList() {
            head = new Node(0, 0);
            tail = new Node(0, 0);
            head.next = tail;
            tail.prev = head;
            size = 0;
        }

        public void addFirst(Node node) {
            node.next = head.next;
            node.prev = head;
            head.next.prev = node;
            head.next = node;
            size++;
        }

        public void remove(Node node) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
            size--;
        }

        public Node removeLast() {
            if (tail.prev == head) {
                return null;
            }
            Node last = tail.prev;
            remove(last);
            return last;
        }
    }

}

