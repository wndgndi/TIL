백준 2485 가로수 문제

직선으로 되어있는 도로의 한 편에 가로수가 임의의 간격으로 심어져있다. KOI 시에서는 가로수들이 모두 같은 간격이 되도록 가로수를 추가로 심는 사업을 추진하고 있다. 
KOI 시에서는 예산문제로 가능한 한 가장 적은 수의 나무를 심고 싶다.

편의상 가로수의 위치는 기준점으로 부터 떨어져 있는 거리로 표현되며, 가로수의 위치는 모두 양의 정수이다.

예를 들어, 가로수가 (1, 3, 7, 13)의 위치에 있다면 (5, 9, 11)의 위치에 가로수를 더 심으면 모든 가로수들의 간격이 같게 된다. 
또한, 가로수가 (2, 6, 12, 18)에 있다면 (4, 8, 10, 14, 16)에 가로수를 더 심어야 한다.

심어져 있는 가로수의 위치가 주어질 때, 모든 가로수가 같은 간격이 되도록 새로 심어야 하는 가로수의 최소수를 구하는 프로그램을 작성하라. 
단, 추가되는 나무는 기존의 나무들 사이에만 심을 수 있다.


< 코드 Java >

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());   // 가로수의 수
        int[] arr = new int[n];  
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {   // n번 반복
            arr[i] = Integer.parseInt(br.readLine());   // 가로수들 넣어줌
        }

        for (int i = n - 1; i > 0; i--) {   // n-1번 반복
            list.add(arr[i] - arr[i - 1]);  // 가로수 사이 거리들 넣어줌
        }

        int gcd = gcd(list.get(0), list.get(1));  // 첫번째, 두번째 가로수 사이 거리의 최대공약수

        for(int i=2; i<list.size(); i++) {   // 리스트 크기만큼 반복
            gcd = gcd(gcd, list.get((i)));   // 모든 거리들의 최대공약수 구함
        }

        Arrays.sort(arr);   // arr 오름차순 정렬
        int start = arr[0];  // 0번 인덱스 값이 시작점
        int end = arr[arr.length - 1];   // 마지막 인덱스 값이 종점
        int cnt = 1;   // 필요한 가로수를 구하기 위한 변수

        for (int i = start; i < end; i += gcd) {  // 시작점부터 최대공약수만큼 늘리며 반복
            cnt++;  // cnt가 1 증가
        }

        bw.write((cnt-arr.length) + "\n");   // 필요한 가로수 개수 출력
        bw.flush();
        bw.close();
    }

    public static int gcd(int a, int b) {
        if (a % b == 0) {
            return b;
        } else {
            return gcd(b, a % b);
        }
    }

}
