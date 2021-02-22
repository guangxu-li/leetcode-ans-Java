import java.util.TreeMap;

/*
 * @lc app=leetcode id=846 lang=java
 *
 * [846] Hand of Straights
 */

// @lc code=start
class Solution {
    private void updateMap(TreeMap<Integer, Integer> cards, int key, int diff) {
        cards.put(key, cards.getOrDefault(key, 0) + diff);
        if (cards.get(key) <= 0) {
            cards.remove(key);
        }
    }

    public boolean isNStraightHand(int[] hand, int W) {
        if (hand.length % W != 0) {
            return false;
        }

        TreeMap<Integer, Integer> cards = new TreeMap<>();
        for (int card : hand) {
            updateMap(cards, card, 1);
        }

        while (!cards.isEmpty()) {
            int start = cards.firstKey();
            updateMap(cards, start, -1);

            for (int i = start + 1; i < start + W; i++) {
                if (!cards.containsKey(i)) {
                    return false;
                }

                updateMap(cards, i, -1);
            }
        }

        return true;
    }
}
// @lc code=end

