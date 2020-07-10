import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/*
 * @lc app=leetcode id=126 lang=java
 *
 * [126] Word Ladder II
 */

// @lc code=beginWord
class Solution {
    private List<List<String>> sequences = new ArrayList<>();
    private List<String> sequence = new ArrayList<>();
    private Set<String> wordSet;
    private Map<String, List<String>> connections = new HashMap<>();
    private boolean isBottomUp = false;

    private void searchPath(String beginWord, String endWord) {
        if (beginWord.equals(endWord)) {
            sequences.add(new ArrayList<>(sequence));
            return;
        }

        List<String> candidates = connections.get(beginWord);

        if (candidates == null) {
            return;
        } else {
            for (String candidate : candidates) {
                sequence.add(candidate);
                searchPath(candidate, endWord);
                sequence.remove(sequence.size() - 1);
            }
        }
    }

    private void buildConnections(Set<String> startSet, Set<String> endSet) {
        if (startSet.size() == 0) {
            return;
        }

        Set<String> nextLevel = new HashSet<>();

        wordSet.removeAll(startSet);
        boolean found = false;

        for (String word : startSet) {
            char[] charArray = word.toCharArray();
            for (int i = 0; i < charArray.length; i++) {
                char prev = charArray[i];

                for (char c = 'a'; c <= 'z'; c++) {
                    if (c == prev) {
                        continue;
                    }

                    charArray[i] = c;
                    String linkedWord = String.valueOf(charArray);

                    if (wordSet.contains(linkedWord)) {
                        if (endSet.contains(linkedWord)) {
                            found = true;
                        } else {
                            nextLevel.add(linkedWord);
                        }

                        String key = isBottomUp ? linkedWord : word;
                        String val = isBottomUp ? word : linkedWord;

                        if (!connections.containsKey(key)) {
                            connections.put(key, new ArrayList<>());
                        }
                        connections.get(key).add(val);
                    }
                }

                charArray[i] = prev;
            }
        }

        if (!found) {
            if (nextLevel.size() > endSet.size()) {
                isBottomUp = !isBottomUp;
                buildConnections(endSet, nextLevel);
            } else {
                buildConnections(nextLevel, endSet);
            }
        }
    }

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        this.wordSet = new HashSet<>(wordList);

        if (!wordSet.contains(endWord)) {
            return sequences;
        }

        Set<String> startSet = new HashSet<>();
        startSet.add(beginWord);
        Set<String> endSet = new HashSet<>();
        endSet.add(endWord);
        buildConnections(startSet, endSet);

        sequence.add(beginWord);
        searchPath(beginWord, endWord);

        return sequences;
    }
}
// @lc code=endWord

