4673번 문제

셀프 넘버는 1949년 인도 수학자 D.R. Kaprekar가 이름 붙였다. 양의 정수 n에 대해서 d(n)을 n과 n의 각 자리수를 더하는 함수라고 정의하자. 예를 들어, d(75) = 75+7+5 = 87이다.
양의 정수 n이 주어졌을 때, 이 수를 시작해서 n, d(n), d(d(n)), d(d(d(n))), ...과 같은 무한 수열을 만들 수 있다. 
예를 들어, 33으로 시작한다면 다음 수는 33 + 3 + 3 = 39이고, 그 다음 수는 39 + 3 + 9 = 51, 다음 수는 51 + 5 + 1 = 57이다. 이런식으로 다음과 같은 수열을 만들 수 있다.
33, 39, 51, 57, 69, 84, 96, 111, 114, 120, 123, 129, 141, ...
n을 d(n)의 생성자라고 한다. 위의 수열에서 33은 39의 생성자이고, 39는 51의 생성자, 51은 57의 생성자이다. 생성자가 한 개보다 많은 경우도 있다. 예를 들어, 101은 생성자가 2개(91과 100) 있다. 
생성자가 없는 숫자를 셀프 넘버라고 한다. 100보다 작은 셀프 넘버는 총 13개가 있다. 1, 3, 5, 7, 9, 20, 31, 42, 53, 64, 75, 86, 97
10000보다 작거나 같은 셀프 넘버를 한 줄에 하나씩 출력하는 프로그램을 작성하시오.


import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        List<Integer> list = new ArrayList<>();  // 셀프넘버의 개수를 알 수 없으므로 리스트 사용
        int sum = 0;  // 셀프넘버를 구하기 위한 변수

        for(int i=1; i<=10000; i++) {  //  1부터 10000까지 반복
            list.add(i);   // 리스트에 1부터 10000까지 넣어준다
        }

        for(int i=1; i<=10000; i++) {   // 1부터 10000까지 반복
          String str = String.valueOf(i);   // 정수 i를 문자열로 변환
          String[] st = str.split("");   // 문자열을 각 문자를 나눈다
          sum = i;  // 셀프넘버를 구하기 위해 sum의 값을 i와 같게 한다
          for(int j=0; j<st.length; j++) {    // 배열 st의 길이만큼 반복
            int[] arr = new int[st.length];   // st의 길이만큼의 정수 배열 arr 생성
            arr[j] = Integer.parseInt(st[j]);  // arr의 j번째 인덱스에 st의 j번째 인덱스를 정수로 변환하여 넣어줌
            sum += arr[j];  // sum에 arr의 j번째 인덱스를 더해줌
          }
          list.remove(Integer.valueOf(sum));  // list에 sum과 일치하는 값이 있으면 제거한다
        }
        for(int i=0; i<list.size(); i++) {  // list의 크기만큼 반복
            bw.write(list.get(i) + "\n");   // list의 i번째 인덱스를 출력한다
        }
        bw.flush();
        bw.close();
    }
}
