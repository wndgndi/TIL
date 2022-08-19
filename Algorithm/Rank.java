2012번 문제풀이

2007년 KOI에 N명의 학생들이 참가하였다. 경시일 전날인 예비소집일에, 모든 학생들은 자신이 N명 중에서 몇 등을 할 것인지 예상 등수를 적어서 제출하도록 하였다.
KOI 담당조교로 참가한 김진영 조교는 실수로 모든 학생의 프로그램을 날려 버렸다. 1등부터 N등까지 동석차 없이 등수를 매겨야 하는 김 조교는, 
어쩔 수 없이 각 사람이 제출한 예상 등수를 바탕으로 임의로 등수를 매기기로 했다.

자신의 등수를 A등으로 예상하였는데 실제 등수가 B등이 될 경우, 이 사람의 불만도는 A와 B의 차이 (|A - B|)로 수치화할 수 있다. 당신은 N명의 사람들의 불만도의 총 합을 최소로 하면서, 
학생들의 등수를 매기려고 한다.

각 사람의 예상 등수가 주어졌을 때, 김 조교를 도와 이러한 불만도의 합을 최소로 하는 프로그램을 작성하시오.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());   //  인원수를 문자열로 입력받아 정수로 변환
        int[] arr = new int[n];    // 크기가 n인 정수 배열 생성
        long sum=0;   // 합계를 구하기 위한 변수 sum (int의 범위를 넘어갈 수 있으므로 long 사용)

        for(int i=0; i<n; i++) {     // n번만큼 반복
           arr[i] = Integer.parseInt(br.readLine());   // 문자열을 입력받아 정수로 변환한 뒤
        }                                              // arr의 i번째 배열에 넣어줌
        Arrays.sort(arr);    // arr을 정렬해줌

        for(int i=1; i<=n; i++) {    // n번만큼 반복
            sum += Math.abs(i-arr[i-1]);   // i-(arr의 i-1번째 인덱스)의 절댓값을 변수 sum에
        }                                  // 더하여 누적합을 구해줌

        System.out.println(sum);   // sum을 출력
    }
}