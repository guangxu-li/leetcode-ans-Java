import java.util.HashMap;
import java.util.Map;

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
    private Map<Node, Node> copied = new HashMap<Node, Node>();

    private Node getCopiedNode(Node node) {
        if (node == null) {
            return null;
        }

        if (!copied.containsKey(node)) {
            Node copiedNode = new Node(node.val);
            copied.put(node, copiedNode);
        }

        return copied.get(node);
    }

    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }


        Node dummyHead = new Node(head.val);
        copied.put(head, dummyHead);
        Node cur = dummyHead;

        Node h = head;
        while (h != null) {
            cur.next = getCopiedNode(h.next);
            cur.random = getCopiedNode(h.random);

            cur = cur.next;
            h = h.next;
        }

        return copied.get(head);
    }
}
// @lc code=end

