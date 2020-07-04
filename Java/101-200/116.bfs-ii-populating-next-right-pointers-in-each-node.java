/*
 * @lc app=leetcode id=116 lang=java
 *
 * [116] Populating Next Right Pointers in Each Node
 */

// @lc code=start
/*
 * // Definition for a Node. class Node { public int val; public Node left; public Node right;
 * public Node next;
 * 
 * public Node() {}
 * 
 * public Node(int _val) { val = _val; }
 * 
 * public Node(int _val, Node _left, Node _right, Node _next) { val = _val; left = _left; right =
 * _right; next = _next; } };
 */

class Solution {
    public Node connect(Node root) {
        if (root == null) {
            return root;
        }

        Node head = root;
        Node curLevel = root.left;
        while (curLevel != null) {
            head.left.next = head.right;

            if (head.next == null) {
                head = curLevel;
                curLevel = head.left;
            } else {
                head.right.next = head.next.left;
                head = head.next;
            }
        }

        return root;
    }
}
// @lc code=end

