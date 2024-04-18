import java.util.*;

class Solution {
    static boolean[][] visited;
    static int[][] arr;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    
    public int solution(int[][] maps) {
        int answer = 0;
        visited = new boolean[maps.length][];
        arr = new int[maps.length][];
        
        for(int i=0; i<maps.length; i++) {
            visited[i] = new boolean[maps[i].length];
            arr[i] = new int[maps[i].length];
        }
        arr[0][0] = 1;


        bfs(0, 0, maps);

                
       if(arr[maps.length - 1][maps[maps.length - 1].length - 1] == 0) {
            answer = -1;
        } else {
            answer = arr[maps.length - 1][maps[maps.length - 1].length - 1];
        }

        return answer;
    }
    
    public void bfs(int n, int m, int[][] maps) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{n, m});
        
        while(!queue.isEmpty()) {
            int[] arr2 = queue.poll();
            int x = arr2[0];
            int y = arr2[1];
            
            for(int i=0; i<4; i++) {
                int x2 = x + dx[i];
                int y2 = y + dy[i];
                
                if(x2 >= 0 && y2 >= 0 && x2 < maps.length && y2 < maps[x2].length) {
                    if(maps[x2][y2] == 1 && !visited[x2][y2]) {
                        visited[x2][y2] = true;
                        if(arr[x2][y2] == 0) {
                            arr[x2][y2] = arr[x][y] + 1;
                        } else {
                            arr[x2][y2] = Math.min(arr[x2][y2], arr[x][y] + 1);
                        }
                        queue.offer(new int[]{x2, y2});
                    }
                }
            }
        }
        
    }
}