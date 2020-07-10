import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode id=146 lang=java
 *
 * [146] LRU Cache
 */

// @lc code=start
class LRUCache {
    class ListNode {
        private int key;
        private int value;

        private ListNode next;
        private ListNode prev;

        public ListNode() {
        }

        public ListNode(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    class LinkedList {
        private ListNode head;
        private ListNode tail;

        public LinkedList() {
            this.head = new ListNode();
            this.tail = new ListNode();

            head.next = tail;
            tail.prev = head;
        }

        public void add(ListNode node) {
            node.prev = head;
            node.next = head.next;

            head.next.prev = node;
            head.next = node;
        }

        public void remove(ListNode node) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }

        public ListNode removeLast() {
            ListNode node = tail.prev;
            remove(node);

            return node;
        }

        public void moveToHead(ListNode node) {
            remove(node);
            add(node);
        }
    }

    private LinkedList list;
    private Map<Integer, ListNode> cache = new HashMap<>();
    private int size = 0;

    private int capacity;

    private void removeEldestElement() {
        if (size > capacity) {
            size--;
            cache.remove(list.removeLast().key);
        }
    }

    public LRUCache(int capacity) {
        this.capacity = capacity;

        list = new LinkedList();
    }

    public int get(int key) {
        ListNode node = cache.get(key);
        if (node == null) {
            return -1;
        }
        list.moveToHead(node);

        return node.value;
    }

    public void put(int key, int value) {
        ListNode node = cache.get(key);

        if (node == null) {
            node = new ListNode(key, value);
            list.add(node);
            cache.put(key, node);

            size++;
            removeEldestElement();
        } else {
            node.value = value;
            list.moveToHead(node);
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
// @lc code=end

