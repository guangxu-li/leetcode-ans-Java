import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * @lc app=leetcode id=981 lang=java
 *
 * [981] Time Based Key-Value Store
 */

// @lc code=start
class TimeMap {
    private class Value {
        String value;
        int timestamp;

        public Value(String value, int timestamp) {
            this.value = value;
            this.timestamp = timestamp;
        }
    }

    private Map<String, List<Value>> map;

    /** Initialize your data structure here. */
    public TimeMap() {
        map = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        List<Value> values = map.getOrDefault(key, new ArrayList<>());
        values.add(new Value(value, timestamp));
        map.put(key, values);
    }

    public String get(String key, int timestamp) {
        if (!map.containsKey(key)) {
            return "";
        }

        List<Value> values = map.get(key);
        int lo = 0;
        int hi = values.size() - 1;

        while (lo <= hi) {
            int mid = (lo + hi) >> 1;

            Value value = values.get(mid);
            if (value.timestamp <= timestamp) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }

        return hi == -1 ? "" : values.get(hi).value;
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */
// @lc code=end

