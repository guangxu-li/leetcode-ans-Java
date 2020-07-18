import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

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
    public Node cloneGraph(Node node) {
        if (node == null) {
            return node;
        }

        Queue<Node> nodes = new LinkedList<Node>();
        nodes.add(node);
        Map<Integer, Node> visited = new HashMap<Integer, Node>();
        visited.put(node.val, new Node(node.val, new ArrayList<Node>()));

        while (!nodes.isEmpty()) {
            Node n = nodes.poll();
            Node copyNode = visited.get(n.val);

            for (Node neighbor : n.neighbors) {
                if (!visited.containsKey(neighbor.val)) {
                    visited.put(neighbor.val, new Node(neighbor.val, new ArrayList<Node>()));
                    nodes.add(neighbor);
                }
                copyNode.neighbors.add(visited.get(neighbor.val));
            }
        }

        return visited.get(node.val);
    }
}
// @lc code=end

