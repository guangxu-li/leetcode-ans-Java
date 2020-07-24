import java.util.LinkedList;
import java.util.Queue;

/*
 * @lc app=leetcode id=297 lang=java
 *
 * [297] Serialize and Deserialize Binary Tree
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        Queue<TreeNode> nodes = new LinkedList<>();
        nodes.add(root);

        StringBuilder sb = new StringBuilder();

        while (!nodes.isEmpty()) {
            TreeNode node = nodes.poll();

            if (node == null) {
                sb.append("null");
            } else {
                sb.append(node.val);

                nodes.add(node.left);
                nodes.add(node.right);
            }

            sb.append(" ");
        }

        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] values = data.split(" ");

        TreeNode root = null;
        if (values[0].equals("null")) {
            return root;
        } else {
            root = new TreeNode(Integer.parseInt(values[0]));
        }

        Queue<TreeNode> nodes = new LinkedList<>();
        nodes.add(root);

        int i = 0;
        while (!nodes.isEmpty()) {
            int size = nodes.size();

            while (size-- > 0) {
                TreeNode node = nodes.poll();

                if (values[++i].equals("null")) {
                    node.left = null;
                } else {
                    node.left = new TreeNode(Integer.parseInt(values[i]));
                }

                if (node.left != null) {
                    nodes.add(node.left);
                }

                if (values[++i].equals("null")) {
                    node.right = null;
                } else {
                    node.right = new TreeNode(Integer.parseInt(values[i]));
                }

                if (node.right != null) {
                    nodes.add(node.right);
                }
            }
        }

        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
// @lc code=end

