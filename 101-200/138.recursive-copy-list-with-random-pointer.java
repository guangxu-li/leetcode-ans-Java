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

    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }

        if (copied.containsKey(head)) {
            return copied.get(head);
        }

        Node node = new Node(head.val);
        copied.put(head, node);

        node.next = copyRandomList(head.next);
        node.random = copyRandomList(head.random);

        return node;
    }
}
// @lc code=end

