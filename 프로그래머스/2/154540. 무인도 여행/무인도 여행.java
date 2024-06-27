import java.util.*;

class Solution {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int[][] map;
    static List<Integer> list = new ArrayList<>();
    static boolean[][] visited;
    static int cnt = 0;
    
    public int[] solution(String[] maps) {
        int[] answer = {};
        map = new int[maps.length][maps[0].length()];
        visited = new boolean[maps.length][maps[0].length()];
        
        for(int i=0; i<map.length; i++) {
            String[] str = maps[i].split("");
            for(int j=0; j<str.length; j++) {
                if("X".equals(str[j])) {
                    map[i][j] = 0;
                } else {
                    map[i][j] = Integer.parseInt(str[j]);
                }
            }
        }
        
        for(int i=0; i<map.length; i++) {
            for(int j=0; j<map[i].length; j++) {
                if(map[i][j] != 0 && !visited[i][j]) {
                    dfs(i, j);
                    list.add(cnt);
                    cnt = 0;
                }
            }
        }
        
        if(list.isEmpty()) {
            return new int[]{-1};
        }
        
        Collections.sort(list);
        answer = list.stream().mapToInt(n -> n).toArray();

        return answer;
    }
    
    private void dfs(int y, int x){
        cnt += map[y][x];
        visited[y][x] = true;
        
        for(int i=0; i<4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            
            if(nx >= 0 && ny >= 0 && nx < map[0].length && ny < map.length
              && !visited[ny][nx] && map[ny][nx] != 0) {
                visited[ny][nx] = true;
                dfs(ny, nx);
            }
        }
    }
}