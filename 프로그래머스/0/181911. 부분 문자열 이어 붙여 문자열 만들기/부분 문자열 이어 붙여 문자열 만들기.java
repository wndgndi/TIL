class Solution {
    public String solution(String[] my_strings, int[][] parts) {
        StringBuilder sb = new StringBuilder();
        
        for(int i=0; i<my_strings.length; i++) {
            int[] arr = parts[i];
            String str = my_strings[i].substring(arr[0], arr[1]+1);
            
            sb.append(str);
        }
        
        return sb.toString();
    }
}