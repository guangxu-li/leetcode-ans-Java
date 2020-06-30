import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
 * @lc app=leetcode id=170 lang=java
 *
 * [170] Two Sum III - Data structure design
 */

// @lc code=start
class TwoSum {
    private List<Integer> nums;

    private boolean isSorted;

    /** Initialize your data structure here. */
    public TwoSum() {
        nums = new ArrayList<>();

        isSorted = true;
    }

    /** Add the number to an internal data structure.. */
    public void add(int number) {
        nums.add(number);
        isSorted = false;
    }

    /** Find if there exists any pair of numbers which sum is equal to the value. */
    public boolean find(int value) {
        if (!isSorted) {
            Collections.sort(nums);
            isSorted = true;
        }

        int lo = 0;
        int hi = nums.size() - 1;

        while (lo < hi) {
            int sum = nums.get(lo) + nums.get(hi);

            if (sum == value) {
                return true;
            } else if (sum > value) {
                hi--;
            } else {
                lo++;
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

