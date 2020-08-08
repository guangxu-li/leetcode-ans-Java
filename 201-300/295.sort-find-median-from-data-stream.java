import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode id=295 lang=java
 *
 * [295] Find Median from Data Stream
 */

// @lc code=start
class MedianFinder {
    private List<Integer> nums;

    private int getInsertionPoint(int num) {
        int lo = 0;
        int hi = nums.size() - 1;

        while (lo <= hi) {
            int mid = (lo + hi) >> 1;

            if (nums.get(mid) < num) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }

        return lo;
    }

    /** initialize your data structure here. */
    public MedianFinder() {
        nums = new ArrayList<>();
    }

    public void addNum(int num) {
        if (nums.size() == 0 || nums.get(nums.size() - 1) <= num) {
            nums.add(num);
        } else {
            int i = getInsertionPoint(num);

            nums.add(i, num);
        }
    }

    public double findMedian() {
        int n = nums.size();

        return n % 2 == 1 ? nums.get(n / 2) : ((double) nums.get(n / 2 - 1) + nums.get(n / 2)) / 2;
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
// @lc code=end

