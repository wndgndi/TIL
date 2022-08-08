import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int receipt = Integer.parseInt(br.readLine());   // 영수증에 적힌 금액
        int variety = Integer.parseInt(br.readLine());   // 구매한 물건의 종류
        int sum = 0;   // 실제 물건 값의 합

        String[] arr = new String[2];   // 물걱 가격과 물건 개수 두 가지만 필요

        for(int i=0; i<variety; i++) {    //   물건의 종류만큼 반복
          arr = br.readLine().split(" ");   // split을 통해 물건 가격과 개수로 나눠줌
          int a = Integer.parseInt(arr[0]);   // 물건 가격을 정수 a
          int b = Integer.parseInt(arr[1]);   // 물건 개수를 정수 b

          sum += a*b;  // 물건의 총합을 구하기 위해 종류별로 누적합을 구해줌 
        }

        if(sum == receipt) {    // 물건 실제 총합과 영수증의 금액이 같다면
            bw.write("Yes");    // Yes를 출력함
        } else {   // 금액이 다르다면
            bw.write("No");   // No를 출력함
        }
        bw.flush();
        bw.close();

    }
}
