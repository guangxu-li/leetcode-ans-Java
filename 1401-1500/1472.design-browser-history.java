import java.util.LinkedList;
import java.util.List;

/*
 * @lc app=leetcode id=1472 lang=java
 *
 * [1472] Design Browser History
 */

// @lc code=start
class BrowserHistory {
    private List<String> historys;
    private int cur;
    private int tail;

    public BrowserHistory(String homepage) {
        historys = new LinkedList<>();
        historys.add(homepage); 
        cur = 0;
        tail = 0;
    }
    
    public void visit(String url) {
        if (cur == historys.size() - 1) {
            historys.add(url);
            cur++;
        } else {
            historys.set(++cur, url);
        }

        tail = cur;
    }
    
    public String back(int steps) {
        cur = Math.max(0, cur - steps);
        return historys.get(cur);
    }
    
    public String forward(int steps) {
        cur = Math.min(tail, cur + steps);
        return historys.get(cur);
    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */
// @lc code=end

