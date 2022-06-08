1065번 문제풀이

어떤 양의 정수 X의 각 자리가 등차수열을 이룬다면, 그 수를 한수라고 한다. 등차수열은 연속된 두 개의 수의 차이가 일정한 수열을 말한다. N이 주어졌을 때, 1보다 크거나 같고, N보다 작거나 같은 한수의 개수를 출력하는 프로그램을 작성하시오. 


import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int cnt=0;

        if(n>0 && n<100) {
            bw.write(n + "\n");
        }

        else if(n>=100) {
            for(int i=100; i<=n; i++) {
                String str = String.valueOf(i);
                String[] st = str.split("");
                int a = Integer.parseInt(st[0]);
                int b = Integer.parseInt(st[1]);
                int c = Integer.parseInt(st[2]);

                if((a-b == b-c) || (c-b == b-a)) {
                   cnt++;
               }
            }
            bw.write((cnt+99)+"\n");
        }
        bw.flush();
        bw.close();
    }
}