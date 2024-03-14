import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    Map<Integer, ArrayList<String>> color = new HashMap<>();
    PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
    int[] nums = new int[5];

    StringTokenizer st = new StringTokenizer(br.readLine());
    String c = st.nextToken();
    int n = Integer.parseInt(st.nextToken());
    color.put(n, new ArrayList<>());
    color.get(n).add(c);
    nums[0] = n;
    int cnt = 1;

    for (int i = 0; i < 4; i++) {
      st = new StringTokenizer(br.readLine());
      String c2 = st.nextToken();
      if (c.equals(c2)) {
        cnt++;
      }

      n = Integer.parseInt(st.nextToken());
      color.putIfAbsent(n, new ArrayList<>());
      color.get(n).add(c2);

      nums[i+1] = n;
    }

    Arrays.sort(nums);
    List<Map.Entry<Integer, ArrayList<String>>> entries = new ArrayList<>(color.entrySet());
    entries.sort(new Comparator<Entry<Integer, ArrayList<String>>>() {
      @Override
      public int compare(Entry<Integer, ArrayList<String>> o1,
          Entry<Integer, ArrayList<String>> o2) {
        return o2.getValue().size() - o1.getValue().size();
      }
    });

    if (cnt == 5) {
      if (nums[4] - nums[3] == 1 && nums[3] - nums[2] == 1 && nums[2] - nums[1] == 1 && nums[1] - nums[0] == 1) {
        pq.add(nums[4] + 900);
      } else {
        pq.add(nums[4] + 600);
      }
    }

    if(entries.get(0).getValue().size() == 4) {
      pq.add(entries.get(0).getKey() + 800);
    }

    if(entries.get(0).getValue().size() == 3) {
      if(entries.get(1).getValue().size() == 2) {
        pq.add(entries.get(0).getKey() * 10 + entries.get(1).getKey() + 700);
      } else {
        pq.add((entries.get(0).getKey() + 400));
      }
    }

    if(entries.get(0).getValue().size() == 2) {
      if(entries.get(1).getValue().size() == 2) {
        pq.add(Math.max(entries.get(0).getKey(), entries.get(1).getKey()) * 10 + Math.min(entries.get(0).getKey(), entries.get(1).getKey()) + 300);
      } else {
        pq.add(entries.get(0).getKey() + 200);
      }
    }

    if(nums[4] - nums[3] == 1 && nums[3] - nums[2] == 1 && nums[2] - nums[1] == 1 && nums[1] - nums[0] == 1) {
      pq.add(nums[4] + 500);
    }

    pq.add(nums[4] + 100);
    bw.write(pq.poll() + "\n");
    bw.flush();
    bw.close();
  }
}
