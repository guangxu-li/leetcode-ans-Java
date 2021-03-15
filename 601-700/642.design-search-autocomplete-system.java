import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * @lc app=leetcode id=642 lang=java
 *
 * [642] Design Search Autocomplete System
 */

// @lc code=start
class Trie {
    public Map<Character, Trie> children = new HashMap<>();
    public String word = "";
    public boolean isWord = false;
    public int times = 0;

    public Trie get(char c) {
        children.putIfAbsent(c, new Trie());
        return children.get(c);
    }
}


class AutocompleteSystem {
    // private Map<String, Integer> counter = new HashMap<>();
    private Trie root = new Trie();
    private Trie cur = root;
    private StringBuilder input = new StringBuilder();

    public AutocompleteSystem(String[] sentences, int[] times) {
        for (int i = 0; i < sentences.length; i++) {
            Trie node = root;
            for (char c : sentences[i].toCharArray()) {
                node = node.get(c);
            }
            node.isWord = true;
            node.word = sentences[i];
            node.times += times[i];
        }
    }

    private void search(Map<String, Integer> counter, Trie node) {
        if (node.isWord) {
            counter.put(node.word, node.times);
        }

        for (Trie child : node.children.values()) {
            search(counter, child);
        }
    }

    public List<String> input(char c) {
        if (c == '#') {
            cur.isWord = true;
            cur.times += 1;
            cur.word = input.toString();

            cur = root;
            input = new StringBuilder();

            return new ArrayList<>();
        } else {
            input.append(c);
            cur = cur.get(c);

            Map<String, Integer> counter = new HashMap<>();
            search(counter, cur);

            List<String> candidates = new ArrayList<>(counter.keySet());
            Collections.sort(candidates, (a, b) -> counter.get(a) == counter.get(b) ? a.compareTo(b)
                    : counter.get(b) - counter.get(a));

            return candidates.subList(0, Math.min(candidates.size(), 3));
        }
    }
}

/**
 * Your AutocompleteSystem object will be instantiated and called as such:
 * AutocompleteSystem obj = new AutocompleteSystem(sentences, times);
 * List<String> param_1 = obj.input(c);
 */
// @lc code=end

