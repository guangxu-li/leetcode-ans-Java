import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode id=460 lang=java
 *
 * [460] LFU Cache
 */

// @lc code=start
class ListNode {
    public int key;
    public int value;
    public int freq;

    public ListNode prev;
    public ListNode next;

    public ListNode() {
    }

    public ListNode(int key, int value) {
        this.key = key;
        this.value = value;
        this.freq = 1;
    }
}


class DoublyLinkedList {
    public ListNode head;
    public ListNode tail;

    public int size;

    public DoublyLinkedList() {
        this.head = new ListNode();
        this.tail = new ListNode();

        head.next = tail;
        tail.prev = head;

        size = 0;
    }

    public ListNode removeFirst() {
        ListNode first = head.next;
        remove(first);

        return first;
    }

    public void remove(ListNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;

        node.prev = null;
        node.next = null;

        size--;
    }

    public void add(ListNode node) {
        tail.prev.next = node;
        node.prev = tail.prev;

        tail.prev = node;
        node.next = tail;

        size++;
    }

    public boolean isEmpty() {
        return size == 0;
    }
}


class LFUCache {
    private int capacity;
    private int size;
    private int lf;

    private Map<Integer, ListNode> cache;
    private Map<Integer, DoublyLinkedList> freqs = new HashMap<>();

    private void removeEldestElement() {
        if (size > capacity) {
            cache.remove(freqs.get(lf).removeFirst().key);
            size--;
        }

        // reset lf after put()
        lf = 1;
    }

    public LFUCache(int capacity) {
        this.capacity = capacity;
        size = 0;
        lf = 1;

        cache = new HashMap<>();
        freqs.put(1, new DoublyLinkedList());
    }

    public int get(int key) {
        if (cache.containsKey(key)) {
            ListNode node = cache.get(key);
            freqs.get(node.freq).remove(node);

            if (!freqs.containsKey(++node.freq)) {
                freqs.put(node.freq, new DoublyLinkedList());
            }
            freqs.get(node.freq).add(node);
            if (freqs.get(lf).isEmpty()) {
                lf++;
            }

            return node.value;
        } else {
            return -1;
        }
    }

    public void put(int key, int value) {
        if (cache.containsKey(key)) {
            ListNode node = cache.get(key);
            freqs.get(node.freq).remove(node);

            if (!freqs.containsKey(++node.freq)) {
                freqs.put(node.freq, new DoublyLinkedList());
            }
            freqs.get(node.freq).add(node);
            if (freqs.get(lf).isEmpty()) {
                lf++;
            }

            node.value = value;
        } else {
            ListNode node = new ListNode(key, value);
            cache.put(key, node);

            freqs.get(1).add(node);
            size++;

            removeEldestElement();
        }
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
// @lc code=end

