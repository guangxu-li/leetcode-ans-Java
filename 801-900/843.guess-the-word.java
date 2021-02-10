import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * @lc app=leetcode id=843 lang=java
 *
 * [843] Guess the Word
 */

// @lc code=start
/**
 * // This is the Master's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface Master {
 *     public int guess(String word) {}
 * }
 */
class Solution {
    private int match(String w1, String w2) {
        int cnt = 0;
        for (int i = 0; i < w1.length(); i++) {
            if (w1.charAt(i) == w2.charAt(i)) {
                cnt++;
            }
        }

        return cnt;
    }

    private String pick(List<String> words) {
        int n = words.size();
        int[] cnts = new int[n];

        String word = "";
        int max = 0;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (match(words.get(i), words.get(j)) > 0) {
                    cnts[i]++;
                    cnts[j]++;
                }
            }

            if (cnts[i] >= max) {
                max = cnts[i];
                word = words.get(i);
            }
        }

        return word;
    }

    private List<String> candidates(String guess, int match, List<String> words) {
        List<String> candidates = new ArrayList<>();

        for (String word : words) {
            if (match(guess, word) == match) {
                candidates.add(word);
            }
        }

        return candidates;
    }

    public void findSecretWord(String[] wordlist, Master master) {
        List<String> words = new ArrayList<>(Arrays.asList(wordlist));
        while (!words.isEmpty()) {
            String word = pick(words);
            int match = master.guess(word);

            if (match == 6) {
                return;
            }

            words = candidates(word, match, words);
        }
    }
}
// @lc code=end

