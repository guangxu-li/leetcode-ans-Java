import java.util.TreeMap;

/*
 * @lc app=leetcode id=1296 lang=java
 *
 * [1296] Divide Array in Sets of K Consecutive Numbers
 */

// @lc code=start
class Solution {
    private void updateMap(TreeMap<Integer, Integer> cards, int key, int diff) {
        cards.put(key, cards.getOrDefault(key, 0) + diff);
        if (cards.get(key) <= 0) {
            cards.remove(key);
        }
    }

    public boolean isPossibleDivide(int[] nums, int k) {
        if (nums.length % k > 0) {
            return false;
        }

        TreeMap<Integer, Integer> cards = new TreeMap<>();
        for (int num : nums) {
            updateMap(cards, num, 1);
        }

        while (!cards.isEmpty()) {
            int start = cards.firstKey();
            updateMap(cards, start, -1);
            for (int next  = start + 1; next < start + k; next++) {
                if (!cards.containsKey(next)) {
                    return false;
                }

                updateMap(cards, next, -1);
            }
        }

        return true;
    }
}
// @lc code=end

