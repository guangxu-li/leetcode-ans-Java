import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

/*
 * @lc app=leetcode id=692 lang=java
 *
 * [692] Top K Frequent Words
 */

// @lc code=start
class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        if (k > words.length) {
            return Arrays.asList(words);
        }

        Comparator<Map.Entry<String, Integer>> cmp = new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> word1Freq,
                    Map.Entry<String, Integer> word2Freq) {

                if (word1Freq.getValue() == word2Freq.getValue()) {
                    return word1Freq.getKey().compareTo(word2Freq.getKey());
                } else {
                    return word2Freq.getValue() - word1Freq.getValue();
                }
            }
        };

        Queue<Map.Entry<String, Integer>> wordFrequency =
                new PriorityQueue<Map.Entry<String, Integer>>(cmp);

        Map<String, Integer> map = new HashMap<String, Integer>();

        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        for (Map.Entry<String, Integer> entrySet : map.entrySet()) {
            wordFrequency.add(entrySet);
        }

        List<String> topK = new ArrayList<String>();
        while (k-- > 0) {
            topK.add(wordFrequency.poll().getKey());
        }

        return topK;
    }
}
// @lc code=end

