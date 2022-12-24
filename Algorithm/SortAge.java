백준 10814번 문제

온라인 저지에 가입한 사람들의 나이와 이름이 가입한 순서대로 주어진다. 이때, 회원들을 나이가 증가하는 순으로, 
나이가 같으면 먼저 가입한 사람이 앞에 오는 순서로 정렬하는 프로그램을 작성하시오.


< 코드 >

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class AgeSort {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

         int n = Integer.parseInt(br.readLine());
         String[][] str = new String[n][2];
         StringTokenizer st;


         for(int i=0; i<n; i++) {   // n번만큼 반복
            st = new StringTokenizer(br.readLine());
            str[i][0] = st.nextToken();   // i행0열에 나이 넣어줌
            str[i][1] = st.nextToken();   // i행1열에 이름 넣어줌
         }

        Arrays.sort(str, (a,b) -> {
                return Integer.parseInt(a[0])-Integer.parseInt(b[0]);  // 나이 기준 오름차순 정렬
        });

         for(int i=0; i<n; i++) {   // n번만큼 반복
             bw.write(str[i][0] + " " + str[i][1] + "\n");  
         }
         bw.flush();
         bw.close();
    }

}