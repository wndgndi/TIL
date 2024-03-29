import java.util.*;

class Solution {
    static List<int[]> list = new ArrayList<>();
    
    public int[][] solution(int n) {
        int[][] answer = {};
        move(n, 1, 2, 3);
        return list.stream().toArray(int[][]::new);
    }
    
    public void move(int cnt, int start, int mid, int end) {
        if(cnt == 0) {
            return;
        }
        move(cnt-1, start, end, mid);
        list.add(new int[]{start, end});
        move(cnt-1, mid, start, end);
    }
}