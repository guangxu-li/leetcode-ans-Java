import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode id=706 lang=java
 *
 * [706] Design HashMap
 */

// @lc code=start
class Pair<U, V> {
    public U key;
    public V value;

    public Pair(U key, V value) {
        this.key = key;
        this.value = value;
    }
}


class MyHashMap {
    List<List<Pair<Integer, Integer>>> keys;
    private int keySpace = 2729;

    /** Initialize your data structure here. */
    public MyHashMap() {
        keys = new ArrayList<>();

        for (int i = 0; i < keySpace; i++) {
            keys.add(new ArrayList<>());
        }
    }

    /** value will always be non-negative. */
    public void put(int key, int value) {
        List<Pair<Integer, Integer>> pairs = keys.get(key % keySpace);
        for (Pair<Integer, Integer> pair : pairs) {
            if (pair.key == key) {
                pair.value = value;
                return;
            }
        }

        pairs.add(new Pair<>(key, value));
    }

    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        for (Pair<Integer, Integer> pair : keys.get(key % keySpace)) {
            if (pair.key == key) {
                return pair.value;
            }
        }

        return -1;
    }

    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        List<Pair<Integer, Integer>> pairs = keys.get(key % keySpace);
        for (Pair<Integer, Integer> pair : pairs) {
            if (pair.key == key) {
                pairs.remove(pair);
                return;
            }
        }
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */
// @lc code=end

