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
