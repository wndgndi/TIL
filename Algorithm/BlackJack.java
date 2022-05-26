import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str = br.readLine();
        String[] st = str.split(" ");

        int n = Integer.parseInt(st[0]);
        int m = Integer.parseInt(st[1]);
        int sum = 0;

        String l = br.readLine();
        String[] strcard = l.split(" ");

        int[] card = new int[strcard.length];
        List<Integer> list = new ArrayList<>();

        for(int i=0; i< strcard.length; i++) {
           card[i] = Integer.parseInt(strcard[i]);
        }

        for(int i=0; i<n-2; i++) {
            for(int j=i+1; j<n-1; j++) {
                for(int k=j+1; k<n; k++) {
                   sum = card[i] + card[j] + card[k];

                   if(sum<=m) {
                        list.add(sum);
                   }
                }

            }
        }
        list.sort(Comparator.reverseOrder());
        bw.write(list.get(0)+"\n");
        bw.flush();
        bw.close();
    }
}
