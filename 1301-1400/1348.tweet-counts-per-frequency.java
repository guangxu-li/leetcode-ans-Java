import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * @lc app=leetcode id=1348 lang=java
 *
 * [1348] Tweet Counts Per Frequency
 */

// @lc code=start
class TweetCounts {
    Map<String, List<Integer>> records;

    public TweetCounts() {
        this.records = new HashMap<>(); 
    }
    
    public void recordTweet(String tweetName, int time) {
        records.putIfAbsent(tweetName, new ArrayList<>());
        records.get(tweetName).add(time);
    }
    
    public List<Integer> getTweetCountsPerFrequency(String freq, String tweetName, int startTime, int endTime) {
        int interval = 60;

        if (freq.equals("hour")) {
            interval *= 60;
        } else if (freq.equals("day")) {
            interval *= 24 * 60;
        }

        List<Integer> cnts = new ArrayList<>();
        int size = (endTime - startTime) / interval + 1;
        int[] counts = new int[size];

        if (records.containsKey(tweetName)) {
            for (int time : records.get(tweetName)) {
                if (time < startTime || time > endTime) {
                    continue;
                }

                int idx = (time - startTime) / interval;
                counts[idx]++;
            }
        }

        for (int cnt : counts) {
            cnts.add(cnt);
        }

        return cnts;
    }
}

/**
 * Your TweetCounts object will be instantiated and called as such:
 * TweetCounts obj = new TweetCounts();
 * obj.recordTweet(tweetName,time);
 * List<Integer> param_2 = obj.getTweetCountsPerFrequency(freq,tweetName,startTime,endTime);
 */
// @lc code=end

