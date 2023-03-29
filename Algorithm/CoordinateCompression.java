백준 18870 좌표 압축 문제풀이

수직선 위에 N개의 좌표 X1, X2, ..., XN이 있다. 이 좌표에 좌표 압축을 적용하려고 한다.

Xi를 좌표 압축한 결과 X'i의 값은 Xi > Xj를 만족하는 서로 다른 좌표의 개수와 같아야 한다.

X1, X2, ..., XN에 좌표 압축을 적용한 결과 X'1, X'2, ..., X'N를 출력해보자.


< 코드 Java >

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());   // 좌표의 개수 
        int[] arr = new int[n];   

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {   // n번 반복
            arr[i] = Integer.parseInt(st.nextToken());  // 좌표들 토큰으로 넣어줌
        }

        int[] tmp = Arrays.stream(arr).distinct().sorted().toArray();  // 중복 제거, 정렬

        Map<Integer, Integer> map = new HashMap<>();  
        for (int i = 0; i < tmp.length; i++) {  // tmp 길이만큼 반복 
            map.put(tmp[i], i);   // map의 키에 좌표, 값에 인덱스를 넣어줌
        }

        for(int i=0; i<arr.length; i++) {   // arr의 길이만큼 반복
            bw.write(map.get(arr[i]) + " ");   // arr의 i번 인덱스 값을 키로 갖는 map의 값 출력
        }
        bw.flush();
        bw.close();
    }

}
