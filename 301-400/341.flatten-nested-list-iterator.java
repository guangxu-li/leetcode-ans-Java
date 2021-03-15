import java.util.ArrayDeque;
import java.util.Deque;
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
    private Deque<NestedInteger> nested;

    public NestedIterator(List<NestedInteger> nestedList) {
        this.nested = new ArrayDeque<>();
        flattenList(nestedList);
    }
    
    private void flattenList(List<NestedInteger> list) {
        for (int i = list.size() - 1; i >= 0; i--) {
            nested.push(list.get(i));
        }
    }

    @Override
    public Integer next() {
        return hasNext() ? nested.pop().getInteger() : null;
    }

    @Override
    public boolean hasNext() {
        while (!nested.isEmpty()) {
            if (nested.peek().isInteger()) {
                return true;
            }

            flattenList(nested.pop().getList());
        }

        return false;
    }
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */
// @lc code=end

