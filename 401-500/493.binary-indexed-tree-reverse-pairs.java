import java.util.Arrays;

/*
 * @lc app=leetcode id=493 lang=java
 *
 * [493] Reverse Pairs
 */

// @lc code=start
class Solution {
    private int binarySearch(int[] arr, long target) {
        int lo = 0;
        int hi = arr.length - 1;
        while (lo <= hi) {
            int mid = (lo + hi) >>> 1;
            if (arr[mid] >= target) {
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }

        return lo;
    }

    private void update(int[] bits, int i) {
        while (i > 0 && i < bits.length) {
            bits[i]++;
            i -= i & -i;
        }
    }

    private int query(int[] bits, int i) {
        int cnt = 0;
        while (i < bits.length) {
            cnt += bits[i];
            i += i & -i;
        }
        return cnt;
    }

    public int reversePairs(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        int[] sorted = nums.clone();
        Arrays.sort(sorted);

        int[] bits = new int[nums.length + 1];

        int cnt = 0;
        for (int num : nums) {
            int i =  binarySearch(sorted, 2l * num + 1);
            cnt += query(bits, i + 1);

            i = binarySearch(sorted, num);
            update(bits, i + 1);
        }

        return cnt;
    }
}
// @lc code=end


