class Solution {
    static int max = 0;
    static boolean[] visited;
    
    public int solution(int k, int[][] dungeons) {        
        visited = new boolean[dungeons.length];
        dfs(dungeons, 0, k);
        
        return max;
    }
    
    private void dfs(int[][] dungeons, int cnt, int k) {
        for(int i=0; i<dungeons.length; i++) {
            int[] dungeon = dungeons[i];
            
            if(visited[i] || k < dungeon[0]) {
                continue;
            }
            
            visited[i] = true;
            dfs(dungeons, cnt+1, k-dungeon[1]);
            visited[i] = false;
        }
        
        max = Math.max(cnt, max);
    }
}