/*
 * Problem: 732. My Calendar III
 * Difficulty: Hard
 * Topics: Design, Ordered Map, Sweep Line
 *
 * Approach:
 * 1. Store each booking's start and end events in a TreeMap.
 * 2. Increment the count at the start time.
 * 3. Decrement the count at the end time.
 * 4. Traverse the events in chronological order.
 * 5. Track the maximum number of overlapping bookings.
 *
 * Time Complexity: O(n log n) per booking
 * Space Complexity: O(n)
 */

import java.util.TreeMap;

class MyCalendarThree {
    private final TreeMap<Integer, Integer> events;
    private int maxOverlap;

    public MyCalendarThree() {
        events = new TreeMap<>();
        maxOverlap = 0;
    }

    public int book(int startTime, int endTime) {
        events.put(startTime,
                events.getOrDefault(startTime, 0) + 1);

        events.put(endTime,
                events.getOrDefault(endTime, 0) - 1);

        int activeBookings = 0;
        maxOverlap = 0;

        for (int count : events.values()) {
            activeBookings += count;
            maxOverlap = Math.max(maxOverlap, activeBookings);
        }

        return maxOverlap;
    }
}