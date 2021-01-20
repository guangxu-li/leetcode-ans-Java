/*
 * @lc app=leetcode id=426 lang=java
 *
 * [426] Convert Binary Search Tree to Sorted Doubly Linked List
 */

// @lc code=start
/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val,Node _left,Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
};
*/

class Solution {
    public Node treeToDoublyList(Node root) {
        if (root == null) {
            return null;
        }

        Node head = new Node();
        Node h = head;

        while (root != null) {
            if (root.left == null) {
                h.right = root;
                root.left = h;

                h = root;
                root = root.right;
            } else {
                Node predecessor = root.left;
                while (predecessor.right != null && predecessor.right != root) {
                    predecessor = predecessor.right;
                }

                if (predecessor.right == null) {
                    predecessor.right = root;
                    root = root.left;
                } else {
                    root.left = h;
                    
                    h = root;
                    root = root.right;
                }
            }
        }

        head.right.left = h;
        h.right = head.right;

        return head.right;
    }
}
// @lc code=end

