import java.util.*;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        StringTokenizer st;
        List<Integer> list = new ArrayList<>();
        int[] todayDate = Arrays.stream(today.split("\\.")).mapToInt(Integer::parseInt).toArray();
        
        Map<String, Integer> map = new HashMap<>();
        for(String term : terms) {
            st = new StringTokenizer(term);
            
            String type = st.nextToken();
            int months = Integer.parseInt(st.nextToken());
            
            map.put(type, months);
        }
        
        for(int i=0; i<privacies.length; i++) {
            String privacy = privacies[i];
            st = new StringTokenizer(privacy);
            
            int[] date = Arrays.stream(st.nextToken().split("\\.")).mapToInt(Integer::parseInt).toArray();
            String type = st.nextToken();

            int termMonth = map.get(type);
            
            int year = date[0];
            int month = date[1];
            int day = date[2];
            
            month = month + termMonth;
            day -= 1;
            
            if(day == 0) {
                day = 28;
                month -= 1;
            }
            
            if(month > 12) {
                year =  year + month / 12;
                month = month - (month / 12) * 12;
            }
            
            if(month == 0) {
                month = 12;
                year -= 1;
            }
            int tDate = todayDate[0] * 10000 + todayDate[1] * 100 + todayDate[2];
            int pDate = year * 10000 + month * 100 + day;

            
            if(tDate > pDate) {
                list.add(i+1);
            }
        }
        
        return list.stream().mapToInt(i->i).toArray();
    }
}