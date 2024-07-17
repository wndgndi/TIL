class Solution {
    static int N, min;
    static int[] arr;
    static int[] answer = {-1};
    
    public int[] solution(int n, int[] info) {        
        N = n;
        min = -1;
        arr = new int[11];
        dfs(info, 0, 0);
        
        return answer;
    }
    
    private void dfs(int[] apeach, int idx, int cnt) {
        if(idx == 11) {
            if(cnt == N) {
                int aScore = 0, lScore = 0;
                for(int i=0; i<11; i++) {
                    if(apeach[i] == 0 && arr[i] == 0) {
                        continue;
                    }
                    
                    if(apeach[i] >= arr[i]) {
                        aScore += 10 - i;
                    } else {
                        lScore += 10 - i;
                    }
                }
                
                if(lScore > aScore) {
                    if(lScore - aScore > min) {
                        min = lScore - aScore;
                        answer = arr.clone();
                    } else if(lScore - aScore == min) {
                        for(int i=10; i>=0; i--) {
                            if(answer[i] < arr[i]) {
                                answer = arr.clone();
                                return;
                            } else if(answer[i] > arr[i]) {
                                return;
                            }
                        }
                    } 
                }
            }
            return;
        }
        
        if(apeach[idx] == 0) {
            dfs(apeach, idx+1, cnt);
        }
        
        if(cnt + 1 + apeach[idx] <= N) {
            arr[idx] = apeach[idx] + 1;
            dfs(apeach, idx + 1, cnt + 1 + apeach[idx]);
            arr[idx] = 0;
        }
        
        if(apeach[idx] != 0) {
            for(int i=0; i <= apeach[idx]; i++) {
                arr[idx] = i;
                dfs(apeach, idx + 1, cnt + i);
                arr[idx] = 0;
            }
        }
    }
}