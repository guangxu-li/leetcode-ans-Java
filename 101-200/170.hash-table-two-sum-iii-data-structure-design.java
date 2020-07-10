import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode id=170 lang=java
 *
 * [170] Two Sum III - Data structure design
 */

// @lc code=start
class TwoSum {
    private Map<Integer, Integer> nums;

    /** Initialize your data structure here. */
    public TwoSum() {
        nums = new HashMap<>();
    }

    /** Add the number to an internal data structure.. */
    public void add(int number) {
        nums.put(number, nums.getOrDefault(number, 0) + 1);
    }

    /** Find if there exists any pair of numbers which sum is equal to the value. */
    public boolean find(int value) {
        for (Map.Entry<Integer, Integer> entry : nums.entrySet()) {
            int complement = value - entry.getKey();

            if (nums.containsKey(complement)) {
                if (complement != entry.getKey() || nums.get(complement) >= 2) {
                    return true;
                }
            }
        }

        return false;
    }
}

/**
 * Your TwoSum object will be instantiated and called as such:
 * TwoSum obj = new TwoSum();
 * obj.add(number);
 * boolean param_2 = obj.find(value);
 */
// @lc code=end

