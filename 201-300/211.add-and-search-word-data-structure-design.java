import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode id=211 lang=java
 *
 * [211] Design Add and Search Words Data Structure
 */

// @lc code=start
class TrieNode {
    public Map<Character, TrieNode> children = new HashMap<>();
    public boolean isWord = false;

    public TrieNode() {
    }

    public void add(char ch) {
        children.putIfAbsent(ch, new TrieNode());
    }

    public TrieNode get(char ch) {
        return children.get(ch);
    }
}


class WordDictionary {
    private TrieNode root;

    /** Initialize your data structure here. */
    public WordDictionary() {
        root = new TrieNode();
    }

    private boolean dfs(char[] cs, int pos, TrieNode node) {
        for (int i = pos; i < cs.length; i++) {
            if (cs[i] == '.') {
                for (TrieNode next : node.children.values()) {
                    if (dfs(cs, i + 1, next)) {
                        return true;
                    }
                }

                return false;
            } else {
                node = node.get(cs[i]);

                if (node == null) {
                    return false;
                }
            }
        }

        return node.isWord;
    }

    /** Adds a word into the data structure. */
    public void addWord(String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            node.add(c);
            node = node.get(c);
        }

        node.isWord = true;
    }

    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        return dfs(word.toCharArray(), 0, root);
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
// @lc code=end

