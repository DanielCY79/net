package com.daniel.other;

import java.util.HashMap;

/**
 * TODO:
 *
 * @author Daniel X
 * @since 2019/8/26 14:33
 */
public class LRUCacheTest {

    private int cap;
    private DoubleList doubleList;
    private HashMap<Integer, Node> hashMap;

    public LRUCacheTest(int capacity) {
        this.cap = capacity;
        doubleList = new DoubleList();
        hashMap = new HashMap<>();
    }

    public int get(int key) {
        if (!hashMap.containsKey(key)) {
            // 如果不存在，返回 -1
            return -1;
        } else {
            // 如果存在，将该节点删除，并新建一个节点查到最前面
            int val = hashMap.get(key).value;
            put(key, val);
            return val;
        }
    }

    public void put(int key, int value) {
        Node x = new Node(key, value);
        if (hashMap.containsKey(key)) {
            // 如果已经存在，删除这个节点，并在最前面插入一个新的节点
            doubleList.remove(hashMap.get(key));
            doubleList.addFirst(x);
            // 更新 map 中的值
            hashMap.put(key, x);
        } else {
            if(cap == doubleList.size){
                Node last = doubleList.removeLast();
                hashMap.remove(last.key);
            }
            doubleList.addFirst(x);
            hashMap.put(key, x);
        }
    }

    private static class Node {
        private int key;
        private int value;
        private Node next;
        private Node prev;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private static class DoubleList {
        private Node head;
        private Node tail;
        private int size;

        public DoubleList() {
            head = new Node(0, 0);
            tail = new Node(0, 0);
            head.next = tail;
            tail.prev = head;
            size = 0;
        }

        public void remove(Node x) {
            x.prev.next = x.next;
            x.next.prev = x.prev;
            size--;
        }

        public void addFirst(Node x) {
            x.next = head.next;
            x.prev = head;
            head.next.prev = x;
            head.next = x;
            size++;
        }

        public Node removeLast() {
            if(tail.prev == head){
                return null;
            }
            Node last = tail.prev;
            remove(tail.prev);
            return last;
        }

    }
}

