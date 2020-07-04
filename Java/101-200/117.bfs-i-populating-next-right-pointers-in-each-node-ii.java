import java.util.LinkedList;
import java.util.Queue;

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
    public Node connect(Node root) {
        if (root == null) {
            return root;
        }

        Queue<Node> nodes = new LinkedList<>();
        nodes.add(root);

        while (!nodes.isEmpty()) {
            int count = nodes.size();
            while (count-- > 0) {
                Node node = nodes.poll();

                if (count > 0) {
                    node.next = nodes.peek();
                }

                if (node.left != null) {
                    nodes.add(node.left);
                }

                if (node.right != null) {
                    nodes.add(node.right);
                }
            }
        }

        return root;
    }
}
// @lc code=end

