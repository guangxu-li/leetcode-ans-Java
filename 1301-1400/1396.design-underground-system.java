import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode id=1396 lang=java
 *
 * [1396] Design Underground System
 */

// @lc code=start
class Event {
    public String station;
    public int time;

    public Event(String station, int time) {
        this.station = station;
        this.time = time;
    }
}


class Route {
    public double duration;
    public int count;

    public Route(double duration, int count) {
        this.duration = duration;
        this.count = count;
    }

    public double getAvg() {
        return duration / count;
    }
}


class UndergroundSystem {
    private Map<Integer, Event> checkIn;
    private Map<String, Route> checkOut;

    public UndergroundSystem() {
        checkIn = new HashMap<>();
        checkOut = new HashMap<>();
    }

    public void checkIn(int id, String stationName, int t) {
        checkIn.put(id, new Event(stationName, t));
    }

    public void checkOut(int id, String stationName, int t) {
        Event e = checkIn.remove(id);

        String route = e.station + "->" + stationName;
        Route r = checkOut.getOrDefault(route, new Route(0, 0));

        checkOut.put(route, new Route(r.duration + t - e.time, r.count + 1));
    }

    public double getAverageTime(String startStation, String endStation) {
        return checkOut.get(startStation + "->" + endStation).getAvg();
    }
}

/**
 * Your UndergroundSystem object will be instantiated and called as such:
 * UndergroundSystem obj = new UndergroundSystem();
 * obj.checkIn(id,stationName,t);
 * obj.checkOut(id,stationName,t);
 * double param_3 = obj.getAverageTime(startStation,endStation);
 */
// @lc code=end

