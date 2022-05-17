10430번 문제풀이

(A+B)%C는 ((A%C) + (B%C))%C 와 같을까?
(A×B)%C는 ((A%C) × (B%C))%C 와 같을까?
세 수 A, B, C가 주어졌을 때, 위의 네 가지 값을 구하는 프로그램을 작성하시오.


import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] str = br.readLine().split(" ");
        int A = Integer.parseInt(str[0]);
        int B = Integer.parseInt(str[1]);
        int C = Integer.parseInt(str[2]);


        bw.write(((A+B)%C)+"\n");
        bw.write((((A%C)+(B%C))%C)+"\n");
        bw.write(((A*B)%C)+"\n");
        bw.write(((A%C)*(B%C)%C)+"\n");

        bw.flush();
        bw.close();
    }
}