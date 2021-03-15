import java.util.TreeMap;

/*
 * @lc app=leetcode id=846 lang=java
 *
 * [846] Hand of Straights
 */

// @lc code=start
class Solution {
    private void updateMap(TreeMap<Integer, Integer> map, int key, int diff) {
        map.put(key, map.getOrDefault(key, 0) + diff);
        if (map.get(key) == 0) {
            map.remove(key);
        }
    }

    public boolean isNStraightHand(int[] hand, int W) {
        if (hand.length % W > 0) {
            return false;
        }

        TreeMap<Integer, Integer> cards = new TreeMap<>();
        for (int card : hand) {
            updateMap(cards, card, 1);
        }

        while (!cards.isEmpty()) {
            int min = cards.firstKey();
            updateMap(cards, min, -1);

            for (int i = 0, prev = min; i < W - 1; i++) {
                Integer next = cards.higherKey(prev);
                if (next == null || prev + 1 < next) {
                    return false;
                }
                updateMap(cards, next, -1);
                prev = next;
            }
        }

        return true;
    }
}
// @lc code=end

