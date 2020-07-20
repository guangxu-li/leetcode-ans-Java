/*
 * @lc app=leetcode id=138 lang=java
 *
 * [138] Copy List with Random Pointer
 */

// @lc code=start
/*
 * // Definition for a Node. class Node { int val; Node next; Node random;
 * 
 * public Node(int val) { this.val = val; this.next = null; this.random = null; } }
 */

class Solution {
    public Node copyRandomList(Node head) {
        if (head == null) {
            return head;
        }

        Node h = head;
        while (h != null) {
            Node node = new Node(h.val);
            node.next = h.next;
            h.next = node;

            h = node.next;
        }

        h = head;
        Node copiedHead = h.next;
        while (h != null) {
            h.next.random = h.random == null ? null : h.random.next;

            h = h.next.next;
        }

        h = head;
        while (h != null) {
            Node nextHead = h.next.next;

            h.next.next = nextHead == null ? null : nextHead.next;
            h.next = nextHead;

            h = nextHead;
        }

        return copiedHead;
    }
}
// @lc code=end

