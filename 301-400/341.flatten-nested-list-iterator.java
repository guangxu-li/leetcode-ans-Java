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
    private Deque<Counter> indices = new ArrayDeque<>();
    private Deque<List<NestedInteger>> lists = new ArrayDeque<>();

    private void flattenNext() {
        while (!lists.isEmpty()) {
            if (indices.peek().i == lists.peek().size()) {
                indices.pop();
                lists.pop();

                continue;
            }

            if (lists.peek().get(indices.peek().i).isInteger()) {
                break;
            }

            lists.push(lists.peek().get(indices.peek().i++).getList());
            indices.push(new Counter());
        }
    }

    public NestedIterator(List<NestedInteger> nestedList) {
        indices.push(new Counter());
        lists.push(nestedList);
    }

    @Override
    public Integer next() {
        return lists.peek().get(indices.peek().i++).getInteger();
    }

    @Override
    public boolean hasNext() {
        flattenNext();

        return !lists.isEmpty();
    }
}


class Counter {
    public int i = 0;

    public Counter() {
    }

    public Counter(int i) {
        this.i = i;
    }
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */
// @lc code=end

