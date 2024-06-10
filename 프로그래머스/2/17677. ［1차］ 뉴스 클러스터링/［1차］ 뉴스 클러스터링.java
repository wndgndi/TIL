import java.util.ArrayList;

class Solution {
    public int solution(String str1, String str2) {
        ArrayList<String> list1 = strToList(str1);
        ArrayList<String> list2 = strToList(str2);

        ArrayList<String> list3 = new ArrayList<>(list1);
        for (String s : list2) {
            list3.remove(s);
        }

        int intersection = list1.size() - list3.size(); 
        int union = list2.size() + list3.size(); 

        return union == 0 ? 65536 : (int) ((double) intersection / union * 65536);
    }

    private ArrayList<String> strToList(String str) {
        int sl = str.length();
        str = str.toUpperCase();
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < sl - 1; i++) {
            String pair = str.substring(i, i + 2);
            if (pair.matches("^[A-Z]{2}$")) {
                list.add(pair);
            }
        }
        return list;
    }
}
