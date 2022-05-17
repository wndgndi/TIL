import java.io.*;

public class Main {
    public static int gcd(int a, int b) {
        if(b == 0) return a;
        else return gcd(b, a%b);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] str = br.readLine().split(" ");  // 입력받은 문자열 공백을 기준으로 나눔
        int a = Integer.parseInt(str[0]);   // 0번째 인덱스의 정수는 a
        int b = Integer.parseInt(str[1]);   // 1번째 인덱스의 정수는 b

        int gcd = gcd(a,b);   // 최대공약수를 구하는 gcd
        int lcm = (a*b)/gcd;   // 최소공배수를 구하는 lcm

        bw.write(gcd +"\n" + lcm);   // gcd와 lcm을 출력
        bw.flush();
        bw.close();
    }
}