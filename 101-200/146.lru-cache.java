import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode id=146 lang=java
 *
 * [146] LRU Cache
 */

// @lc code=start
class Node {
    public int key;
    public int val;
    public Node prev;
    public Node next;

    public Node(int key, int val) {
        this.key = key;
        this.val = val;
        this.prev = null;
        this.next = null;
    }
}


class LRUCache {
    private Node head;
    private Node tail;
    private Map<Integer, Node> nodes;
    private int capacity;

    public LRUCache(int capacity) {
        this.head = new Node(-1, -1);
        this.tail = new Node(-1, -1);
        head.next = tail;
        tail.prev = head;

        this.nodes = new HashMap<>();
        this.capacity = capacity;
    }

    private void addToTail(Node node) {
        Node p = tail.prev;
        p.next = node;
        node.prev = p;
        node.next = tail;
        tail.prev = node;
    }

    private void moveToTail(Node node) {
        System.out.println(node.val);
        node.prev.next = node.next;
        node.next.prev = node.prev;

        addToTail(node);
    }

    public int get(int key) {
        if (nodes.containsKey(key)) {
            moveToTail(nodes.get(key));
            return nodes.get(key).val;
        }

        return -1;
    }

    public void put(int key, int value) {
        if (nodes.containsKey(key)) {
            nodes.get(key).val = value;
            moveToTail(nodes.get(key));
        } else {
            if (capacity == nodes.size()) {
                Node evicted = head.next;
                Node newRoot = evicted.next;

                evicted.prev = null;
                evicted.next = null;
                nodes.remove(evicted.key);

                head.next = newRoot;
                newRoot.prev = head;
            }

            addToTail(new Node(key, value));
            nodes.put(key, tail.prev);
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

