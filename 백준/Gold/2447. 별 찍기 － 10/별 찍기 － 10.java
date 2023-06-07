import java.io.*;

public class Main {
    static char[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        arr = new char[n][n];

        stars(0, 0, n, false);

        for(int i=0; i<n; i++) {
            bw.write(arr[i]);
            bw.write("\n");
        }
        bw.flush();
        bw.close();
    }

    public static void stars(int x, int y, int n, boolean blank) {
        int size = n/3;
        int cnt = 0;

        if(blank) {
            for(int i=x; i<x+n; i++) {
                for(int j=y; j<y+n; j++) {
                    arr[i][j] = ' ';
                }
            }
            return;
        }

        if(n == 1) {
            arr[x][y] = '*';
            return;
        }

        for(int i=x; i<x+n; i+=size) {
            for(int j=y; j<y+n; j+=size) {
                cnt++;
                stars(i, j, size, cnt == 5);
            }
        }
    }
}