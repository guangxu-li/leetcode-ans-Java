import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode id=133 lang=java
 *
 * [133] Clone Graph
 */

// @lc code=start
/*
 * // Definition for a Node. class Node { public int val; public List<Node> neighbors;
 * 
 * public Node() { val = 0; neighbors = new ArrayList<Node>(); }
 * 
 * public Node(int _val) { val = _val; neighbors = new ArrayList<Node>(); }
 * 
 * public Node(int _val, ArrayList<Node> _neighbors) { val = _val; neighbors = _neighbors; } }
 */

class Solution {
    private Map<Integer, Node> visited = new HashMap<Integer, Node>();

    public Node cloneGraph(Node node) {
        if (node == null) {
            return node;
        }

        if (visited.containsKey(node.val)) {
            return visited.get(node.val);
        }

        Node copyNode = new Node(node.val, new ArrayList<Node>());
        visited.put(copyNode.val, copyNode);

        for (Node neighbor : node.neighbors) {
            copyNode.neighbors.add(cloneGraph(neighbor));
        }

        return copyNode;
    }
}
// @lc code=end

