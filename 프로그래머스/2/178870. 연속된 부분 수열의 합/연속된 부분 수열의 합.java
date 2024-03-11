class Solution {
    public int[] solution(int[] sequence, int k) {
        int[] answer = {0, sequence.length-1};
        
        if(sequence[0] == k) {
            return new int[]{0,0};
        }
        
        int p1 = 0;
        int p2 = 1;
        int sum = sequence[0] + sequence[1];
        
        while(p2 >= p1) {
            if(sum == k) {
                if(p2 - p1 < answer[1] - answer[0]) {
                    answer[0] = p1;
                    answer[1] = p2;
                }
                sum -= sequence[p1++];
            } else if(sum > k) {
                sum -= sequence[p1++];
            } else if(p2 < sequence.length - 1) {
                sum += sequence[++p2];
            } else {
                break;
            }
        }
          
        return answer;
    }
}