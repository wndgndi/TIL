import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int n = Integer.parseInt(br.readLine());
    String[][] room = new String[n][n];

    for(int i=0; i<n; i++) {
      room[i] = br.readLine().split("");
    }

    int width = 0;

    for(int i=0; i<n; i++) {
      int cnt = 0;
      for(int j=0; j<n; j++) {
        if(".".equals(room[i][j])) {
          cnt++;
        } else if("X".equals(room[i][j])) {
            if(cnt >= 2) {
              width++;
            }
          cnt = 0;
        }
      }
      if(cnt >= 2) {
        width++;
      }
    }

    int length = 0;
    for(int i=0; i<n; i++) {
      int cnt = 0;
      for(int j=0; j<n; j++) {
        if(".".equals(room[j][i])) {
          cnt++;
        } else if("X".equals(room[j][i])) {
            if(cnt >= 2) {
              length++;
            }
          cnt = 0;
        }
      }
      if(cnt >= 2) {
        length++;
      }
    }

    bw.write(width + " " + length);
    bw.flush();
    bw.close();
  }
}
