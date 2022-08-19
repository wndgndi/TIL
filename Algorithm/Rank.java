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