/*
 * @lc app=leetcode id=117 lang=java
 *
 * [117] Populating Next Right Pointers in Each Node II
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
    private Node searchFirstChild(Node node) {
        while (node != null) {
            if (node.left != null) {
                return node.left;
            }

            if (node.right != null) {
                return node.right;
            }

            node = node.next;
        }

        return node;
    }

    public Node connect(Node root) {
        if (root == null) {
            return root;
        }

        Node head = root;
        Node curLevel = root.left != null ? root.left : root.right;

        while (curLevel != null) {
            Node nextFirstChild = searchFirstChild(head.next);

            if (head.left != null) {
                head.left.next = head.right != null ? head.right : nextFirstChild;
            }

            if (head.right != null) {
                head.right.next = nextFirstChild;
            }

            if (head.next == null) {
                head = curLevel;
                curLevel = searchFirstChild(curLevel);
            } else {
                head = head.next;
            }
        }

        return root;
    }
}
// @lc code=end

