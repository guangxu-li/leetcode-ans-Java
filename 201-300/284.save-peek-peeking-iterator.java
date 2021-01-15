import java.util.Iterator;
import java.util.NoSuchElementException;

/*
 * @lc app=leetcode id=284 lang=java
 *
 * [284] Peeking Iterator
 */

// @lc code=start
// Java Iterator interface reference:
// https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html

class PeekingIterator implements Iterator<Integer> {
	private Iterator<Integer> iter;
	private Integer p = null;

	public PeekingIterator(Iterator<Integer> iterator) {
		// initialize any member here.
		this.iter = iterator;
	}
	
    // Returns the next element in the iteration without advancing the iterator.
	public Integer peek() {
		p = next();

		return p;
	}
	
	// hasNext() and next() should behave the same as in the Iterator interface.
	// Override them if needed.
	@Override
	public Integer next() {
		if (p != null) {
			int n = p;
			p = null;

			return n;
		}

		if (!iter.hasNext()) {
			throw new NoSuchElementException();
		}

		return iter.next();
	}
	
	@Override
	public boolean hasNext() {
		return p != null || iter.hasNext();
	}
}
// @lc code=end

