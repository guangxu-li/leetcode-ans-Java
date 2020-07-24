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
    private int pos = -1;

    private TreeNode dfs(String[] values) {
        pos++;
        if (values[pos].equals("null")) {
            return null;
        }

        TreeNode root = new TreeNode(Integer.parseInt(values[pos]));
        root.left = dfs(values);
        root.right = dfs(values);

        return root;
    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return "null ";
        }

        StringBuilder sb = new StringBuilder();
        sb.append(root.val);
        sb.append(" ");
        sb.append(serialize(root.left));
        sb.append(serialize(root.right));

        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] values = data.split(" ");

        pos = -1;
        return dfs(values);
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
// @lc code=end

