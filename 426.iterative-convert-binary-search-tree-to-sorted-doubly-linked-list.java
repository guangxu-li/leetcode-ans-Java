import java.util.Deque;
import java.util.LinkedList;

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
            return root;
        }

        Node head = new Node();
        Node h = head;

        Deque<Node> nodes = new LinkedList<>();
        while (!nodes.isEmpty() || root != null) {
            while (root != null) {
                nodes.push(root);
                root = root.left;
            }

            // point to predecessor and successor
            root = nodes.pop();
            h.right = root;
            root.left = h;

            // update pointers
            h = root;
            root = root.right;
        }
        
        head.right.left = h;
        h.right = head.right;

        return head.right;
    }
}
// @lc code=end

