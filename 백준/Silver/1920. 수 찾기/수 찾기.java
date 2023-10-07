import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        List<Long> list1 = new ArrayList<>();
        List<Long> list2 = new ArrayList<>();

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        while (st.hasMoreTokens()) {
            list1.add(Long.parseLong(st.nextToken()));
        }

        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        while (st.hasMoreTokens()) {
            list2.add(Long.parseLong(st.nextToken()));
        }

        Collections.sort(list1);

        for(int i=0; i<m; i++) {
            bw.write(binarySearch(list1, list2.get(i), 0, list1.size()-1) + "\n");
        }

        bw.flush();
        bw.close();

    }

    public static int binarySearch(List<Long> list, long target, int start, int end) {
        while(start <= end) {
            int mid = (start + end) / 2;

            if (list.get(mid) == target) {
                return 1;
            } else if(list.get(mid) > target){
                end = mid - 1;
            } else if(list.get(mid) < target) {
                start = mid + 1;
            }
        }
        return 0;
    }

}
