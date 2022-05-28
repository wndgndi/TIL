9613번 문제

첫째 줄에 테스트 케이스의 개수 t (1 ≤ t ≤ 100)이 주어진다. 각 테스트 케이스는 한 줄로 이루어져 있다. 각 테스트 케이스는 수의 개수 n (1 < n ≤ 100)가 주어지고, 다음에는 n개의 수가 주어진다. 입력으로 주어지는 수는 1,000,000을 넘지 않는다.


import java.io.*;

public class Main {
    public static int gcd(int a, int b) {   // 최대공약수 gcd를 구하기 위한 메소드
       if(a%b == 0) return b;  // 만약 a%b가 0이면 b를 리턴한다
       return gcd(b,a%b);  // a%b가 0이 아니면 gcd의 매개변수로 b와 a%b를 넣어준다
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());   // 문자열을 입력받아서 정수로 변환
        long sum=0;  // long 타입의 변수 sum 선언, 초기화

        for(int i=0; i<n; i++) {  // n번만큼 반복
            String str = br.readLine();   // 문자열 str을 입력받음
            String[] st = str.split(" ");  // 문자열 배열 st에 str을 공백을 구분자로 나눔 
            int g = Integer.parseInt(st[0]);  // 배열 st의 0번 인덱스를 정수로 변환
            for(int j=1; j<= g-1; j++) {  // g-1번만큼 반복
                for(int k=j+1; k<= g; k++) {  // g번만큼 반복
                    sum += gcd(Integer.parseInt(st[j]), Integer.parseInt(st[k]));
// st의 j번 인덱스와 k번 인덱스를 정수로 변환하여 gcd의 매개변수로 사용하고 값을 누적해서 더한다
                }
            }
            bw.write(sum+"\n");   // sum을 출력한다
            sum=0;
        }

        bw.flush();
        bw.close();
    }
}