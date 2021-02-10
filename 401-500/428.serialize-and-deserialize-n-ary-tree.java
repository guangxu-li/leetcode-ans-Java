import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
 * @lc app=leetcode id=428 lang=java
 *
 * [428] Serialize and Deserialize N-ary Tree
 */

// @lc code=start
/*
 * // Definition for a Node. class Node { public int val; public List<Node> children;
 * 
 * public Node() {}
 * 
 * public Node(int _val) { val = _val; }
 * 
 * public Node(int _val, List<Node> _children) { val = _val; children = _children; } };
 */

class Codec {
    // Encodes a tree to a single string.
    public String serialize(Node root) {
        if (root == null) {
            return "";
        }

        Queue<Node> nodes = new LinkedList<>();
        nodes.add(root);

        StringBuilder code = new StringBuilder();
        code.append(root.val).append('#').append('-');

        while (!nodes.isEmpty()) {
            code.append('|');

            int size = nodes.size();
            while (size-- > 0) {
                Node node = nodes.poll();

                for (Node child : node.children) {
                    code.append(child.val).append('#');
                    nodes.add(child);
                }

                code.append('-');
            }
        }

        return code.toString();
    }

    // Decodes your encoded data to tree.
    public Node deserialize(String data) {
        if (data.isEmpty()) {
            return null;
        }

        String[] levels = data.split("\\|");
        Node head = new Node(0, new LinkedList<>());
        List<Node> prev = new LinkedList<>();
        prev.add(head);
        int idx = 0;

        for (int i = 0; i < levels.length; i++) {
            String level = levels[i];
            String[] sections = level.split("-");
            List<Node> cur = new LinkedList<>();

            for (String section : sections) {
                String[] children = section.split("\\#");

                for (int j = 0; j < children.length && !section.isEmpty(); j++) {
                    Node node = new Node(Integer.parseInt(children[j]), new LinkedList<>());
                    cur.add(node);
                    prev.get(idx).children.add(node);
                }

                idx++;
            }

            idx = 0;
            prev = cur;
        }

        return head.children.get(0);
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
// @lc code=end


