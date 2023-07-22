class Solution {
    public int solution(int[][] dots) {
        int answer = 0;
        
        for(int i=0; i<dots.length; i++) {

            double a = check(dots[i%4], dots[(i+1)%4]);
            double b = check(dots[(i+2)%4], dots[(i+3)%4]);
            
            if(a == b) {
                answer = 1;
                break;
            }
        }
        
        return answer;
    }
    
    public static double check(int[] a, int[] b) {
        int x = a[0] - b[0];
        int y = a[1] - b[1];
        return (double)y/x;
    }
}