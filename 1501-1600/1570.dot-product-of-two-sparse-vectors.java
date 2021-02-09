import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/*
 * @lc app=leetcode id=1570 lang=java
 *
 * [1570] Dot Product of Two Sparse Vectors
 */

// @lc code=start
class SparseVector {
    private Map<Integer, Integer> sparseVec = new HashMap<>();
    
    SparseVector(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                sparseVec.put(i, nums[i]);
            }
        }
    }
    
	// Return the dotProduct of two sparse vectors
    public int dotProduct(SparseVector vec) {
        Set<Integer> intersection = new HashSet<>(this.sparseVec.keySet());
        intersection.retainAll(vec.sparseVec.keySet());
        int product = 0;
        for (int i : intersection) {
            product += sparseVec.get(i) * vec.sparseVec.get(i);
        }

        return product;
    }
}

// Your SparseVector object will be instantiated and called as such:
// SparseVector v1 = new SparseVector(nums1);
// SparseVector v2 = new SparseVector(nums2);
// int ans = v1.dotProduct(v2);
// @lc code=end

