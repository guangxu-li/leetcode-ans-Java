/*
 * @lc app=leetcode id=164 lang=java
 *
 * [164] Maximum Gap
 */

// @lc code=start
class Bucket {
    public boolean used = false;
    public int min = Integer.MAX_VALUE;
    public int max = Integer.MIN_VALUE;

    public void update(int num) {
        used = true;

        min = Math.min(min, num);
        max = Math.max(max, num);
    }
}


class Solution {
    public int maximumGap(int[] nums) {
        if (nums.length < 2) {
            return 0;
        }

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int num : nums) {
            min = Math.min(min, num);
            max = Math.max(max, num);
        }

        int bucketSize = Math.max(1, (max - min) / (nums.length + 1));
        int bucketNum = (max - min) / bucketSize + 1;
        Bucket[] buckets = new Bucket[bucketNum];

        for (int i = 0; i < buckets.length; i++) {
            buckets[i] = new Bucket();
        }

        for (int num : nums) {
            int idx = (num - min) / bucketSize;
            buckets[idx].update(num);
        }

        int prevMax = min;
        int maxGap = 0;

        for (Bucket bucket : buckets) {
            if (!bucket.used) {
                continue;
            }

            maxGap = Math.max(maxGap, bucket.min - prevMax);
            prevMax = bucket.max;
        }

        return maxGap;
    }
}
// @lc code=end

