import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/*
 * @lc app=leetcode id=341 lang=java
 *
 * [341] Flatten Nested List Iterator
 */

// @lc code=start
/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
public class NestedIterator implements Iterator<Integer> {
    private List<Integer> nums = new ArrayList<>();
    private int i = 0;

    private void flattenList(List<NestedInteger> nestedList) {
        nestedList.forEach(l -> {
            if (l.isInteger()) {
                nums.add(l.getInteger());
            } else {
                flattenList(l);
            }
        });
    }

    public NestedIterator(List<NestedInteger> nestedList) {
        flattenList(nestedList);
    }

    @Override
    public Integer next() {
        return nums.get(i++);
    }

    @Override
    public boolean hasNext() {
        return i < nums.size();
    }
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */
// @lc code=end

