import java.util.*;

class Solution {
    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        int[][] answer = {};
        PriorityQueue<int[]> pq;
        
        if("code".equals(sort_by)) {
            pq = new PriorityQueue<>(new Comparator<int[]>() {
                    public int compare(int[] o1, int[] o2) {
                        return o1[0] - o2[0];
                    }
            });
        } else if("date".equals(sort_by)) {
            pq = new PriorityQueue<>(new Comparator<int[]>() {
                public int compare(int[] o1, int[] o2) {
                    return o1[1] - o2[1];
                }
            });
        } else if("maximum".equals(sort_by)) {
            pq = new PriorityQueue<>(new Comparator<int[]>() {
                public int compare(int[] o1, int[] o2) {
                    return o1[2] - o2[2];
                }
            });
        } else {
            pq = new PriorityQueue<>(new Comparator<int[]>() {
                public int compare(int[] o1, int[] o2) {
                    return o1[3] - o2[3];
                }
            });
        }
        
        for(int i=0; i<data.length; i++) {
            if("code".equals(ext)) {
                if(data[i][0] < val_ext) {
                    pq.add(data[i]);
                }
            } else if("date".equals(ext)) {
                if(data[i][1] < val_ext) {
                    pq.add(data[i]);
                }
            } else if("maximum".equals(ext)) {
                if(data[i][2] < val_ext) {
                    pq.add(data[i]);
                }
            } else {
                if(data[i][3] < val_ext) {
                    pq.add(data[i]);
                }
            }
        }

        answer = new int[pq.size()][];
        int idx = 0;
        
        while(!pq.isEmpty()) {
            answer[idx++] = pq.poll();
        }
        
        return answer;
    }
}