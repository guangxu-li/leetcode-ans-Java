import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode id=78 lang=java
 *
 * [78] Subsets
 */

// @lc code=start
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> combinations = new ArrayList<>();
        combinations.add(new ArrayList<>());

        for (int num : nums) {
            List<List<Integer>> expand = new ArrayList<>();

            for (List<Integer> list : combinations) {
                List<Integer> tmp = new ArrayList<>(list);
                tmp.add(num);
                expand.add(tmp);
            }

            combinations.addAll(expand);
        }

        return combinations;
    }
}
// @lc code=end

