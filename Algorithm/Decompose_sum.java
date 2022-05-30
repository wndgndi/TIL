2231번 문제

어떤 자연수 N이 있을 때, 그 자연수 N의 분해합은 N과 N을 이루는 각 자리수의 합을 의미한다. 어떤 자연수 M의 분해합이 N인 경우, M을 N의 생성자라 한다. 예를 들어, 245의 분해합은 256(=245+2+4+5)이 된다. 따라서 245는 256의 생성자가 된다. 물론, 어떤 자연수의 경우에는 생성자가 없을 수도 있다. 반대로, 생성자가 여러 개인 자연수도 있을 수 있다.
자연수 N이 주어졌을 때, N의 가장 작은 생성자를 구해내는 프로그램을 작성하시오.


import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());  // 문자열을 입력받아 정수로 변환
        int[] arr = new int[7];  // n이 최대 1000000까지 가능하므로 7자리 배열 만들어줌
        int sum = 0;  // sum 변수 선언, 초기화

        for(int i=0; i<n; i++) {   // n번 만큼 반복
            String s = Integer.toString(i);  // 정수 i를 문자열 s로 변환
            int k = i;   // 변수 k의 값은 i와 같다
            for(int j=0; j<s.length(); j++) {   // 문자열 s의 길이만큼 반복
                sum += k%10;  // k를 10으로 나눈 나머지를 변수 sum에 누적해서 더해줌
                k = k/10;  // 10으로 나눈 k의 값을 k에 넣어줌
            }
            if(i+sum == n) {    // 만약 i+sum이 n과 같다면 
                bw.write(i+"\n");   // i를 출력한다
                break;
            }
            else if(i == n-1) {    // i의 값이 n-1과 같을 경우
                if(i+sum != n) {    //  i+sum이 n과 같지 않다면
                    bw.write("0\n");  // 0을 출력한다
                }
            }
            sum = 0;
        }
        bw.flush();
        bw.close();
    }
}