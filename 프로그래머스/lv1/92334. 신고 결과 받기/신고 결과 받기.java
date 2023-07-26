import java.util.*;
import java.util.stream.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        ArrayList<String> names = new ArrayList<>(Arrays.asList(id_list));
        List<String> list = new ArrayList<>(Arrays.asList(report)).stream().distinct().sorted()
                                                                        .collect(Collectors.toList());
        int[][] reportList = new int[id_list.length][id_list.length];
        int[] reportedNums = new int[id_list.length];
        
        for(int i=0; i<list.size(); i++) {
            StringTokenizer st = new StringTokenizer(list.get(i));
            
            String reporter = st.nextToken();
            String reported = st.nextToken();
            
            int reporterIdx = names.indexOf(reporter);
            int reportedIdx = names.indexOf(reported);
            reportList[reporterIdx][reportedIdx] += 1;
            reportedNums[reportedIdx] += 1;
        }
        
        for(int i=0; i<reportedNums.length; i++) {
            if(reportedNums[i] >= k) {
                
                for(int j=0; j<reportList.length; j++) {
                    if(reportList[j][i] == 1) {
                        answer[j] += 1;
                    }
                }
            }
        }
        
        return answer;
    }
}