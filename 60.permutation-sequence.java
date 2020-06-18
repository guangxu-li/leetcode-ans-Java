import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode id=60 lang=java
 *
 * [60] Permutation Sequence
 */

// @lc code=start
class Solution {
    public String getPermutation(int n, int k) {
        int[] factorial = new int[n];
        List<Integer> nums = new ArrayList<>();

        factorial[0] = 1;
        nums.add(1);
        for (int i = 1; i < n; i++) {
            factorial[i] = i * factorial[i - 1];
            nums.add(i + 1);
        }

        k--;
        StringBuilder permutation = new StringBuilder();
        for (int i = n - 1; i >= 0; i--) {
            int idx = k / factorial[i];
            k -= idx * factorial[i];

            permutation.append(nums.get(idx));
            nums.remove(idx);
        }

        return permutation.toString();
    }
}
// @lc code=end

