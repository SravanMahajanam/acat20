package OrderedCollection;

import java.util.TreeMap;

public class CalendarEvents {

    public static TreeMap<Integer, Integer> events ;

    public CalendarEvents() {
        events = new TreeMap<Integer, Integer>();
    }

    public static boolean addEvent(int start, int end) {
        Integer ceil = events.ceilingKey(start);
        if (ceil!=null && events.get(ceil) < end) {
            return false;
        }
        Integer floor = events.floorKey(start);
        if (floor!=null && events.get(floor) > start) {
            return false;
        }
        events.put(start, end);
        return true;
    }
}
