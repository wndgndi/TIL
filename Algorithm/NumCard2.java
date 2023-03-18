백준 10816번 문제

숫자 카드는 정수 하나가 적혀져 있는 카드이다. 상근이는 숫자 카드 N개를 가지고 있다. 
정수 M개가 주어졌을 때, 이 수가 적혀있는 숫자 카드를 상근이가 몇 개 가지고 있는지 구하는 프로그램을 작성하시오.


< 코드 Java >

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        HashMap<Integer, Integer> map = new HashMap<>();

        int n = Integer.parseInt(br.readLine());   // 상근이가 가진 카드 개수
        st = new StringTokenizer(br.readLine());   // 상근이가 가진 카드들 문자열로 입력받음

        for(int i=0; i<n; i++) {    // n번 나복
            int card = Integer.parseInt(st.nextToken());    // 카드를 정수로 변환
            map.merge(card, 1, Integer::sum);   
         // 키로 card를 넣고 값으로 1을 넣어주나, 중복된 키가 들어오면 값을 누적하여 더해서 덮어씌움  
        }

        int m = Integer.parseInt(br.readLine());  // 검사해야 할 카드 개수
        int[] arr = new int[m];
        st = new StringTokenizer(br.readLine());  // 검사할 카드들 문자열로 입력받음
        for(int i=0; i<m; i++) {     // m번 반복
            arr[i] = Integer.parseInt(st.nextToken());  // 검사할 카드들 정수로 변환하여 넣어줌
        }

        for(int i=0; i<m; i++) {   // m번 반복
            if(map.get(arr[i]) != null) {   // 키 arr[i]에 맵핑된 값이 null이 아니라면,
                bw.write(map.get(arr[i]) + " ");  // 키 arr[i]에 맵핑된 값 출력
            } else {  // 키 arr[i]에 맵핑된 값이 null이라면,
                bw.write("0 ");   // 0을 출력
            }
        }

        bw.flush();
        bw.close();
    }

}