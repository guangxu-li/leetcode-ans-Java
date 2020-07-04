import java.util.LinkedList;
import java.util.Queue;

/*
 * @lc app=leetcode id=116 lang=java
 *
 * [116] Populating Next Right Pointers in Each Node
 */

// @lc code=start

class Solution {
    public Node connect(Node root) {
        Queue<Node> nodes = new LinkedList<>();
        nodes.add(root);

        while (!nodes.isEmpty()) {
            int count = nodes.size();
            while (count-- > 0) {
                Node node = nodes.poll();
                if (node == null) {
                    break;
                }

                if (count > 0) {
                    node.next = nodes.peek();
                }

                nodes.add(node.left);
                nodes.add(node.right);
            }
        }

        return root;
    }
}
// @lc code=end

