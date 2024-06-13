import java.util.*;

class Solution {
    public int solution(String[][] book_time) {
        Arrays.sort(book_time, (a, b) -> {
            int startCompare = a[0].compareTo(b[0]);
            if (startCompare != 0) {
                return startCompare;
            } else {
                return a[1].compareTo(b[1]);
            }
        });

        PriorityQueue<String> endTimes = new PriorityQueue<>((a, b) -> {
            int endCompare = a.compareTo(b);
            if (endCompare != 0) {
                return endCompare;
            } else {
                return b.compareTo(a);
            }
        });

        int minRooms = 0;
        for (String[] reservation : book_time) {
            while (!endTimes.isEmpty() && reservation[0].compareTo(endTimes.peek()) >= 0) {
                endTimes.poll();
            }
            endTimes.offer(getEndTime(reservation[0], reservation[1]));
            minRooms = Math.max(minRooms, endTimes.size());
        }

        return minRooms;
    }

    private String getEndTime(String start, String end) {
        int startMin = Integer.parseInt(start.substring(0, 2)) * 60 + Integer.parseInt(start.substring(3));
        int endMin = Integer.parseInt(end.substring(0, 2)) * 60 + Integer.parseInt(end.substring(3)) + 10;
        return String.format("%02d:%02d", endMin / 60, endMin % 60);
    }
}
