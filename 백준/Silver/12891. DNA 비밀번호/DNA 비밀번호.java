import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int s = Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(st.nextToken());

        char[] dna = br.readLine().toCharArray();

        st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int g = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());

        int start = 0;
        int end = p-1;
        int[] arr = new int[4];
        int cnt = 0;

        for(int i=0; i<p; i++) {
            if(dna[i] == 'A') {
                arr[0]++;
            } else if(dna[i] == 'C') {
                arr[1]++;
            } else if(dna[i] == 'G') {
                arr[2]++;
            } else if(dna[i] == 'T') {
                arr[3]++;
            }
        }

        if(arr[0] >= a && arr[1] >= c && arr[2] >= g && arr[3] >= t) {
            cnt ++;
        }

        for(int i=p+1; i<=s; i++) {
            if(dna[start] == 'A') {
                arr[0]--;
            } else if(dna[start] == 'C') {
                arr[1]--;
            } else if(dna[start] == 'G') {
                arr[2]--;
            } else if(dna[start] == 'T') {
                arr[3]--;
            }

            start++;
            end++;

            if(dna[end] == 'A') {
                arr[0]++;
            } else if(dna[end] == 'C') {
                arr[1]++;
            } else if(dna[end] == 'G') {
                arr[2]++;
            } else if(dna[end] == 'T') {
                arr[3]++;
            }

            if(arr[0] >= a && arr[1] >= c && arr[2] >= g && arr[3] >= t) {
                cnt ++;
            }

        }
        bw.write(cnt + "\n");
        bw.flush();
        bw.close();
    }
}
