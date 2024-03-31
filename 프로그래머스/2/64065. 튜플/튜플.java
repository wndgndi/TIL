import java.util.*;

class Solution {
    public int[] solution(String s) {
        int[] answer = {};
        s = s.substring(1, s.length()-1);
        String[] arr = s.split("}");
        List<String[]> list = new ArrayList<>();
        Set<Integer> set = new LinkedHashSet<>();
        
        for(int i=0; i<arr.length; i++) {
            if(!"".equals(arr[i])) {
                if(i == 0) {
                    arr[i] = arr[i].substring(1, arr[i].length());
                } else {
                    arr[i] = arr[i].substring(2, arr[i].length());
                }
                list.add(arr[i].split(","));                
            }
        }
        answer = new int[list.size()];
        
        Collections.sort(list, new Comparator<String[]>() {
            public int compare(String[] a, String[] b) {
                return a.length - b.length;
            }
        });
                
        for(int i=0; i<list.size(); i++) {
            for(int j=0; j<list.get(i).length; j++) {
                set.add(Integer.parseInt(list.get(i)[j]));
            }    
        }

        int idx = 0;
        for(Integer tuple : set) {              
            answer[idx++] = tuple;
        }
        
        return answer;
    }
}