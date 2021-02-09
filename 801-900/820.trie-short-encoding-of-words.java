import java.util.HashSet;
import java.util.Set;

/*
 * @lc app=leetcode id=820 lang=java
 *
 * [820] Short Encoding of Words
 */

// @lc code=start
class TrieNode {
    private TrieNode[] children = new TrieNode[26];
    public boolean isLeaf = true;
    public int depth = 0;

    public TrieNode(int depth) {
        this.depth = depth;
    }

    public void put(char c) {
        if (children[c - 'a'] == null) {
            children[c - 'a'] = new TrieNode(depth + 1);
            isLeaf = false;
        }
    }

    public TrieNode get(char c) {
        return children[c - 'a'];
    }
}

class Solution {
    public int minimumLengthEncoding(String[] words) {
        TrieNode root = new TrieNode(0);
        Set<TrieNode> nodes = new HashSet<>();

        for (String word : words) {
            TrieNode node = root;
            for (int i = word.length() - 1; i >= 0; i--) {
                char c = word.charAt(i);
                node.put(word.charAt(i)); 
                node = node.get(c);
            }

            nodes.add(node); 
        }

        int len = 0;
        for (TrieNode node : nodes) {
            if (node.isLeaf) {
                len += 1 + node.depth;
            }
        }

        return len;
    }
}
// @lc code=end

