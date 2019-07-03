package org.dangerous.leetcode;

import java.util.HashMap;

/**
 * https://leetcode.com/problems/lru-cache/
 */
public class LRUCache {
    class Node {
        Node pre, next;
        int key, value;

        Node() {
        }

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private void removeNode(Node node) {
        node.pre.next = node.next;
        node.next.pre = node.pre;
    }

    private void addFirst(Node node) {
        node.next = this.head.next;
        node.next.pre = node;
        this.head.next = node;
        node.pre = this.head;
    }

    private Node popTail() {
        Node res = tail.pre;
        this.removeNode(res);
        return res;
    }

    private void move2First(Node node) {
        this.removeNode(node);
        this.addFirst(node);
    }

    private HashMap<Integer, Node> cache;
    private int capacity;
    private Node head, tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.cache = new HashMap<>(capacity);
        this.head = new Node();
        this.tail = new Node();
        this.head.next = tail;
        this.tail.pre = this.head;
    }

    public int get(int key) {
        Node node = cache.get(key);
        if (node == null) {
            return -1;
        }
        this.move2First(node);
        return node.value;
    }

    public void put(int key, int value) {
        Node node = cache.get(key);
        if (node != null) {
            node.value = value;
            this.move2First(node);
            cache.put(key, node);
            return;
        }
        node = new Node(key, value);
        this.addFirst(node);
        cache.put(key, node);
        if (cache.size() > this.capacity) {
            cache.remove(this.popTail().key);
        }
    }

}
