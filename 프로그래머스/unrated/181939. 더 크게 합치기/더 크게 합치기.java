class Solution {
    public int solution(int a, int b) {
        StringBuilder sb = new StringBuilder();
        sb.append(String.valueOf(a));
        sb.append(String.valueOf(b));
        int num1 = Integer.parseInt(sb.toString());
        sb.setLength(0);
        
        sb.append(String.valueOf(b));
        sb.append(String.valueOf(a));
        int num2 = Integer.parseInt(sb.toString());
      
        int answer = Math.max(num1, num2);
        return answer;
    }
}