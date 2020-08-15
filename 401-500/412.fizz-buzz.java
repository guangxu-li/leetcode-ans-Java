import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode id=412 lang=java
 *
 * [412] Fizz Buzz
 */

// @lc code=start
class Solution {
    public List<String> fizzBuzz(int n) {
        List<String> nums = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            if (i % 3 == 0) {
                if (i % 5 == 0) {
                    nums.add("FizzBuzz");
                } else {
                    nums.add("Fizz");
                }
            } else if (i % 5 == 0) {
                nums.add("Buzz");
            } else {
                nums.add(Integer.toString(i));
            }
        }

        return nums;
    }
}
// @lc code=end

