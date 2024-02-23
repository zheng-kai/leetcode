package leetcode146;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * 146. LRU 缓存
 * <p>
 * 请你设计并实现一个满足  LRU (最近最少使用) 缓存 约束的数据结构。
 * 实现 LRUCache 类：
 * LRUCache(int capacity) 以 正整数 作为容量 capacity 初始化 LRU 缓存
 * int get(int key) 如果关键字 key 存在于缓存中，则返回关键字的值，否则返回 -1 。
 * void put(int key, int value) 如果关键字 key 已经存在，则变更其数据值 value ；如果不存在，则向缓存中插入该组 key-value 。如果插入操作导致关键字数量超过 capacity ，则应该 逐出 最久未使用的关键字。
 * 函数 get 和 put 必须以 O(1) 的平均时间复杂度运行。
 */
public class LRUCache {

    class Node {
        public int key;
        public int value;
        public Node pre;
        public Node next;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private int capacity;
    private int size = 0;
    private HashMap<Integer, Node> hashMap = new HashMap<>();

    private Node head = new Node(-1,-1);
    private Node tail = new Node(-1,-1);

    public LRUCache(int capacity) {
        this.capacity = capacity;
        head.next = tail;
        tail.pre = head;
    }

    public int get(int key) {
        if (hashMap.containsKey(key)) {
            Node target = hashMap.get(key);
            updateUse(target);
            return target.value;
        }
        return -1;
    }

    public void put(int key, int value) {
        if (hashMap.containsKey(key)) {
            Node target = hashMap.get(key);
            target.value = value;
            updateUse(target);
        } else {
            size++;
            if (size > capacity) {
                Node last = tail.pre;
                hashMap.remove(last.key);
                last.pre.next = tail;
                last.next.pre = last.pre;
                size--;
            }
            Node node = new Node(key,value);
            node.next = head.next;
            head.next.pre = node;
            node.pre = head;
            head.next = node;
            hashMap.put(key, node);
        }
    }

    private void updateUse(Node target) {
        target.pre.next = target.next;
        target.next.pre = target.pre;
        target.next = head.next;
        target.pre = head;
        head.next.pre  = target;
        head.next = target;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */